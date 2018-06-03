package org.ddf.app.aty;

import android.graphics.Color;
import android.ql.bindview.BindView;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import org.ddf.app.R;
import org.ddf.app.TestDataUtils;
import org.ddf.app.adapter.OrderAdapter;
import org.ddf.app.adapter.bean.IOrder;
import org.ddf.app.base.BaseActivity;
import org.ddf.app.base.Layout;
import org.ddf.app.utils.div.DividerItemDecoration;

import java.util.ArrayList;

@Layout(layoutRes = R.layout.activity_order_list, titleRes = R.string.title_order_list)
public class OrderListActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {


    @BindView(R.id.activity_order_list)
    RecyclerView rv;

    OrderAdapter orderAdapter = new OrderAdapter();


    @Override
    public void initWidget() {
        super.initWidget();

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(orderAdapter);
        //rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL, 10, ContextCompat.getColor(this, R.color.hideColor)));

        orderAdapter.setOnItemClickListener(this);

        ArrayList<IOrder> orderList = TestDataUtils.getOrderList();
        orderAdapter.setNewData(orderList);
        orderAdapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        startActivity(OrderDetailsActivity.class);
    }


}
