package com.example.wycodelib.customview.bean;

/**
 * @ClassName TypeBean
 * @Description TODO
 * @Author User
 * @Date 2020/5/25 11:19
 * @Version 1.0
 * e-mail：oom1391069@163.com
 */
public class TypeBean {

    private String title;
    private int type;

    public TypeBean(String title, int type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
