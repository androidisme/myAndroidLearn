package com.syd.mystudydemo.activity;

import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;

import com.syd.mystudydemo.MyApplication;
import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;
import com.syd.mystudydemo.config.AppConst;
import com.syd.mystudydemo.manager.CustomManager;
import com.syd.mystudydemo.utils.UtilsProcess;

/**
 * Created by Administrator on 2017/11/8.
 */

public class ActivityThird extends BaseActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Log.e(TAG, TAG + AppConst.LOG_TAG);
        String processname = UtilsProcess.getProcessName(Process.myPid(), this);
        Log.e(TAG, "processname-->" + processname);
        Log.e(TAG, "MyApplication.string-->" + MyApplication.string);
        Log.e(TAG, "getApplication-->" + getApplication());
        Log.e(TAG, "getBaseContext-->" + getBaseContext());
        Log.e(TAG, "getApplicationContext()-->" + getApplicationContext());
        Log.e(TAG, "MyApplication.ss" + MyApplication.ss);


    }

    @Override
    protected void initView() {
        super.initView();
        textView = findViewById(R.id.tv);
        textView.setText(getClass().getSimpleName());
        Log.e(TAG, "==" + this);
        CustomManager.getInstance(this).log();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy()");
    }

    @Override
    protected void initListener() {
        super.initListener();
    }
}
