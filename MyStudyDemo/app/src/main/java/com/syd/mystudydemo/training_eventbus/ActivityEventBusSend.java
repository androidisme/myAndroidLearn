package com.syd.mystudydemo.training_eventbus;

import android.os.Bundle;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by sydMobile on 2018/2/26.
 */

public class ActivityEventBusSend extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus_main);
        init();
    }

    @Override
    protected void initDef() {
        super.initDef();
        EntityEventObjectDemo entityEventObjectDemo = new EntityEventObjectDemo();
        entityEventObjectDemo.setName("孙亦东");
        entityEventObjectDemo.setAge("23");
        entityEventObjectDemo.setAdvantage("哈哈");
        EventBus.getDefault().post(entityEventObjectDemo);
    }
}

