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

        Activity
        PhoneWindow
        DecorView
        TitleView
        ContentView

        DecorView是一个应用窗口的跟容器，继承自FrameLayout




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
