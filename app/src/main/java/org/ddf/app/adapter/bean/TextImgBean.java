package org.ddf.app.adapter.bean;

import android.support.annotation.DrawableRes;

/**
 * 描述：
 * 邮箱 email:strive_bug@yeah.net
 * 创建时间 2018/6/1
 *
 * @author ql
 */

public class TextImgBean {
    public TextImgBean(String name, int image, int tag) {
        this.name = name;
        this.image = image;
        this.tag = tag;
    }

    public String name;
    public
    @DrawableRes
    int image;
    public int tag;
}
