package org.ddf.app;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;


/**
 * Created by mrqiu on 2017/10/15.
 */

public class C {
    public static final Handler sHandler = new Handler(Looper.getMainLooper());

    public static final Gson sGson = new Gson();
    public static final int NORMAL_PAGE_NUM = 1;
    public static int SCREEN_WIDTH;
    /**
     * 宽高比例为  4:3
     */
    public static int SCREEN_HEIGHT_3;


}
