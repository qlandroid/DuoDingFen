package org.ddf.app.aty.loan;

import android.ql.bindview.BindView;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import org.ddf.app.R;
import org.ddf.app.aty.ApplyOrderListActivity;
import org.ddf.app.base.BaseActivity;
import org.ddf.app.base.Layout;
import org.ddf.app.widget.ScrollWebView;

@Layout(layoutRes = R.layout.activity_agreement, titleRes = R.string.title_agreement)
public class AgreementActivity extends BaseActivity {
    @BindView(R.id.activity_agreement_wv)
    ScrollWebView webView;
    @BindView(R.id.activity_agreement_tv_ok)
    TextView tvOK;


    @Override
    public void initWidget() {
        super.initWidget();
        tvOK.setOnClickListener(this);
        tvOK.setClickable(false);
        tvOK.setSelected(true);
        webView.setWebViewClient(new WebViewClient() {
            //覆盖shouldOverrideUrlLoading 方法
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                //WebView的总高度
                float webViewContentHeight = webView.getContentHeight() * webView.getScale();
                //WebView的现高度
                float webViewCurrentHeight = (webView.getHeight() + webView.getScrollY());
                if ((webViewContentHeight - webViewCurrentHeight) == 0) {
                    tvOK.setClickable(true);
                    tvOK.setSelected(false);
                }
            }
        });
        webView.loadUrl("https://www.2cto.com/kf/201605/513291.html");
        webView.setOnScrollWebViewListener(new ScrollWebView.OnScrollWebViewListener() {
            @Override
            public void onScrollChanged(int l, int t, int oldl, int oldt) {
                //WebView的总高度
                float webViewContentHeight = webView.getContentHeight() * webView.getScale();
                //WebView的现高度
                float webViewCurrentHeight = (webView.getHeight() + webView.getScrollY());
                float v = webViewContentHeight - webViewCurrentHeight;
                if (v == 0) {
                    tvOK.setClickable(true);
                    tvOK.setSelected(false);
                }
            }
        });
    }


    @Override
    public void forbidClick(View v) {
        super.forbidClick(v);
        switch (v.getId()) {
            case R.id.activity_agreement_tv_ok:
                startActivity(ApplyOrderListActivity.class);
                break;
        }
    }
}
