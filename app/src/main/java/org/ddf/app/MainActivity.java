package org.ddf.app;

import org.ddf.app.aty.FirstActivity;
import org.ddf.app.aty.LoginActivity;
import org.ddf.app.aty.loan.CardCreditActivity;
import org.ddf.app.base.BaseActivity;
import org.ddf.app.base.Layout;

@Layout(layoutRes = R.layout.activity_main, title = "测试", bindTopBar = false)
public class MainActivity extends BaseActivity {


    @Override
    public void initWidget() {
        super.initWidget();
//        startActivity(FirstActivity.class);
        startActivity(CardCreditActivity.class);
        finish();
    }


}
