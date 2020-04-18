package com.example.wycodelib.util;

/**
 * @ClassName StringUtils
 * @Description TODO
 * @Author User
 * @Date 2020/4/18 9:07
 * @Version 1.0
 * e-mail：oom1391069@163.com
 */
public class StringUtils {


    /**
     * 字符串非空判断
     * @param str
     * @return
     */
    public static boolean strNotEmpty(String str){
        if (null != str && !"null".equals(str) && !"".equals(str)){
            return true;
        }
        return false;
    }
}
