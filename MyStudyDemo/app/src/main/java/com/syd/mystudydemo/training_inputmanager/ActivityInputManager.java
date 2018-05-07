package com.syd.mystudydemo.training_inputmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 关于键盘的测试学习内容
 * Created by sydMobile on 2018/1/30.
 */

public class ActivityInputManager extends BaseActivity implements View.OnClickListener, MyResultReceiver.Receiver {
    @BindView(R.id.et_search)
    EditText etSearch;//搜索框

    @BindView(R.id.iv_search)
    ImageView ivSearch;//搜索按钮

    InputMethodManager imm;
    @BindView(R.id.pb)
    ProgressBar pb;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.bt_start)
    Button btStart;
    //MyResultReceiver的实例变量
    private MyResultReceiver mMyResultReceiver;

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
    用 getSystemService(Context.INPUT_METHOD_SERVICE);来获取
    它的实例


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
    Service为普通的IME强制执行的，但必须由定制原始InputMethodSession实现的IME明确处理。

    只有活跃的客户端的 InputConnection 才会接受操作，IMF告诉每个客户端进程是否是活跃的，并且
    该框架会强制在非活动状态下调用当前的InputConnection将被忽略。这样就确保了当前的IME仅能够
    向用户所看到的用户界面提供事件和文本编辑。

     当屏幕关闭的时候，IME永远不会与（InputConnection）进行交互。这是通过屏幕关闭时使所有
     客户端处于非活动状态来实施的，并且防止了坏的IME在用户无法意识到其行为时驱动用户界面。

     客户端应用程序可以要求系统让用户选择新的IME，但是不能用编程的方式自行切换。这样可以避免
     恶意应用程序将用户选择的切换到自己的IME，当用户切换到另一个应用程序的时候，IME仍然会
     运行。另一方面，IME允许以编程的方式将系统切换到另一个IME，因为它已经有了完全的控制权对于
     用户输入来说。

     用户必须在设置之前明确启用新的IME，然后才能切换到该设置，以确认系统是否知道它并且希望其可
     供使用。

     一些对键盘的操作

     1.显示输入法键盘
     显示输入法键盘的方法有：
     InputMethodManager  imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

     imm.showSoftInput(View view,int flags);

     imm.showSoftInput(View view,int flags,ResultReceiver resultReceiver);

     boolean showSoftInput(View view,int flags)

     分别介绍一下：

     图片：showSoftInput(12)
     关于这个方法很简单，作用就是显示软键盘。
     参数介绍：
     view:当前焦点所在的view，这个view会接受键盘的输入

     view也不是所有的
     flags:提供附件的操作标志，可以取0、SHOW_IMPLICIT、


     图片：showSoftInput(123)

     明确要求当前输入法的软输入区域在需要时显示给用户。 如果用户与您的视图进行交互，
     并表达他们希望开始对其执行输入，请调用此函数。（注意只有当你穿入的view获得焦点的时候
     ，调用这个方法才会弹出键盘。）
     警告：传递给此方法的{@link ResultReceiver}实例可能是一个长寿命的对象，因为它可能
     不会被垃圾收集，直到所有相应的{@link ResultReceiver}对象传输到 不同的进程会被垃圾收集。
     遵循一般模式来避免Android中的内存泄漏。
     考虑使用{@link java.lang.ref.WeakReference}，以便{@link android.app.Activity}和{@link Context}
     等应用程序逻辑对象可以进行垃圾收集，无论{@link ResultReceiver}。

     @param resultReceiver如果非null，则IME会在处理完请求后告诉您它做了什么。 您收到的结果代码可能是
     {@link #RESULT_UNCHANGED_SHOWN}，
    {@link #RESULT_UNCHANGED_HIDDEN}，{@link #RESULT_SHOWN}或
    {@link #RESULT_HIDDEN}。

    介绍一下这个几个参数：
    RESULT_UNCHANGED_SHOWN = 0 ;
    showSoftInput(View,int,ResultReceiver)和hideSoftInputFromWindow(IBinder,int,ResultReceiver)
    中的ResultReceiver的结果代码标志，表示输入键盘的状态没有改变，仍然保持显示状态。也就是说在你调用
    这个方法之前输入键盘就处于显示状态了，调完之后仍然是显示状态。

    RESULT_UNCHANGED_HIDDEN = 1;
    showSoftInput(View,int,ResultReceiver)和hideSoftInputFromWindow(IBinder,int,ResultReceiver)
    中的ResultReceiver的结果代码标志，表示输入键盘的状态没有改变，仍然保持隐藏状态。

    RESULT_SHOWN = 2
    showSoftInput(View,int,ResultReceiver)和hideSoftInputFromWindow(IBinder,int,ResultReceiver)
    中的ResultReceiver的结果代码标志，表示输入键盘的状态发生了改变，切换到了显示的状态


    RESUlT_HIDDEN = 3
    showSoftInput(View,int,ResultReceiver)和hideSoftInputFromWindow(IBinder,int,ResultReceiver)
    中ResultReceiver的结果代码标志，表示输入键盘从显示切换到隐藏时的状态

    其中关于ResultReceiver简单的说一下，

    ResultReceiver

    用于接收某人的回调结果的通用接口。 通过创建子类并实现{@link #onReceiveResult}来使用它，
    然后您可以将其传递给其他人并通过IPC发送，并通过{@link #send}接收它们提供的结果。
    然后你可以通过send(int Bundle)这个方法在进程间（IPC）进行传递信息。

    用在showSoftInput(View,int,ResultReceiver)方法中就是，

    自己定义一个类继承ResultReceiver，重写里面的 onReceiveResult方法。
    onReceiverResult这个方法就是回调方法，用于处理其他进程传过来的数据

    比如：

    public class MyResultRecevier  extends ResultReceiver{

        public MyResultReceiver(Handler handler){

            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode,Bundle resultData){
            super.onReceiveResult(resultCode,resultData);
            //根据返回结果处理相应的逻辑
            // resultCode就会根据键盘的状态出现上面介绍的那几个值
        }

    }

    介绍一下 flag，也就是showSoftInput()方法的第二个参数

    这个参数的值可以取，0，SHOW_IM


    关于showSoftInput(View,int)起作用的条件，
    参数中的view必须是EditText以及他的子类，必须是获得焦点的，可见的，只有满足这些条件才起作用。
    另外必须在当前布局已经加载完成后showSoftInput()才起作用（其他的和键盘有关的方法都一样）。
    所以如果在onCreate中直接调用的话，很可能是不起作用的，这个时候开启一个延迟执行就可以了。


    写一个Activity用于启动IntentService

    */

    @Override
    protected void initDef() {
        super.initDef();
        //获取manager
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        etSearch.requestFocus();

//        ResultReceiver
//        imm.showSoftInput()
//        imm.toggleSoftInput(0, 0);
//        boolean isActive = imm.isActive();
        Method method;
        //创建一个 MyResultReceiver实例
        mMyResultReceiver = new MyResultReceiver(new Handler());


    }

    @Override
    protected void onResume() {
        super.onResume();
        //将自己注册到MyResultReceiver中
        mMyResultReceiver.setmReceiver(this);

//        getWindow().getDecorView().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        },100);


    }

    @Override
    protected void onPause() {
        super.onPause();
        //取消注册
        mMyResultReceiver.setmReceiver(null);

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
//        imm.toggleSoftInput(0, 0);
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        };
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDownLoadIntentService.startDownLoad(ActivityInputManager.this, mMyResultReceiver);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //搜索按钮
            case R.id.iv_search:
//                imm.hideSoftInputFromInputMethod(etSearch.getWindowToken(), 0);
//                imm.toggleSoftInt(0,0);
                imm.showSoftInput(etSearch, InputMethodManager.SHOW_IMPLICIT, new MyResultReceiver(new Handler()));
                break;

        }
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        int progress = resultData.getInt("progress");
        pb.setMax(50);
        pb.setProgress(progress);
        tvNum.setText(progress + "");
    }
}
