package org.ddf.app.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;

import org.ddf.app.R;
import org.ddf.app.adapter.base.QViewHolder;
import org.ddf.app.adapter.bean.TextImgBean;

/**
 * 描述：
 * 邮箱 email:strive_bug@yeah.net
 * 创建时间 2018/6/1
 *
 * @author ql
 */

public class GridAdapter extends BaseQuickAdapter<TextImgBean,QViewHolder>{
    public GridAdapter() {
        super(R.layout.item_img_text);
    }

    @Override
    protected void convert(QViewHolder helper, TextImgBean item) {
        helper.setText(R.id.item_img_text_tv,item.name)
                .setImageResource(R.id.item_img_text_iv,item.image);
    }
}
