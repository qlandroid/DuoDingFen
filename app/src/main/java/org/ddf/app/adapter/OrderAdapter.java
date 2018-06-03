package org.ddf.app.adapter;

import android.support.annotation.LayoutRes;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import org.ddf.app.QViewHolder;
import org.ddf.app.R;
import org.ddf.app.adapter.bean.IOrder;

/**
 * 描述：
 * 邮箱 email:strive_bug@yeah.net
 * 创建时间 2018/6/1
 *
 * @author ql
 */

public class OrderAdapter extends BaseQuickAdapter<IOrder, QViewHolder> {
    public OrderAdapter() {
        super(R.layout.item_order_status);
    }

    @Override
    protected void convert(QViewHolder helper, IOrder item) {
        View ivArrow = helper.getView(R.id.item_order_status_iv_arrow);
        Object tag = ivArrow.getTag();
        if (tag != null) {
            int res = (int) tag;
            if (item.getBackgroundRes() != res) {
                ivArrow.setTag(item.getBackgroundRes());
                helper.itemView.setBackgroundResource(item.getBackgroundRes());
            }
        } else {
            ivArrow.setTag(item.getBackgroundRes());
            helper.itemView.setBackgroundResource(item.getBackgroundRes());
        }


        int i = item.isShowArrow() ? View.VISIBLE : View.GONE;
        if (ivArrow.getVisibility() != i) {
            ivArrow.setVisibility(i);
        }
        helper.setText(R.id.item_order_status_tv_shop_name, item.getShopName())
                .setText(R.id.item_order_status_tv_name, item.getName())
                .setText(R.id.item_order_status_tv_price, item.getOrderPrice())
                .setText(R.id.item_order_status_tv_status, item.getStatus())
                .setText(R.id.item_order_status_tv_order_month, item.getOrderMonth())
                .setText(R.id.item_order_status_tv_order_date, item.getOrderDate());
    }
}
