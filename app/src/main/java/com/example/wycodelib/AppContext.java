package com.example.wycodelib;

import android.app.Application;
import android.content.Context;

/**
 * @ClassName AppContext
 * @Description TODO
 * @Author User
 * @Date 2020/4/17 17:17
 * @Version 1.0
 * e-mail：oom1391069@163.com
 */
public class AppContext extends Application {
    private static AppContext mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    /**
     *
     * @return the Context of this application
     */
    public static Context getAppContext(){
        return mInstance.getApplicationContext();
    }

    public static AppContext getInstance(){
        return  mInstance;
    }
}
