package org.ddf.app.aty;

import android.ql.bindview.BindView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.qmuiteam.qmui.util.QMUIDeviceHelper;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

import org.ddf.app.base.Layout;
import org.ddf.app.R;
import org.ddf.app.base.BaseActivity;

@Layout(layoutRes = R.layout.activity_login, titleRes = R.string.app_name, backRes = 0)
public class LoginActivity extends BaseActivity {

    @BindView(R.id.activity_login_et_phone)
    EditText etPhone;//输入手机号码
    @BindView(R.id.activity_login_et_auth_code)
    EditText etAuthCode;//验证码
    @BindView(R.id.activity_login_tv_action_get_auth_code)
    TextView tvActionGetAuthCod;//获得验证码
    @BindView(R.id.activity_login_tv_login)
    View tvLogin;

    @Override
    public void initWidget() {
        super.initWidget();
        tvActionGetAuthCod.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void forbidClick(View v) {
        super.forbidClick(v);
        int id = v.getId();
        switch (id) {
            case R.id.activity_login_tv_action_get_auth_code://获得验证码
                break;
            case R.id.activity_login_tv_login:
                startActivity(HomeActivity.class);
                break;

        }
    }
}
