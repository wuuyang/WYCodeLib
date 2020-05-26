package com.example.wycodelib.customview.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.wycodelib.R;
import com.example.wycodelib.customview.bean.TypeBean;

import java.util.List;

/**
 * @ClassName CustomViewAdapter
 * @Description TODO
 * @Author User
 * @Date 2020/5/26 15:36
 * @Version 1.0
 * e-mail：oom1391069@163.com
 */
public class CustomViewAdapter extends BaseQuickAdapter<TypeBean, BaseViewHolder> {
    public CustomViewAdapter(@Nullable List<TypeBean> data) {
        super(R.layout.adapter_item_main, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TypeBean item) {
        helper.setText(R.id.title_tv, item.getTitle());
    }
}
