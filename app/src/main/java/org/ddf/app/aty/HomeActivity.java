package org.ddf.app.aty;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.ql.bindview.BindView;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qmuiteam.qmui.alpha.QMUIAlphaImageButton;

import org.ddf.app.C;
import org.ddf.app.R;
import org.ddf.app.adapter.GridAdapter;
import org.ddf.app.adapter.OrderAdapter;
import org.ddf.app.adapter.bean.IOrder;
import org.ddf.app.adapter.bean.TextImgBean;
import org.ddf.app.aty.loan.InputProjectDetailsActivity;
import org.ddf.app.base.BaseActivity;
import org.ddf.app.base.Layout;
import org.ddf.app.utils.ActivityUtils;
import org.ddf.app.utils.FormatUtils;
import org.ddf.app.zxing.activity.CaptureActivity;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

@Layout(layoutRes = R.layout.activity_home, titleRes = R.string.app_name, backRes = R.drawable.home_nav)
public class HomeActivity extends BaseActivity {

    private static final int REQUEST_DECODE = 1121;
    @BindView(R.id.activity_home_rv_girl_btn)
    RecyclerView rvGirlBtn;
    @BindView(R.id.activity_home_rv_order)
    RecyclerView rvOrder;
    @BindView(R.id.activity_home_tv_logout)
    View tvLogout;
    @BindView(R.id.activity_home_tv_phone)
    TextView tvPhone;
    @BindView(R.id.activity_home_tv_prices)
    TextView tvPrices;//申请总金额
    @BindView(R.id.activity_home_iv)
    ImageView iv;

    private GridAdapter gridAdapter;
    private OrderAdapter orderAdapter;

    @Override
    public void initData() {
        super.initData();
        EventBus.getDefault().register(this);
    }

    @Override
    public void initWidget() {
        super.initWidget();
        initGridButton();
        initApplyOrder();

        setBannerHeight();

        tvLogout.setOnClickListener(this);

        setPrices(100000.00d);
        ArrayList<IOrder> l = new ArrayList<>();
        l.add(new IOrder() {
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
                return R.drawable.shape_radius_yellow_div_black;
            }

            @Override
            public boolean isShowArrow() {
                return false;
            }
        });
        orderAdapter.setNewData(l);
        orderAdapter.notifyDataSetChanged();

    }

    @Override
    public void forbidClick(View v) {
        super.forbidClick(v);
        int id = v.getId();
        switch (id) {
            case R.id.activity_home_tv_logout:
                startActivity(LoginActivity.class);
                break;
        }
    }

    private void setBannerHeight() {
        ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
        layoutParams.height = C.SCREEN_HEIGHT_3;
        iv.setLayoutParams(layoutParams);
    }


    private void setPrices(double prices) {
        String s = FormatUtils.NumberFormat1(prices);
        tvPrices.setText(String.format("%s 元", s));
    }

    private void initApplyOrder() {
        orderAdapter = new OrderAdapter();
        rvOrder.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        DividerItemDecoration decor = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.shape_div);
        decor.setDrawable(drawable);
        rvOrder.addItemDecoration(decor);
        rvOrder.setAdapter(orderAdapter);
    }

    @Override
    public void initBar() {
        QMUIAlphaImageButton qmuiAlphaImageButton = mTopBar.addRightImageButton(R.drawable.home_menu_scanning, R.id.top_bar_right_scanning);
        qmuiAlphaImageButton.setChangeAlphaWhenPress(true);
        qmuiAlphaImageButton.setScaleType(ImageView.ScaleType.CENTER);
        qmuiAlphaImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CaptureActivity.class, REQUEST_DECODE);
            }
        });
    }

    @Override
    public void clickTopbarLeftImgs() {
        startActivity(UserDetailsActivity.class);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void agreementOk(String isOk) {
        ActivityUtils.singleAty(this);
        startActivity(ApplyOrderListActivity.class);
    }

    /**
     * 初始化button
     */
    private void initGridButton() {
        rvGirlBtn.setLayoutManager(new GridLayoutManager(this, 3));
        gridAdapter = new GridAdapter();
        rvGirlBtn.setAdapter(gridAdapter);

        gridAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                List data = adapter.getData();

                TextImgBean o = (TextImgBean) data.get(position);
                switch (o.tag) {
                    case 0://扫一扫
                        startActivity(CaptureActivity.class, REQUEST_DECODE);
                        break;
                    case 1://订单
                        startActivity(OrderListActivity.class);
                        break;
                    case 2://还款
                        startActivity(ApplyOrderListActivity.class);
                        break;
                }
            }
        });
        ArrayList<TextImgBean> l = new ArrayList<>();
        l.add(new TextImgBean("扫一扫", R.drawable.icon_home_scanning_48, 0));
        l.add(new TextImgBean("订单", R.drawable.icon_home_order_48, 1));
        l.add(new TextImgBean("还款", R.drawable.icon_home_clock_48, 2));
        gridAdapter.setNewData(l);
        gridAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_DECODE:
                startActivity(InputProjectDetailsActivity.class);
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
