package org.ddf.app.aty.loan;

import android.ql.bindview.BindView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.ddf.app.R;
import org.ddf.app.base.BaseActivity;
import org.ddf.app.base.Layout;

@Layout(layoutRes = R.layout.activity_hospital)
public class HospitalActivity extends BaseActivity {
    @BindView(R.id.activity_hospital_tv_yes)
    TextView tvYes;


    @Override
    public void initWidget() {
        super.initWidget();
        tvYes.setOnClickListener(this);
    }

    @Override
    public void forbidClick(View v) {
        super.forbidClick(v);
        int id = v.getId();
        switch (id) {
            case R.id.activity_hospital_tv_yes:
                break;
        }
    }
}
