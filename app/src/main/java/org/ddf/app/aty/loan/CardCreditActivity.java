package org.ddf.app.aty.loan;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.ql.bindview.BindView;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionDenied;
import com.zhy.m.permission.PermissionGrant;

import org.ddf.app.R;
import org.ddf.app.aty.HomeActivity;
import org.ddf.app.base.BaseActivity;
import org.ddf.app.base.Layout;
import org.ddf.app.utils.CardCheckHelper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

@Layout(layoutRes = R.layout.activity_card_credit)
public class CardCreditActivity extends BaseActivity {

    private static final int REQUEST_CAMERA = 55;
    private static final int SHOOT_ID_CARD_FRONT_RESULT = 0x221;
    private static final int SHOOT_ID_CARD_SIDE_RESULT = 0x222;

    @BindView(R.id.activity_card_credit_1)
    View v;
    @BindView(R.id.activity_card_credit_iv_0)
    ImageView iv0;

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initWidget() {
        super.initWidget();
        v.setOnClickListener(this);

    }

    @Override
    public void forbidClick(View v) {
        super.forbidClick(v);

        MPermissions.requestPermissions(this, REQUEST_CAMERA
                , Manifest.permission.CAMERA
                , Manifest.permission.READ_PHONE_STATE
        );
    }

    private static final String TAG = "CardCreditActivity";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case SHOOT_ID_CARD_FRONT_RESULT:
            case SHOOT_ID_CARD_SIDE_RESULT:
                if (resultCode != Activity.RESULT_OK) {
                    return;
                }
                Bitmap bitmap = null;
                String backUrl = ShootIdCardActivity.getData(data);
                CardCheckHelper.okHttpUpload(backUrl, new CardCheckHelper.UploadCallback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        try {
                            String string = response.body().string();
                            Log.i(TAG, "onResponse: " + string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.i(TAG, "onFailure: ");
                        e.printStackTrace();
                    }
                });
                if (!TextUtils.isEmpty(backUrl)) {
                    bitmap = getCompressPhoto(backUrl);
                    iv0.setImageBitmap(bitmap);
                } else {

                }
                break;

            default:
                super.onActivityResult(requestCode, resultCode, data);
        }


    }

    /**
     * 把原图按1/2的比例压缩
     *
     * @param path 原图的路径
     * @return 压缩后的图片
     */
    public static Bitmap getCompressPhoto(String path) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = 2;  // 图片的大小设置为原来的二分之一
        Bitmap bmp = BitmapFactory.decodeFile(path, options);
        options = null;
        return bmp;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(REQUEST_CAMERA)
    public void requestSdcardSuccess() {
        // Toast.makeText(this, "GRANT ACCESS SDCARD!", Toast.LENGTH_SHORT).show();
        //同意
        boolean isf = false;
        if (isf) {
            Intent intent = new Intent(this, ShootIdCardActivity.class);
            String tips = getResources().getString(R.string.shoot_id_card_front);
            intent.putExtra("tips", tips);
            intent.putExtra("tag", 0);
            startActivityForResult(intent, SHOOT_ID_CARD_FRONT_RESULT);
        }


        Intent intent = new Intent(this, ShootIdCardActivity.class);
        String tips = getResources().getString(R.string.shoot_id_card_side);
        intent.putExtra("tips", tips);
        intent.putExtra("tag", 1);
        startActivityForResult(intent, SHOOT_ID_CARD_SIDE_RESULT);

    }

    @PermissionDenied(REQUEST_CAMERA)
    public void requestSdcardFailed() {
        QMUIDialog dialog = new QMUIDialog.MessageDialogBuilder(this)
                .setTitle("权限问题2")
                .setMessage("如没有该权限可能会导致程序崩溃，带来体验效果不佳，请赋予本app所需要的权限")
                .create();
        dialog.show();
//拒绝
        //Toast.makeText(this, "DENY ACCESS SDCARD!", Toast.LENGTH_SHORT).show();
    }
}
