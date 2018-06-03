package org.ddf.app.adapter.bean;

/**
 * 描述：
 * 邮箱 email:strive_bug@yeah.net
 * 创建时间 2018/6/1
 *
 * @author ql
 */
public interface IOrder {

    /**
     * 商店名称
     * @return
     */
    CharSequence getShopName();

    /**
     * 功能名称
     * @return
     */
    CharSequence getName();

    /**
     * 金额
     */
    CharSequence getOrderPrice();

    /**
     * 订单状态
     * @return
     */
    CharSequence getStatus();

    /**
     * 订单期限
     * @return
     */
    CharSequence getOrderMonth();

    /**
     * 订单时间
     * @return
     */
    CharSequence getOrderDate();

    int getBackgroundRes();

    boolean isShowArrow();
}
