package com.syd.mystudydemo.process_training.activity;

import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syd.mystudydemo.MyApplication;
import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;
import com.syd.mystudydemo.config.AppConst;
import com.syd.mystudydemo.utils.UtilsProcess;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.syd.mystudydemo.R.id.tv;

/**
 * Created by Administrator on 2017/11/8.
 */

public class ActivityThird extends BaseActivity implements View.OnClickListener {
    //开启线程
    @BindView(R.id.tv_thread)
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


        //TODO Reactive X
        /*
           LINQ(语言集成查询) （Language Integrated Query）语言集成查询是一组
           用于C#和Visual Basic语言的扩展。它允许编写C#或者Visual Basic代码以
           查询数据库相同的方式操作内存数据。
           参考：https://mcxiaoke.gitbooks.io/rxdocs/content/Intro.html
           Rx介绍

           Reactive X的历史

           Reactive X是Reactive Extensions的缩写，一般简写为Rx，最初是
           LINQ的一个扩展，由微软的架构师Erik Meijer领导的团队开发，在
           2012年11月开源，Rx是一个编程的模型，目标是提供一致的编程接口，帮助
           开发者更方便的处理异步数据流，Rx库支持.NET、JavaScript和C++,Rx
           近几年越来越流行了，现在已经几乎支持全部的流行编程语言了，Rx的大部分
           语言库由ReactiveX这个组织负责维护。
           Rx项目的地址：https://github.com/ReactiveX
           [rx_内容1]
           [rx_内容2]
           这里只是截取了Rx中的部分项目，可以看到几乎所有语言的都有。
           和我们Android开发者密切相关的就是RxJava和RxAndroid的啦

            什么是ReactiveX

            微软给的定义是：Rx是一个函数库，让开发者可以利用可观察序列
            和LINQ风格查询操作符来编写异步和基于事件的程序，使用Rx，
            开发者可以用Observables表示异步数据流，用LINQ操作符查询异步
            数据流，用


         */


    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

    }


    @Override
    protected void initView() {
        super.initView();
        textView = (TextView) findViewById(tv);
        textView.setText(getClass().getSimpleName());
        Log.e(TAG, "==" + this);

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
