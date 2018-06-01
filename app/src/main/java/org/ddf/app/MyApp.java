package org.ddf.app;

import android.support.multidex.MultiDexApplication;

/**
 * 描述：
 * 邮箱 email:strive_bug@yeah.net
 * 创建时间 2018/6/1
 *
 * @author ql
 */

public class MyApp  extends MultiDexApplication {

    private static MyApp instance;
    public static MyApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
