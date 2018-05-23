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

    @Override
    protected void initDef() {
        super.initDef();
        //获取manager
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        etSearch.requestFocus();
        //创建一个 MyResultReceiver实例
        mMyResultReceiver = new MyResultReceiver(new Handler());


    }

    @Override
    protected void onResume() {
        super.onResume();
        //将自己注册到MyResultReceiver中
        mMyResultReceiver.setmReceiver(this);
        etSearch.requestFocus();
        imm.isActive();
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                //展示软键盘
                imm.showSoftInputFromInputMethod(etSearch.getWindowToken(), InputMethodManager.SHOW_IMPLICIT);
            }
        }, 100);


    }

    @Override
    protected void onPause() {
        super.onPause();
        //取消注册
        mMyResultReceiver.setmReceiver(null);

    }

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

    /**
     * MyReceiverResult onReceiveResult实现方法
     *
     * @param resultCode
     * @param resultData
     */
    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        int progress = resultData.getInt("progress");
        pb.setMax(50);
        pb.setProgress(progress);
        tvNum.setText(progress + "");
    }
}
