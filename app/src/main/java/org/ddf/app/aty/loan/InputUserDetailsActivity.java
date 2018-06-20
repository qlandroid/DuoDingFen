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
import org.ddf.app.TestDataUtils;
import org.ddf.app.aty.loan.HospitalActivity;
import org.ddf.app.base.BaseActivity;
import org.ddf.app.base.Layout;
import org.ddf.app.bean.ITag;

import java.util.ArrayList;
import java.util.List;

@Layout(layoutRes = R.layout.activity_input_user_details, titleRes = R.string.title_input_user_details)
public class InputUserDetailsActivity extends BaseActivity {
    public static final int CLICK_TAG_MARRIAGE = 1;//点击了婚姻状况
    public static final int CLICK_TAG_JOB = 2;//点击了工作；
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

    private ArrayList<ITag> mMarriageTags;
    private ArrayList<ITag> mJobTags;

    int clickTag;

    @Override
    public void initData() {
        super.initData();
        mJobTags = TestDataUtils.getTags();
        mMarriageTags = TestDataUtils.getTags();
    }

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
                clickTag = CLICK_TAG_MARRIAGE;
                displayBottom(mMarriageTags);
                break;
            case R.id.activity_input_user_details_job_group://工作状况
                clickTag = CLICK_TAG_JOB;
                displayBottom(mJobTags);
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
                switch (clickTag) {
                    case CLICK_TAG_JOB:
                        ITag iTag = mJobTags.get(options1);
                        tvJob.setText(iTag.getTagName());
                        break;
                    case CLICK_TAG_MARRIAGE:
                        ITag iTag1 = mMarriageTags.get(options1);
                        tvMarriage.setText(iTag1.getTagName());
                        break;
                    default:
                }
            }
        }).build();
        o.setPicker(tags);
        o.show();
    }


}
