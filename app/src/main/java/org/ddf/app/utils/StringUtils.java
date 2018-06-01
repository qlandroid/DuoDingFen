package org.ddf.app.utils;

/**
 * Created by mrqiu on 2017/10/4.
 */

public class StringUtils {

    public static<T extends CharSequence> boolean isEmpty(T str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }
}
