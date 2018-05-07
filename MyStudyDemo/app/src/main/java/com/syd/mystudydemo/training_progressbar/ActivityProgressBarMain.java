package com.syd.mystudydemo.training_progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.syd.mystudydemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sydMobile on 2018/3/16.
 */

public class ActivityProgressBarMain extends Activity {
    @BindView(R.id.pb)
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar_main);
        ButterKnife.bind(this);
//        R.attr.actionBarSize
//        init();
        //TODO ProgressBar 介绍和使用
        /*
        ProgressBar
        [图片ProgressBar1]
        [图片ProgressBar2]
        [图片ProgressBar3]

        指示用户操作进度的控件，进度条支持两种模式的进度：确定的和不确定的。
        这两种模式之间的差异介绍可以参考（<a href="https://material.io/guidelines/components/
        progress-activity.html#progress-activity-types-of-indicators">）这里面介绍的，
        我查看了一下：Progress 和 activity indicators 都是程序在加载内容的时候的可视化的提示
        应该使用单个视觉指示器来表示每种类型的操作。例如，刷新操作应显示刷新栏或者活动圈两者
        中的一个，不能同时显示。
        确定进度的指示器：可以显示操作将花费的时间

        不确定进度的指示器：只显示等待的状态，没有具体时间

        指示器类型：

        当可以检测到完成部分的百分比的时候，确定进度
         */
    }

//    @Override
//    protected void initView() {
//        super.initView();
//
//    }
}
