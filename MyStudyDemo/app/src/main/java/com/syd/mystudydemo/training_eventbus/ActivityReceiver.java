package com.syd.mystudydemo.training_eventbus;

import android.os.Bundle;
import android.widget.TextView;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sydMobile on 2018/4/3.
 */

public class ActivityReceiver extends BaseActivity {
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_publish)
    TextView tvPublish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus_main);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void initDef() {
        super.initDef();
        EventBus.getDefault().register(this);

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent11(EntityEventObjectDemo eventObjectDemo) {
        tvContent.setText(eventObjectDemo.getName() + "  " + eventObjectDemo.getAdvantage());

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
