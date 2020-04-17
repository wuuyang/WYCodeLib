package com.example.wycodelib.util;

import android.util.Log;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName FileUtil 文件处理集合类
 *  文件上传，拷贝，删除，显示文件夹下所有文件等方法
 * @Description TODO
 * @Author User
 * @Date 2020/4/17 16:37
 * @Version 1.0
 * e-mail：oom1391069@163.com
 */
public class FileUtil {

    private FileUtil(){}

    /**
     *  删除文件
     * @param file
     */
    public static void deleteFile(File file){
        if (file.exists()){
            if (file.isFile()){
                delOnlyFile(file);
            }else {
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    deleteFile(files[i]);
                }
            }
        }
    }

    /**
     * 仅删除文件夹下面的文件
     * @param file 文件夹名称
     */
    private static void delOnlyFile(File file){
        if (file.exists()){
            file.delete();
        }
    }

    /**
     * 删除文件
     * @param filePath 文件目录
     */
    public static void deleteFile(String filePath){
        Log.e("BGA", "filePath = " + filePath);
        File file = new File(filePath);
        deleteFile(file);
        System.gc();
    }

    /**
     * 创建文件目录
     * @param path 路径
     * @return
     */
    public static File createPath(String path){
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        return file;
    }

    public static boolean deleteDir(File dir){
        if (dir.isDirectory()){
            String[] children = dir.list();
            for (String fileName : children){
                boolean result = deleteDir(new File(dir, fileName));
                System.out.println("删除目录" + dir + "/" + fileName + "=====" + result);
                if (!result){
                    return false;
                }
            }
        }
        System.out.println(dir.getAbsolutePath());
        if (dir.getAbsolutePath().endsWith("WY")){
            return true;
        }
        return dir.delete();
    }


}
