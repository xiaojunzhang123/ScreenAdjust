package com.zxj.screenadjust;

import android.app.Application;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ScreenAdjust.getInstance().init(this);
    }
}
