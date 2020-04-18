package com.example.wycodelib.brightenscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;

import com.example.wycodelib.R;
import com.example.wycodelib.databinding.ActivityBrightenScreenBinding;
import com.example.wycodelib.util.LogUtils;
import com.example.wycodelib.util.PreferencesUtils;
import com.example.wycodelib.util.StringUtils;
import com.example.wycodelib.util.ToastUtils;

public class BrightenScreenActivity extends AppCompatActivity {

    private Context mContext;
    private ActivityBrightenScreenBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mBinding = DataBindingUtil
                .inflate(LayoutInflater.from(this),
                        R.layout.activity_brighten_screen,
                        null,
                        false);
        setContentView(mBinding.getRoot());

        initView();
    }

    @SuppressLint("SetTextI18n")
    private void initView(){
        mBinding.swBrighten.setChecked(PreferencesUtils.getSwitch());
        mBinding.swBrighten.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                BrightenUtils.openBrightenService(mContext, PreferencesUtils.getIntervalTime(), isChecked);
                PreferencesUtils.saveBrightenSwitch(isChecked);
                LogUtils.writeFile("是否开启亮屏服务 = " + isChecked);
            }
        });

        mBinding.etBrightenTime.setText(PreferencesUtils.getIntervalTime() + "");
        mBinding.btnSaveTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tmp = mBinding.etBrightenTime.getText().toString();
                long time = 0;
                if (StringUtils.strNotEmpty(tmp)){
                    time = Long.valueOf(tmp);
                }
                PreferencesUtils.saveIntervalPreferences(time);
                LogUtils.writeFile("保存间隔时间 = " + tmp);
                ToastUtils.show(mContext, "时间保存成功");
            }
        });
    }
}
