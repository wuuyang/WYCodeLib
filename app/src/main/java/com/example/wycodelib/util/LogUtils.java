package com.example.wycodelib.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName LogUtils
 * @Description TODO
 * @Author User
 * @Date 2020/4/17 17:04
 * @Version 1.0
 * e-mail：oom1391069@163.com
 */
public class LogUtils {

    // 用于格式化日期，作为日志文件名的一部分
    public static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public static String log_path =
            android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "Code_LOG";

    public static String writeFile(String title){
        String time = format.format(new Date());
        String fileName = "brighten" + time + ".txt";
        String path = log_path;
        File dir = new File(path);
        if (!dir.exists())
            dir.mkdirs();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path + "/" + fileName, true);
            fos.write((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
                    format(new Date()) + "     " + title + "\n").getBytes());
            fos.flush();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return fileName;
    }
}
