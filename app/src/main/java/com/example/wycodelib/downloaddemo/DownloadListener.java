package com.example.wycodelib.downloaddemo;

/**
 * @ClassName DownloadListener
 * @Description TODO
 * @Author User
 * @Date 2020/4/29 16:56
 * @Version 1.0
 * e-mail：oom1391069@163.com
 */
public interface DownloadListener {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}
