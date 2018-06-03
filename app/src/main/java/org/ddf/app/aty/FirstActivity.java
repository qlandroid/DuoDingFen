package org.ddf.app.aty;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qmuiteam.qmui.util.QMUIDeviceHelper;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionDenied;
import com.zhy.m.permission.PermissionGrant;

import org.ddf.app.R;
import org.ddf.app.base.BaseActivity;
import org.ddf.app.base.Layout;

@Layout(layoutRes = R.layout.activity_first,bindTopBar = false)
public class FirstActivity extends BaseActivity {
    private final int REQUEST_CODE_ASK_CAMERA = 2;

    @Override
    public void initData() {
        MPermissions.requestPermissions(this, REQUEST_CODE_ASK_CAMERA
                , Manifest.permission.CAMERA
                , Manifest.permission.READ_PHONE_STATE
                , Manifest.permission.RECORD_AUDIO
                , Manifest.permission.WRITE_EXTERNAL_STORAGE
                , Manifest.permission.READ_EXTERNAL_STORAGE
                , Manifest.permission.ACCESS_FINE_LOCATION
        );
        QMUIDisplayHelper.setFullScreen(this);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(REQUEST_CODE_ASK_CAMERA)
    public void requestSdcardSuccess() {
        // Toast.makeText(this, "GRANT ACCESS SDCARD!", Toast.LENGTH_SHORT).show();
        //同意
        startActivity(HomeActivity.class);
        finish();
    }

    @PermissionDenied(REQUEST_CODE_ASK_CAMERA)
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
