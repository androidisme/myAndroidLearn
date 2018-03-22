package com.syd.mystudydemo.training_shadow;

import android.os.Bundle;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

/**
 * Created by sydMobile on 2018/3/21.
 */

public class ActivityShadow extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow_main);
//        InputMethodManager
        init();
    }
}
