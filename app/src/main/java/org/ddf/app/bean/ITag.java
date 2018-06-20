package org.ddf.app.bean;

import com.contrarywind.interfaces.IPickerViewData;

/**
 * 描述：
 * 邮箱 email:strive_bug@yeah.net
 * 创建时间 2018/6/8
 *
 * @author ql
 */

public interface ITag extends IPickerViewData {
    boolean isSelect();

    String getTagName();

    Object getTag();

    void setSelect(boolean select);
}
