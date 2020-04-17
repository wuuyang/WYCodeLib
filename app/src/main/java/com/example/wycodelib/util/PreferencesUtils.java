package com.example.wycodelib.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.wycodelib.AppContext;

/**
 * @ClassName PreferencesUtils
 * @Description TODO
 * @Author User
 * @Date 2020/4/17 17:14
 * @Version 1.0
 * e-mail：oom1391069@163.com
 */
public class PreferencesUtils {

    /**
     * 保存亮屏间隔时间
     *
     * @param times
     */
    public static void saveIntervalPreferences(long times) {
        SharedPreferences sharedPreferences =
                AppContext.getAppContext().getSharedPreferences("brighten", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong("brighten_time", times);
        editor.commit();
    }

    /**
     * 获取保存的亮屏间隔时间
     * @return
     */
    public static long getIntervalTime() {
        SharedPreferences sharedPreferences =
                AppContext.getAppContext().getSharedPreferences("brighten", Context.MODE_PRIVATE);
        return sharedPreferences.getLong("brighten_time", 1);
    }

    /**
     * 保存亮屏开关状态
     * @param isOpen
     */
    public static void saveBrightenSwitch(boolean isOpen){
        SharedPreferences sharedPreferences =
                AppContext.getAppContext().getSharedPreferences("brighten", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("switch_bright", isOpen);
        editor.commit();
    }

    /**
     * 获取开关状态
     * @return
     */
    public static boolean getSwitch(){
        SharedPreferences sharedPreferences =
                AppContext.getAppContext().getSharedPreferences("brighten", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("switch_bright", false);
    }
}
