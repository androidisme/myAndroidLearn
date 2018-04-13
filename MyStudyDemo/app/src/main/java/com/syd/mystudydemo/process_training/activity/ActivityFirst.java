package com.syd.mystudydemo.process_training.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.syd.mystudydemo.MyApplication;
import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;
import com.syd.mystudydemo.config.AppConst;
import com.syd.mystudydemo.utils.UtilsProcess;

import butterknife.ButterKnife;

/**
 * 线程、进程测试--页面1
 * Created by sydMobile on 2018/1/22.
 */

public class ActivityFirst extends BaseActivity implements View.OnClickListener {
    private Button bt_toSenconActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
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
    }

    @Override
    protected void initView() {
        super.initView();
        bt_toSenconActivity = (Button) findViewById(R.id.bt_secondprocess);
    }

    @Override
    protected void initListener() {
        super.initListener();
        bt_toSenconActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_secondprocess:
                Intent intent = new Intent(this, ActivitySecond.class);
                startActivity(intent);
                break;

        }
    }
}
