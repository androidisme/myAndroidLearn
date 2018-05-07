package com.syd.mystudydemo.training_listView;

import android.os.Bundle;

import com.syd.mystudydemo.activity.base.BaseActivity;

/**
 * Created by sydMobile on 2018/4/26.
 */

public class ActivityListView extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        //TODO EventBus
        EventBus

        EventBus是一个Android事件发布/订阅框架，通过解耦发布者和订阅者简化Android事件的传递
        可以用于Android四大组件之间的通讯，也可以用于异步线程和主线程间的通讯、

        传统的事件传递方式：Handler、
        BroadcastReceiver、Interface回调。

        EventBus相对来说优点：代码简介、使用简单、并将事件发布和订阅充分解耦

        事件 Event  又可称为消息，其实就是一个对象，可以是网络请求返回的字符串，也可以是某个
        开关状态等等。 事件类型EventType是指事件所属的Class

        事件可分为一般事件和Sticky事件，相对一般事件，Sticky事件不同之处在于，当事件发布后，
        再有订阅者开始订阅该类型事件，依然能收到该类型事件的最近一个Sticky事件。

        订阅者Subscriber   订阅某种事件类型对象，当有发布者发布这类事件后，EventBus会执行订阅者
        的onEvent函数，这个函数叫事件响应函数。订阅者通过register接口订阅某个事件类型，unregister
        接口退订。订阅者存在优先级，优先级高的订阅者可以取消事件继续向优先级低的订阅者分发，默认所有
                订阅者优先级都为0

        发布者Publisher：发布某事件的对象，通过post接口发布事件

        简单使用：

        EventBus是解决第二个页面向第一个页面传递信息的，如果你需要从第一个页面向第二个页面传递信息
        直接使用Intent携带信息就可以了。

        EventBus分为接受页面和传递页面

                接受信息页面需要注册和取消注册以及处理接受的信息这三步操作

        EventBus.getDefault().register(this);
        EventBus.getDefault().unregister(this);
        @Subcribe
        自定义方法

                发布消息页面
        EventBus.getDefault().post(事件);

        原理：利用反射-调用处理信息的方法
        HashMap<Class<?>,List>
        定义的处理信息的方法的参数作为 HashMap的key


        onServiceConnected Service

        //todo 打开APP

        通过浏览器打开APP是一个很常见的功能了，具体的操作方法需要公司的网页开发人员和APP开发人员
        共同合作完成。

        我们经常会遇到这样的需求，通过点击一个链接打开APP

        对于APP打开最常规的就是通过url scheme的方式去打开APP，或者在其他APP中通过点击某个链接
        打开另一个APP。
        这些都是通过用户自定义的URI scheme实现的，不过背后还是Android的Intent机制。Google官网
        文档（https://developer.chrome.com/multidevice/android/intents）。介绍了在Android
        Chrome浏览器中网页打开APP的两种方法，一种是用户自定义的URI scheme（Custom URI scheme）
        另外一种就是 "intent:"语法（Intent-based URI）

        第一种用户自定义的URI scheme 形式如下：
        scheme://host/path?parameters

        第二种的Intent-based URI的语法形式如下：
        intent://host#Intent;参数;end

        第二种形式可以看成是第一种形式的特例，很多文章将第二种形式叫Intent Scheme
        URL，但是在
        Google的官方文档中并没有这样的说法。



        例如：
        myapp://   (实际上就相当于一种协议，是你和网页开发人员定下的协议)

        myapp://

        Custom Scheme URI打开APP

                基本用法

        需求：使用网页打开一个APP，并通过URL的参数给APP传递一些数据。

        比如：
        mayapp://aa.bb.c?id=1233

        网页端简单的写法：

        <html>
        <head>
        <title>URI打开APP</title>
        <head>
        <body>
        <a href="mayapp://aa.bb.c?id=1233>打开Demo APP </a>
                </body>
        </html>

                APP端需要接收来自网页信息的Activity，要在AndroidManifest.xml文件中的
        Activity的intent-filter中声明相应的action、category和data的scheme等

                <activity
        android:name=".activity.main.StartActivity"
        android:screenOrientation="portrait">
        <intent-filter>
        <action android:name="android.intent.action.MAIN"/>

        <category android:name="android.intent.category.LAUNCHER"/>
        </intent-filter>
        <intent-filter>
        <action android:name="android.intent.action.VIEW"/>
        <category android:name="android.intent.category.DEFAULT"/>
        <category android:name="android.intent.category.BROWSABLE"/>
        <data android:scheme="myapp" android:host="aa.bb.c"（这个host可以不用加）/>
        </intent-filter>
        </activity>

        */
    }

}
