package com.example.wycodelib.brightenscreen;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @ClassName BrightenService
 * @Description TODO
 * @Author wuyang
 * @Date 2020/4/17 15:35
 * @Version 1.0
 * e-mail：oom1391069@163.com
 */
public class BrightenService extends Service {

    private Context mContext;
    private static final int SCREEN_TIME = 1002;

    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            return false;
        }
    });

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        return super.onStartCommand(intent, flags, startId);
    }
}
