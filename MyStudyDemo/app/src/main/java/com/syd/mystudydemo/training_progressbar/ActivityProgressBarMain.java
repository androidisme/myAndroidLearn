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

        Android  4.0

        targetSdkVersion： 14
        minSdkVersion  14

        android:theme="@style/Theme.AppCompat.Light"

        手机 6.0

        样式 Metrail

        手机 4.4
        样式 Holo

        支持库

        彻底搞清楚 Attr 、 Style 、Theme
        相信这三个词对于Android开发者来说是十分熟悉了，那么你对他们到底了解吗？
        回忆起我刚开始接触Android的时候对这三个词有一些迷惑，经常就是死记硬背。
        今天就来仔细说说这三个词

        Attr :属性的意思（这里的属性和xml控件中的属性不是一个意思），是通过

               Attr来定义我们控件中所使用的属性的，这样说可能大家会有一迷惑，
               那么来举个栗子：
               比如我们在控件中最多使用的 layout_width 属性，
               [图片layout_width]
               这个属性就是在Attr里面定义的,那么如何来查找这个属性呢？到SDK











         */
    }

//    @Override
//    protected void initView() {
//        super.initView();
//
//    }
}
