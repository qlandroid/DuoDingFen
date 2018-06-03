package org.ddf.app.aty;

import android.graphics.drawable.Drawable;
import android.ql.bindview.BindView;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

import org.ddf.app.R;
import org.ddf.app.TestDataUtils;
import org.ddf.app.adapter.OrderMonthAdapter;
import org.ddf.app.base.BaseActivity;
import org.ddf.app.base.Layout;

import java.util.ArrayList;

@Layout(layoutRes = R.layout.activity_order_details, titleRes = R.string.title_order_details)
public class OrderDetailsActivity extends BaseActivity {

    @BindView(R.id.activity_apply_order_list_rv)
    RecyclerView rvMonth;

    OrderMonthAdapter orderMonthAdapter = new OrderMonthAdapter();

    @Override
    public void initWidget() {
        super.initWidget();
        rvMonth.setLayoutManager(new LinearLayoutManager(this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rvMonth.setAdapter(orderMonthAdapter);
        DividerItemDecoration decor = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.shape_div);
        decor.setDrawable(drawable);
        rvMonth.addItemDecoration(decor);

        ArrayList<MultiItemEntity> orderMonthList = TestDataUtils.getOrderMonthList();
        orderMonthAdapter.setNewData(orderMonthList);
        orderMonthAdapter.notifyDataSetChanged();
    }
}
