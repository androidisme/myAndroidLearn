package com.syd.mystudydemo.training_photo;

import android.os.Bundle;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

/**
 * Created by sydMobile on 2018/4/10.
 */

public class ActivitySelectPhoto extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectphoto_main);
        getResources().getDrawable(R.mipmap.ic_launcher);

    }
}
