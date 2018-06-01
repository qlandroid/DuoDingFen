package org.ddf.app;

import android.ql.bindview.BindView;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ddf.app.base.BaseActivity;

@Layout(layoutRes = R.layout.activity_login, titleRes = R.string.app_name)
public class LoginActivity extends BaseActivity {

    @BindView(R.id.activity_login_et_phone)
    EditText etPhone;//输入手机号码
    @BindView(R.id.activity_login_et_auth_code)
    EditText etAuthCode;//验证码
    @BindView(R.id.activity_login_tv_action_get_auth_code)
    TextView tvActionGetAuthCod;//获得验证码

    @Override
    public void initWidget() {
        super.initWidget();
        tvActionGetAuthCod.setOnClickListener(this);
    }

    @Override
    public void forbidClick(View v) {
        super.forbidClick(v);
        int id = v.getId();
        switch (id) {
            case R.id.activity_login_tv_action_get_auth_code://获得验证码
                break;

        }
    }
}
