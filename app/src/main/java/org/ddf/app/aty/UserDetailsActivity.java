package org.ddf.app.aty;

import android.os.Build;
import android.os.Bundle;
import android.ql.bindview.BindView;
import android.view.View;
import android.widget.TextView;

import com.qmuiteam.qmui.util.QMUIPackageHelper;

import org.ddf.app.R;
import org.ddf.app.base.BaseActivity;
import org.ddf.app.base.Layout;
import org.ddf.app.utils.ActivityUtils;

@Layout(layoutRes = R.layout.activity_user_details,titleRes = R.string.app_name)
public class UserDetailsActivity extends BaseActivity {

    @BindView(R.id.activity_user_details_tv_card)
    TextView tvCard;
    @BindView(R.id.activity_user_details_tv_name)
    TextView tvName;
    @BindView(R.id.activity_user_details_tv_phone)
    TextView tvPhone;
    @BindView(R.id.activity_user_details_tv_version)
    TextView tvVersion;//系统版本号
    @BindView(R.id.activity_user_details_tv_logout)
    View tvLogout;//退出登陆

    @Override
    public void initWidget() {
        super.initWidget();
        tvLogout.setOnClickListener(this);

        String appVersion = QMUIPackageHelper.getAppVersion(this);
        tvVersion.setText(appVersion);
    }


    @Override
    public void forbidClick(View v) {
        super.forbidClick(v);
        int id = v.getId();
        switch (id) {
            case R.id.activity_user_details_tv_logout:
                startActivity(LoginActivity.class);
                break;
        }
    }
}
