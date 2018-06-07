package org.ddf.app.aty.loan;

import android.ql.bindview.BindView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;

import org.ddf.app.R;
import org.ddf.app.aty.loan.HospitalActivity;
import org.ddf.app.base.BaseActivity;
import org.ddf.app.base.Layout;

import java.util.List;

@Layout(layoutRes = R.layout.activity_input_user_details, titleRes = R.string.title_input_user_details)
public class InputUserDetailsActivity extends BaseActivity {

    @BindView(R.id.activity_input_user_details_education_group)
    ViewGroup educationGroup;
    @BindView(R.id.activity_input_user_details_tv_education)
    TextView tvEducation;
    @BindView(R.id.activity_input_user_details_job_group)
    ViewGroup jobGroup;
    @BindView(R.id.activity_input_user_details_tv_job)
    TextView tvJob;
    @BindView(R.id.activity_input_user_details_marriage_group)
    ViewGroup marriageGroup;
    @BindView(R.id.activity_input_user_details_tv_marriage)
    TextView tvMarriage;
    @BindView(R.id.activity_input_user_details_et_address)
    EditText etAddress;
    @BindView(R.id.activity_input_user_details_et_name)
    EditText etName;
    @BindView(R.id.activity_input_user_details_et_phone)
    EditText etPhone;
    @BindView(R.id.activity_input_user_details_et_price)
    EditText etPrice;
    @BindView(R.id.activity_input_user_details_tv_next)
    TextView tvNext;

    @Override
    public void initWidget() {
        super.initWidget();
        educationGroup.setOnClickListener(this);
        jobGroup.setOnClickListener(this);
        marriageGroup.setOnClickListener(this);
        tvNext.setOnClickListener(this);
    }


    @Override
    public void forbidClick(View v) {
        super.forbidClick(v);
        int id = v.getId();
        switch (id) {
            case R.id.activity_input_user_details_education_group://学校选择
                break;
            case R.id.activity_input_user_details_marriage_group://婚姻状况
                break;
            case R.id.activity_input_user_details_job_group://工作状况
                break;
            case R.id.activity_input_user_details_tv_next:
                startActivity(HospitalActivity.class);
                break;
        }
    }

    /**
     * 显示选择框
     *
     * @param tags
     */
    private void displayBottom(List tags) {
        OptionsPickerView o = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
              /*  MultiItemEntity multiItemEntity = list.get(selectPosition);

                if (multiItemEntity instanceof ReleaseHouseSelectEntity) {
                    ReleaseHouseSelectEntity sm = (ReleaseHouseSelectEntity) multiItemEntity;
                    ITag selectTag = sm.getTags().get(options1);
                    selectTag.setSelect(true);
                    sm.setSelectTag(selectTag);
                    switch (sm.getInputType()) {
                        case 13://当前选的是租住类型；
                            checkIsShowJointRentItem(selectTag);
                            break;
                        case 50://选择托管方式， 全权托管，部分托管；
                            checkSelectMode(selectTag);
                            break;
                    }

                }
                mAdapter.notifyItemChanged(selectPosition);*/
            }
        }).build();
        o.setPicker(tags);
        o.show();
    }

}
