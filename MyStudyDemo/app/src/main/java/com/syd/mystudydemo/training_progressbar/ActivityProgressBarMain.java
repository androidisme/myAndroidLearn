package com.syd.mystudydemo.training_progressbar;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sydMobile on 2018/3/16.
 */

public class ActivityProgressBarMain extends BaseActivity {
    @BindView(R.id.pb)
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar_main);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void initView() {
        super.initView();
        
    }
}
