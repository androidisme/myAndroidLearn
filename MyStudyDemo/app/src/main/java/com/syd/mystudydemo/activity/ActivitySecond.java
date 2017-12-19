package com.syd.mystudydemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syd.mystudydemo.MyApplication;
import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;
import com.syd.mystudydemo.config.AppConst;
import com.syd.mystudydemo.utils.UtilsProcess;

/**
 * Created by Administrator on 2017/11/8.
 */

public class ActivitySecond extends BaseActivity implements View.OnClickListener {
    private Button button;
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
        Log.e(TAG, "getBaseContext-->" + getBaseContext());
        Log.e(TAG, "getApplication-->" + getApplication());
        Log.e(TAG, "getApplicationContext()-->" + getApplicationContext());
        Log.e(TAG, "MyApplication.ss" + MyApplication.ss);



    }

    @Override
    protected void initView() {
        super.initView();
        button = findViewById(R.id.bt_secondprocess);
        button.setText("第三个Activity");
        textView = findViewById(R.id.tv);
        textView.setText(getClass().getSimpleName());

    }

    @Override
    protected void initListener() {
        super.initListener();
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_secondprocess:
                Intent intent = new Intent(this, ActivityThird.class);
                startActivity(intent);
                break;
        }
    }

}
