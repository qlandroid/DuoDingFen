package org.ddf.app;

import android.support.multidex.MultiDexApplication;

import com.moxie.client.manager.MoxieSDK;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

/**
 * 描述：
 * 邮箱 email:strive_bug@yeah.net
 * 创建时间 2018/6/1
 *
 * @author ql
 */

public class MyApp extends MultiDexApplication {

    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        C.SCREEN_WIDTH = QMUIDisplayHelper.getScreenWidth(this);
        C.SCREEN_HEIGHT_3 = (int) (C.SCREEN_WIDTH * 1.0f * 9 / 16);
       MoxieSDK.init(this);


    }
}
