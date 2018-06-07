package org.ddf.app.aty;

import android.ql.bindview.BindView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.ddf.app.C;
import org.ddf.app.base.Layout;
import org.ddf.app.R;
import org.ddf.app.base.BaseActivity;
import org.ddf.app.utils.ActivityUtils;

import java.util.Timer;
import java.util.TimerTask;


@Layout(layoutRes = R.layout.activity_login, titleRes = R.string.app_name, backRes = 0)
public class LoginActivity extends BaseActivity {
    public static final int TIME_OUT = 3;
    @BindView(R.id.activity_login_et_phone)
    EditText etPhone;//输入手机号码
    @BindView(R.id.activity_login_et_auth_code)
    EditText etAuthCode;//验证码
    @BindView(R.id.activity_login_tv_action_get_auth_code)
    TextView tvActionGetAuthCod;//获得验证码
    @BindView(R.id.activity_login_tv_login)
    View tvLogin;
    @BindView(R.id.activity_login_iv)
    ImageView iv;

    int timeOut;

    @Override
    public void initData() {
        super.initData();
        ActivityUtils.singleAty(this);
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tvActionGetAuthCod.setOnClickListener(this);
        tvLogin.setOnClickListener(this);

        ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
        layoutParams.height = C.SCREEN_HEIGHT_3;
        iv.setLayoutParams(layoutParams);
    }

    @Override
    public void forbidClick(View v) {
        super.forbidClick(v);
        int id = v.getId();
        switch (id) {
            case R.id.activity_login_tv_action_get_auth_code://获得验证码
                startRegSendSms();
                break;
            case R.id.activity_login_tv_login:
                startActivity(HomeActivity.class);
                break;

        }
    }

    Timer timer;

    private void startRegSendSms() {
        timeOut = TIME_OUT;
        if (timer == null) {
            timer = new Timer();
        }
        tvActionGetAuthCod.setSelected(true);
        tvActionGetAuthCod.setClickable(false);


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (timeOut >= 0) {
                            timeOut--;
                            tvActionGetAuthCod.setText(String.format("再次发送(%d)", timeOut));
                            if (timeOut <= 0) {
                                if (timer != null) {
                                    timer.cancel();
                                    timer = null;
                                }

                                tvActionGetAuthCod.setText("获取验证码");
                                tvActionGetAuthCod.setSelected(false);
                                tvActionGetAuthCod.setClickable(true);
                            }
                        } else {
                            if (timer != null) {
                                timer.cancel();
                                timer = null;
                            }
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask, 1_000, 1_000);
        tvActionGetAuthCod.setText(String.format("再次发送(%d)", timeOut));
    }
}
