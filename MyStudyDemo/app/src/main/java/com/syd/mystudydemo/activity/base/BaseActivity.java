package com.syd.mystudydemo.activity.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2017/11/8.
 */

public class BaseActivity extends Activity {
    public String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getSimpleName();
    }

    protected void init() {
        initDef();
        initView();
        initListener();
    }

    /**
     * 初始化定义内容
     */
    protected void initDef() {

    }

    /**
     * 初始View
     */

    protected void initView() {

    }

    /**
     * 注册监听事件
     */
    protected void initListener() {

    }
}
