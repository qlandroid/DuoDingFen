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
import org.ddf.app.base.BaseActivity;
import org.ddf.app.base.Layout;

import java.util.List;

@Layout(layoutRes = R.layout.activity_input_project_details, titleRes = R.string.title_input_project_details)
public class InputProjectDetailsActivity extends BaseActivity {

    @BindView(R.id.activity_input_project_details_tv_next)
    TextView tvNext;
    @BindView(R.id.activity_input_project_details_et_input_name)
    EditText etInputName;
    @BindView(R.id.activity_input_project_details_et_price)
    EditText etPrice;
    @BindView(R.id.activity_input_project_details_select_user_group)
    ViewGroup selectUserGroup;//选择咨询师
    @BindView(R.id.activity_input_project_details_tv_select_user)
    TextView tvSelectUser;
    @BindView(R.id.activity_input_project_details_month_group)
    ViewGroup monthGroup;//期数选择
    @BindView(R.id.activity_input_project_details_tv_month)
    TextView tvMonth;
    @BindView(R.id.activity_input_project_details_project_group)
    ViewGroup projectGroup;//项目选择
    @BindView(R.id.activity_input_project_details_tv_project)
    TextView tvProject;

    @Override
    public void initWidget() {
        super.initWidget();
        tvNext.setOnClickListener(this);
        monthGroup.setOnClickListener(this);
        selectUserGroup.setOnClickListener(this);
        projectGroup.setOnClickListener(this);
    }

    @Override
    public void forbidClick(View v) {
        super.forbidClick(v);
        switch (v.getId()) {
            case R.id.activity_input_project_details_tv_next://下一步
                startActivity(MoxieSdkStartActivity.class);
                break;
            case R.id.activity_input_project_details_select_user_group://选择咨询师
                break;
            case R.id.activity_input_project_details_month_group://期数选择
                break;
            case R.id.activity_input_project_details_project_group://项目选择
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
