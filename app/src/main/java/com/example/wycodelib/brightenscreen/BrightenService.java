package com.example.wycodelib.brightenscreen;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wycodelib.AppContext;
import com.example.wycodelib.util.LogUtils;
import com.example.wycodelib.util.ToastUtils;

import java.util.Timer;
import java.util.TimerTask;

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

    public static final String TAG_TIME = "time";
    public static final String TAG_SWITCH = "isOpen";

    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case SCREEN_TIME:
                    wakeUpAndUnlock(mContext);
                    break;
            }
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
        long time = intent.getLongExtra(TAG_TIME, 1);
        boolean isOpen = intent.getBooleanExtra(TAG_SWITCH, false);

        if (isOpen) {
            startBrighten(time);
            ToastUtils.show(AppContext.getAppContext(), "唤醒服务开启成功");
        } else {
            stopBrighten();
            ToastUtils.show(AppContext.getAppContext(), "唤醒服务已关闭");
        }

        return super.onStartCommand(intent, flags, startId);
    }

    Timer mTimer;
    TimerTask mTimerTask;

    /**
     * 开启计时器
     * @param time
     */
    private void startBrighten(long time) {
        if (mTimer == null) {
            mTimer = new Timer();
        }
        if (mTimerTask == null) {
            mTimerTask = new TimerTask() {
                @Override
                public void run() {
                    mHandler.sendEmptyMessage(SCREEN_TIME);
                }
            };
        }
        if (mTimer != null && mTimerTask != null) {
            mTimer.schedule(mTimerTask, 1 , time * 60 * 1000);
        }
    }

    /**
     * 关闭计时器
     */
    private void stopBrighten(){
        if (mTimer != null){
            mTimer.cancel();
            mTimer = null;
        }

        if (mTimerTask != null){
            mTimerTask.cancel();
            mTimerTask = null;
        }
    }

    /**
     * 屏幕唤醒
     */
    public static void wakeUpAndUnlock(Context context){
        //锁屏管理器
        KeyguardManager km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock kl = km.newKeyguardLock("unLock");
        //解锁
        kl.disableKeyguard();
        //获取电源管理器
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        @SuppressLint("InvalidWakeLockTag") PowerManager.WakeLock wl =
                pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK, "bright");
        //点亮屏幕
        wl.acquire();
        LogUtils.writeFile("唤醒屏幕");
        //释放
        wl.release();
    }

}
