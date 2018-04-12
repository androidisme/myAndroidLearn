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
        //TODO  findViewById   setContentView()


        /*
        Window 类
        [Window]
        首先简单介绍一下什么是Window，单独从这个单词来看，意思就是 窗口
        那么这个类在Android中到底代表了什么意思呢？

        文档说明：

        顶级窗口外观和行为策略的抽象基类。这个类的实例应该被用作顶层视图添加
        到窗口管理器（window manager）中。它提供了标准的UI策略，比如：背景、
        标题区、默认的关键处理等等。

        Window的唯一一个实现类是 android.view.PhoneWindow。如果你需要一个
        Window对象的话，你应该实例一个PhoneWindow。

        说白一点就是Window就是一个窗口，凡是我们需要页面（在手机上面的体现形式就是
        ：看的到的画面，比如Activity，Dialog等等）这些页面都是建立在Window上的，也
        就是比如我们在xml中写布局的时候，这些布局其实都在在window上面的（可以理解为
        Window就是它们的父布局）。Window决定了一些外观的默认属性和一些关键操作。其实
        这些方法的实现大部分都是在PhoneWindow里面。每一个Activity里面都有一个Window，
        其真实对象是 PhoneWindow对象

        [window_activity]
        window在Activity中的存在

        [window_dialog]
        window在dialog中的存在



        [Window=]

        window在Activity中就这样被实例化的（可以看到其实就是new了一个 PhoneWindow对象，关于PhoneWindow对象
        下面会详细说到）

        []


        setContenView() 就是在PhoneWindow这个类里面实现的

        [setContentView]

        具体来看看这个方法：

        其中 MContentParent 就是一个ViewGroup
        [mContentParent]

        这是放置窗口内容的视图。 它可以是mDecor本身，也可以是mDecor的内容所在的孩子。











         */


    }
}
