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
        当APP在线程中跑出了异常就会导致AP crash。比如我们最常见的NullPointerException
        空指针异常。有些时候我们不希望这种异常导致我们的APP crash，如果在debug状态下，程序
        很大的时候编译运行一次也不容易，debug的时候好不容易程序启动起来了，发生了crash就不能
        debug执行了，有时候会很耽误开发。所有有了这个自定义的异常处理。它可以捕获你的异常，使
        程序不会crash，这样就可以继续调试了。



         */


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
