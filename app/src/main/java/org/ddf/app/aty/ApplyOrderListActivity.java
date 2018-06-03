package org.ddf.app.aty;

import android.graphics.drawable.Drawable;
import android.ql.bindview.BindView;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import org.ddf.app.R;
import org.ddf.app.TestDataUtils;
import org.ddf.app.adapter.OrderMonthAdapter;
import org.ddf.app.base.BaseActivity;
import org.ddf.app.base.Layout;

import java.util.ArrayList;


@Layout(layoutRes = R.layout.activity_apply_order_list,titleRes = R.string.title_apply_order_list)
public class ApplyOrderListActivity extends BaseActivity {

    @BindView(R.id.activity_apply_order_list_rv)
    RecyclerView rv;

    OrderMonthAdapter orderMonthAdapter = new OrderMonthAdapter();

    @Override
    public void initWidget() {
        super.initWidget();
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(orderMonthAdapter);
        DividerItemDecoration decor = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.shape_div);
        decor.setDrawable(drawable);
        rv.addItemDecoration(decor);

        ArrayList<MultiItemEntity> orderMonthList = TestDataUtils.getOrderMonthList();
        orderMonthList.add(0, new MultiItemEntity() {
            @Override
            public int getItemType() {
                return OrderMonthAdapter.ITEM_NULL;
            }
        });
        orderMonthAdapter.setNewData(orderMonthList);
        orderMonthAdapter.notifyDataSetChanged();
    }
}
