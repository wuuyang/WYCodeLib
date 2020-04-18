package com.example.wycodelib.brightenscreen;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.wycodelib.AppContext;
import com.example.wycodelib.util.Contants;

import java.util.List;

import static com.example.wycodelib.brightenscreen.BrightenService.TAG_SWITCH;
import static com.example.wycodelib.brightenscreen.BrightenService.TAG_TIME;

/**
 * @ClassName BrightenUtils
 * @Description TODO
 * @Author User
 * @Date 2020/4/17 17:34
 * @Version 1.0
 * e-mail：oom1391069@163.com
 */
public class BrightenUtils {

    /**
     * 判断服务是否存在
     *
     * @param mContext
     * @param className
     * @return
     */
    public static boolean isServiceExisted(Context mContext, String className) {
        ActivityManager activityManager = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceInfoList =
                activityManager.getRunningServices(Integer.MAX_VALUE);
        if (!(serviceInfoList.size() > 0)) {
            return false;
        } else {
            for (int i = 0; i < serviceInfoList.size(); i++) {
                ActivityManager.RunningServiceInfo serviceInfo = serviceInfoList.get(i);
                ComponentName serviceName = serviceInfo.service;
                Log.e("BGA", serviceName.getClassName());
                if (serviceName.getClassName().equals(className)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 打开唤醒服务
     * @param mContext
     * @param time
     * @param isOpen
     */
    public static void openBrightenService(Context mContext, long time, boolean isOpen) {
        if (!isServiceExisted(AppContext.getAppContext(), Contants.SERVICE_BRIGHTEN)) {
            Intent intent = new Intent(mContext, BrightenService.class);
            intent.putExtra(TAG_TIME, time);
            intent.putExtra(TAG_SWITCH, isOpen);
            mContext.startService(intent);
        }
    }
}
