package com.example.wycodelib.brightenscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.CompoundButton;

import com.example.wycodelib.R;
import com.example.wycodelib.databinding.ActivityBrightenScreenBinding;
import com.example.wycodelib.util.PreferencesUtils;

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


    }

    private void initView(){
        mBinding.swBrighten.setChecked(PreferencesUtils.getSwitch());
        mBinding.swBrighten.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
    }
}
