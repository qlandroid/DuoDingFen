package org.ddf.app;

import org.ddf.app.base.BaseActivity;

@Layout(layoutRes = R.layout.activity_main, title = "测试", bindTopBar = false)
public class MainActivity extends BaseActivity {


    @Override
    public void initWidget() {
        super.initWidget();
        startActivity(LoginActivity.class);
        finish();
    }
}
