package com.syd.mystudydemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.syd.mystudydemo.MyApplication;
import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;
import com.syd.mystudydemo.config.AppConst;
import com.syd.mystudydemo.manager.CustomManager;
import com.syd.mystudydemo.utils.UtilsProcess;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.et_done)
    EditText etDone;
    @BindView(R.id.et_go)
    EditText etGo;
    @BindView(R.id.et_next)
    EditText etNext;
    @BindView(R.id.et_none)
    EditText etNone;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.et_send)
    EditText etSend;
    @BindView(R.id.et_unspecified)
    EditText etUnspecified;
    @BindView(R.id.bt_secondprocess)
    Button btSecondprocess;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    private Button bt_toSenconActivity;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        //通过进程ID获取当前进程的名字
        String processname = UtilsProcess.getProcessName(Process.myPid(), this);
        Log.e(TAG, TAG + AppConst.LOG_TAG);
        Log.e(TAG, "processname-->" + processname);
        Log.e(TAG, "MyApplication.string-->" + MyApplication.string);
        Log.e(TAG, "getBaseContext-->" + getBaseContext());
        Log.e(TAG, "getApplication-->" + getApplication());
        Log.e(TAG, "getApplicationContext()-->" + getApplicationContext());
        Log.e(TAG, "MyAlication.ss" + MyApplication.ss);
        /*
        EditText的一个属性（imeOptions）

        首先说明这个词的意思：imeOptions(ime其实是 Input Method Editor Options)翻译过来就是
        输入方法编辑选择。
        我们在Android官方文档查看这个属性
        ![]()

        参考：http://www.jianshu.com/p/060b5f68da79

        ![结构图,没有画]()
        Activity
        PhoneWindow
        DecorView
        TitleView
        ContentView

        DecorView是一个应用窗口的跟容器，继承自FrameLayout
        ![DecorView]()
        DecorView在API里面是隐藏的，所以直接查看FrameLayout的子类是找不到的
        DecorView有一个唯一的View，是一个垂直的LinearLayout，包含两个元素
        一个是TitleView（作为ActionBar的容器存在），另一个就是ContentView
        （我们显示的内容）。ContentView是一个FrameLayout，我们平常使用setContentView
        就是这设置它的子View。每一Activity都对应着一个Window（Window是抽象类，
        其实是它的实现类PhoneWindow）
        Window
        Window是一个抽象类，就是代表了一个窗口（与用户进行交互的窗口）
        实际上，窗口是一个宏观的思想，负责在屏幕上用于绘制各种UI元素以及响应用户的输入
        事件的一个矩形的区域。具有下面两个特点：
        独立绘制，不与其它界面相互影响；
        不会触发其它界面的输入事件；

        在Android系统中，窗口是独占一个Surface实例的显示区域，每个窗口的Surface由
        WindowManagerService分配。我们可以把Surface看做是一块画布，应用可以通过
        Canvas或者OpenGL在上面作画，绘画完成后，通过SurfaceFlinger将多块Surface按照
        特定的顺序（即Z-order）进行混合，而后再输出到FrameBuffer中，这样用户界面就可以
        显示了。

        android.view.Window这个抽象类可以看做Android中对窗口这一宏观概念所作出的约定，
        而PhoneWindow是对Window窗口的具体实现。

        Window这个抽象类包含了三个核心组件：


        初步理解，适合入门级别理解（）

        View的呈现过程。



        //  参考：https://github.com/android-notes/Cockroach
        http://www.jianshu.com/p/01b69d91a3a8

        当APP在线程中跑出了异常就会导致AP crash。比如我们最常见的NullPointerException
        空指针异常。有些时候我们不希望这种异常导致我们的APP crash，如果在debug状态下，程序
        很大的时候编译运行一次也不容易，debug的时候好不容易程序启动起来了，发生了crash就不能
        debug执行了，有时候会很耽误开发。所有有了这个自定义的异常处理。它可以捕获你的异常，使
        程序不会crash，这样就可以继续调试了。

        1.首先介绍 Thread.UncaughtExceptionHandler
        ![UncaughtExceptionHandler文档]()
        文档说明：当一个线程突然的因为没有捕获到的异常而停止的时候会由这个接口来处理。
        当一个线程由于没有捕获的异常而终止的时候,Java虚拟机将查询这个线程通过
        UncaughtExceptionHandler的getUncaughtExceptionHandler。并将调用uncaughtExce方法，
        并且把这个线程和异常作为参数传递过去。如果一个线程没有他的UncaughtExceptionHandler设置，
        那么它的
        ThreadGroup对象作为它的UncaughtExceptionHandler。如果ThreadGroup对象没有特别的
        处理异常要求，它可以调用getDefaultUncaughtExceptionHandler。即系统默认的的
        UncaughtExceptionHandler。
        简单来说UncaughtExceptionHandler就是用于在线程中当一些系统没有捕获的异常发生的时候来处理
        这些异常的。你可以使用系统默认的处理方式，你也可以通过
         Thread.setDefaultUncaughtExceptionHandler()方法设置你自己定义的异常处理。
         ![uncaughtException_method.jpg]()

         注意Thread.setDefaultUncaughtExceptionHandler(CustomUncaughtExceptionHandler)后
         只能保证当在你的程序中如果crash没有发生在UI线程（主线程）中而是在别的线程中的时候，
         这个时候APP是不会出现崩溃的现象的。如果在主线程中出现crash后，APP还是会崩溃的

         2.进一步防止程序出现崩溃的现象
            开头已经说了，有很多时候虽然我们的APP会因为各种问题闪退，但是在更多的时候我们是不希望
            我的APP闪退的这就出现了下面的方法。
            首先说明这种方法在Activity初始化的时候可能会导致你的APP出现类似ANR的情况（其实并不是
            ANR，只是状态看起来像，造成的原因是因为Activity还没有完成初始化，也就是生命周期还没有
            执行完毕就遇到异常了，导致了页面没法显示，所以在正式发布的APP中还是要慎重使用）

            如何使用呢？需要和你的后台商量好，在程序中做好标志控制该不该使用ExceptionHandler
            来处理。如果你的程序某个地方出现大量crash的时候，而这个功能是在Activity初始化后
            （可能是由于点击某个按钮触动的问题）这个时候你就可以用ExceptionHandler来处理了，
            让用户在点击这个按钮后，不至于程序崩溃掉。



         */
        Thread.getDefaultUncaughtExceptionHandler();
        Thread.getAllStackTraces();


        Thread.UncaughtExceptionHandler d;
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "===", Toast.LENGTH_LONG).show();
            }
        });
        FrameLayout frameLayout;

//
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "MyApplication.ss" + MyApplication.ss);
    }

    @Override
    protected void initView() {
        super.initView();
        bt_toSenconActivity = findViewById(R.id.bt_secondprocess);
    }

    @Override
    protected void initListener() {
        super.initListener();
        bt_toSenconActivity.setOnClickListener(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, AppConst.LOG_TAG + "onRestart=" + this);
        CustomManager.getInstance(this).log();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_secondprocess:
                Intent intent = new Intent(this, ActivitySecond.class);
                startActivity(intent);
                break;
        }
    }
}
