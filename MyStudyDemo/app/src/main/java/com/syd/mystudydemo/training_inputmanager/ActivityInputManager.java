package com.syd.mystudydemo.training_inputmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 关于键盘的测试学习内容
 * Created by sydMobile on 2018/1/30.
 */

public class ActivityInputManager extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.et_search)
    EditText etSearch;//搜索框

    @BindView(R.id.iv_search)
    ImageView ivSearch;//搜索按钮

    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputmanger_main);
        ButterKnife.bind(this);
        init();
    }
    //TODO InputManager
    /*
    InputMethodManager类的介绍
    [inputmethodmanager]()
    先来看看API对InputMethodManager类的介绍：
    以整体输入法架构（IMF(input method framework)）为架构
    的中央系统API，关系着应用程序和当前输入方法之间的交互。

    关于这个类有4个主要的主题：
    1.Architecture Overview
    2.Applications
    3.Input Methods
    4.Security

    Architecture Overview
    在输入法架构中有三个主要的部分。
    1.这个类所表达的输入法管理器是管理所有其他部分之间交互的系统中心点。
    它是存在在每个Context中的API，并与管理所有进程间交互的全局系统服务
    进行通信。

    2.输入法（IME）实现了一个特定的交互模型，允许用户来生成文本。系统会
    绑定到当前正在使用的输入法，使其被创建并运行，并且决定它何时隐藏和
    显示其UI。一次只可以运行一个IME

    3.多个客户端应用程序使用输入法管理器进行仲裁，用来获取输入焦点并控制
    IME的状态。一次只有一个这样客户端活动（与IME一起工作）

    Applications

    在大多数情况下，使用标准的TextView或者其子类的应用程序对于使用软输入方
    法工作的很少，你需要知道的主要事情是：

    在可编辑的文本视图中正确的设置inputType，以便输入方法具有足够的上下文来
    帮助用户输入文本。在输入法显示的时候处理丢失的屏幕空间，理想情况下，应用
    程序应该处理其窗口被调整的较小，但是如果需要，它可以依靠系统执行窗口的
    平移。你应该在你的Activity上设置windowSoftInputMode属性(在清单文件中设置
    关于这个属性，在下面会单独列出)，或者在你创建
    的窗口上设置相应的值用来帮助系统确定是平移还是调整大小（它会尝试自动确定，但
    可能会出现错误）。
    你还可以使用windowSoftInputMode属性来控制窗口的首选软输入状态（打开、关闭等）
    通过API可以实现更细致的控制，直接与IMF及IME进行交互-显示或者隐藏输入区域，让
    用户选择输入方法等。

    对于编写自己的文本编辑器的少数人员来说，需要实现
    InputConnection onCreateInputConnection (EditorInfo outAttrs)来返回你自己
    的InputConnection接口的新的实例，从而运行IME与您的编辑器进行交互。

    Input Methods
    输入法（IME）作为服务实现，通常从InputMethodService派生。它必须提供核心的
    InputMethod接口，虽然这通常由InputMethodService处理，实现着只需要在那里处理
    更高级别的API。
    有关实现IME的更多信息，参阅InputMethodService类（这里我们主要讲的是管理应用程序
    和输入法的InputMethodManager，对于InputMethodService不细说，这是关于输入法程序
    的）

    Security

    输入法有很多安全问题，因为它们本质上有完全驱动用户界面和监视用户输入的所有内容
    的自由。Android的输入法框架也允许任意的第三方输入法，所以必须小心限制它们的选择
    和交互。
    下面是一些关于IMF安全架构的一些关键点
    只有系统可以通过BIND_INPUT_METHOD权限来直接访问IME的InputMethod接口。这在系统中
    通过不绑定到不需要此权限的输入法服务来实施，因此系统可以保证其他不受信任的客户端正在
    访问其控制之外的当前输入法。

    在输入法框架（IMF）中可能会有很多客户进程，但是一次只能有一个活动的，不活跃的不能
    通过下面描述的机制与IMF的关键部分互动。

    输入方法的客户端只能访问其InputMethodSession接口。此接口的一个实例为每个客户端创建，
    并且只有来自与活动的客户端关联的会话的调用将被当前的IME处理。这是由AbstractInputMethod
    Service为普通的IME强制执行的，但必须由定制原始InputMethodSession实现的IME明确处理


        //TODO EventBus
       EventBus

       EventBus是一个Android事件发布/订阅框架，通过解耦发布者和订阅者简化Android事件的传递
       可以用于Android四大组件之间的通讯，也可以用于异步线程和主线程间的通讯、

       传统的事件传递方式：Handler、BroadcastReceiver、Interface回调。

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

       第二种形式可以看成是第一种形式的特例，很多文章将第二种形式叫Intent Scheme URL，但是在
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

    @Override
    protected void initDef() {
        super.initDef();
        //获取manager
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        boolean isActive = imm.isActive();
        Method method;



    }

    //TODO Hierarchy Viewer
    /*
    翻译自 https://developer.android.com/studio/profile/hierarchy-viewer.html
    官方文档
    审阅你的布局通过Hierarchy Viewer
    Hierarchy Viewer 是一Android Device Monitor里面的一个工具，它可以帮助你测量布局层次
    结构中每个视图的布局速度。它可以帮助你找到由视图层次结构造成的性能问题。

    注意：Hierarchy Viewer 不再被继续开发，要在运行时查看视图层次结构的性能，你应该使用
    在Android Studio中的Layout Inspector。但是Layout Inspector目前不能查看布局的内容信息。

    这篇文章提供了Hierarchy Viewer的介绍以及用于分析布局的例子。如果你想要
    查看UI中每个像素的布局，并将其与你的设计模式相比较，用 Pixel Perfect 工具

    Get set Up  设置

    如果您使用的是Android模拟器，则可以跳过本节。 否则，您需要按照以下步骤设置您的设备。

    注意你的Android设备系统必须是4.1或者更高。

    1. 打开开发者选项
    2. 在开发机器上设置环境变量ANDROID_HVPROTO = ddm。该变量告诉Hierarchy Viewer使用ddm协议连接到设备
    ，该协议与DDMS协议相同。 需要注意的是，连接到设备的主机上只能有一个进程，
    因此您必须终止任何其他DDMS会话才能运行Hierarchy Viewer。







     */

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initListener() {
        super.initListener();
        ivSearch.setOnClickListener(this);
        imm.toggleSoftInput(0, 0);
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //搜索按钮
            case R.id.iv_search:
                imm.hideSoftInputFromInputMethod(etSearch.getWindowToken(), 0);
//                imm.toggleSoftInput(0,0);
                break;

        }
    }
}
