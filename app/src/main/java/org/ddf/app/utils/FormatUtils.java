package org.ddf.app.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * 描述：
 * 邮箱 email:strive_bug@yeah.net
 * 创建时间 2018/6/2
 *
 * @author ql
 */

public class FormatUtils {
    public static String NumberFormat1(double num) {
        NumberFormat number_format = NumberFormat.getInstance(Locale.CHINA);
        number_format.setMaximumFractionDigits(2);
        return number_format.format(num);
    }
}
