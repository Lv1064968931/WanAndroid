package com.lvlin.wanandroid;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class WanAndroidApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(WanAndroidApplication.this);
    }
}
