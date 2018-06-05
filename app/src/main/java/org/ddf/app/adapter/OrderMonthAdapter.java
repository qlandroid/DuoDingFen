package org.ddf.app.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import org.ddf.app.R;
import org.ddf.app.adapter.bean.IOrderApply;
import org.ddf.app.adapter.bean.IOrderEnd;
import org.ddf.app.adapter.base.QViewHolder;

/**
 * 描述：
 * 邮箱 email:strive_bug@yeah.net
 * 创建时间 2018/6/3
 *
 * @author ql
 */

public class OrderMonthAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, QViewHolder> {
    public static final int ITEM_APPLY = 0;
    public static final int ITEM_WARNING = 1;
    public static final int ITEM_END = 2;
    public static final int ITEM_NULL = 3;

    public OrderMonthAdapter() {
        super(null);
        addItemType(ITEM_NULL, R.layout.item_null);
        addItemType(ITEM_END, R.layout.item_order_month_end);
        addItemType(ITEM_APPLY, R.layout.item_order_month_apply);
        addItemType(ITEM_WARNING, R.layout.item_order_month_apply);
    }

    @Override
    protected void convert(QViewHolder helper, MultiItemEntity item) {
        int itemType = item.getItemType();
        switch (itemType) {
            case ITEM_APPLY:
                convertApply(helper, item);
                break;
            case ITEM_WARNING:
                convertWarning(helper, item);
                break;
            case ITEM_END:
                convertEnd(helper, item);
                break;
            default:
        }
    }

    /**
     * 结束
     *
     * @param helper
     */
    private void convertEnd(QViewHolder helper, MultiItemEntity i) {
        IOrderEnd item
                = (IOrderEnd) i;
        helper.setText(R.id.item_order_month_end_tv_count, item.getMonthCount())//期数
                .setText(R.id.item_order_month_end_tv_apply_date, item.getApplyDate())//计划还款时间
                .setText(R.id.item_order_month_end_tv_date, item.getDate())//实际还款时间
                .setText(R.id.item_order_month_end_tv_price, item.getPrice());//还款金额
    }

    /**
     * 警告
     *
     * @param helper
     */
    private void convertWarning(QViewHolder helper, MultiItemEntity i) {
        helper.setImageResource(R.id.item_order_month_apply_iv, R.drawable.warning);
        setApplyView(helper, i);
    }

    private void setApplyView(QViewHolder helper, MultiItemEntity i) {
        IOrderApply item
                = (IOrderApply) i;
        helper.setText(R.id.item_order_month_apply_tv_count, item.getMonthCount())//期数
                .setText(R.id.item_order_month_apply_tv_apply_date, item.getApplyDate())//计划还款时间
                .setText(R.id.item_order_month_apply_tv_price, item.getPrice());//还款金额
    }

    /**
     * 等待
     *
     * @param helper
     * @param item
     */
    private void convertApply(QViewHolder helper, MultiItemEntity item) {
        helper.setImageResource(R.id.item_order_month_apply_iv, R.drawable.clock);
        setApplyView(helper, item);
    }
}
