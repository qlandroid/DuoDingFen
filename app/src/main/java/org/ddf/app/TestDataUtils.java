package org.ddf.app;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import org.ddf.app.adapter.OrderMonthAdapter;
import org.ddf.app.adapter.bean.IOrder;
import org.ddf.app.adapter.bean.IOrderApply;
import org.ddf.app.adapter.bean.IOrderEnd;
import org.ddf.app.bean.ITag;
import org.ddf.app.utils.FormatUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 邮箱 email:strive_bug@yeah.net
 * 创建时间 2018/6/3
 *
 * @author ql
 */

public class TestDataUtils {

    public static ArrayList<IOrder> getOrderList() {
        ArrayList<IOrder> list = new ArrayList<>();

        list.add(new Order(R.drawable.shape_radius_yellow_div_black, false));
        list.add(new Order(R.drawable.shape_radius_gray_div_black, true));
        list.add(new Order(R.drawable.shape_radius_green_div_black, true));


        return list;
    }


    public static ArrayList<MultiItemEntity> getOrderMonthList() {
        ArrayList<MultiItemEntity> list = new ArrayList<>();

        list.add(new OrderMonth(OrderMonthAdapter.ITEM_APPLY));
        list.add(new OrderMonth(OrderMonthAdapter.ITEM_END));
        list.add(new OrderMonth(OrderMonthAdapter.ITEM_WARNING));
        list.add(new OrderMonth(OrderMonthAdapter.ITEM_APPLY));
        list.add(new OrderMonth(OrderMonthAdapter.ITEM_END));
        list.add(new OrderMonth(OrderMonthAdapter.ITEM_WARNING));
        list.add(new OrderMonth(OrderMonthAdapter.ITEM_APPLY));
        list.add(new OrderMonth(OrderMonthAdapter.ITEM_END));
        list.add(new OrderMonth(OrderMonthAdapter.ITEM_WARNING));

        return list;
    }

    public static ArrayList<ITag> getTags() {
        ArrayList<ITag> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new TagTest("item-->" + i, i));
        }
        return list;
    }

    public static class Order implements IOrder {
        public Order(int backgroundRes, boolean isShowArrow) {
            this.backgroundRes = backgroundRes;
            this.isShowArrow = isShowArrow;
        }

        int backgroundRes;
        boolean isShowArrow;

        @Override
        public CharSequence getShopName() {
            return "测试未知";
        }

        @Override
        public CharSequence getName() {
            return "测试部位";
        }

        @Override
        public CharSequence getOrderPrice() {
            return "20,000.00";
        }

        @Override
        public CharSequence getStatus() {
            return "申请中";
        }

        @Override
        public CharSequence getOrderMonth() {
            return "12";
        }

        @Override
        public CharSequence getOrderDate() {
            return "2018年5月18日 12:12:12";
        }

        @Override
        public int getBackgroundRes() {
            return backgroundRes;
        }

        @Override
        public boolean isShowArrow() {
            return isShowArrow;
        }
    }

    public static class OrderMonth implements IOrderEnd, IOrderApply, MultiItemEntity {
        int itemType;

        public OrderMonth(int itemType) {
            this.itemType = itemType;
        }

        @Override
        public CharSequence getDate() {
            return "2018年6月10";
        }

        @Override
        public CharSequence getMonthCount() {
            return "第12期";
        }

        @Override
        public CharSequence getApplyDate() {
            return "2018年6月10";
        }

        @Override
        public CharSequence getPrice() {
            return FormatUtils.NumberFormat1(200000.00D);
        }

        @Override
        public int getItemType() {
            return itemType;
        }
    }

    public static class TagTest implements ITag {
        String tagName;
        Object tag;

        public TagTest(String tagName, Object tag) {
            this.tagName = tagName;
            this.tag = tag;
        }

        @Override
        public boolean isSelect() {
            return false;
        }

        @Override
        public String getTagName() {
            return tagName;
        }

        @Override
        public Object getTag() {
            return tag;
        }

        @Override
        public void setSelect(boolean select) {

        }

        @Override
        public String getPickerViewText() {
            return tagName;
        }
    }
}
