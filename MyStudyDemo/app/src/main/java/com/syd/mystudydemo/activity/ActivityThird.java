package com.syd.mystudydemo.activity;

import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.syd.mystudydemo.MyApplication;
import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;
import com.syd.mystudydemo.config.AppConst;
import com.syd.mystudydemo.manager.CustomManager;
import com.syd.mystudydemo.utils.UtilsProcess;

import butterknife.ButterKnife;

import static com.syd.mystudydemo.R.id.tv;

/**
 * Created by Administrator on 2017/11/8.
 */

public class ActivityThird extends BaseActivity implements View.OnClickListener {
    //开启线程
//    @BindView(R.id.tv_thread)
    TextView tvThread;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
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
        textView = findViewById(tv);
        textView.setText(getClass().getSimpleName());
        Log.e(TAG, "==" + this);
        CustomManager.getInstance(this).log();

    }

    @Override
    protected void initListener() {
        super.initListener();
        textView.setOnClickListener(this);
        tvThread.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv:
                String testString = null;
                testString.equals("11");
                break;
            case R.id.tv_thread:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String testString = null;
                        testString.equals("11");

                    }
                }).start();
                break;

        }
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


}
