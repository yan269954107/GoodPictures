package com.yanxw.goodpictures;

import android.app.Application;

/**
 * Created by yanxinwei on 16/8/3.
 */

public class GPApplication extends Application {

    private static GPApplication sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

    public static GPApplication getInstance() {
        return sApplication;
    }
}
