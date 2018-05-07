package com.syd.mystudydemo.training_inputmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

/**
 * Created by sydMobile on 2018/5/3.
 */

public class MyDownLoadIntentService extends IntentService {
    private static final String ACTION_DOWNLOAN = "download";
    private static final String EXTRA_PARAM1 = "receiver";
    private ResultReceiver mResultReceiver;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public MyDownLoadIntentService() {
        super("MyDownLoadIntentService");
    }

    public static void startDownLoad(Context context, MyResultReceiver myResultReceiver) {
        Intent intent = new Intent(context, MyDownLoadIntentService.class);
        intent.setAction(ACTION_DOWNLOAN);
        //MyResultReceiver继承了Parcelable所以可以被放进intent中作为参数直接传递
        intent.putExtra(EXTRA_PARAM1, myResultReceiver);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (ACTION_DOWNLOAN.equals(action)) {
                mResultReceiver = intent.getParcelableExtra(EXTRA_PARAM1);
                handleActionDownLoad();
            }
        }
    }

    private void handleActionDownLoad() {
        int i = 0;
        Bundle bundle = new Bundle();
        while (i++ <= 10) {
            bundle.putInt("progress", i);
            //每隔一秒中发送一次任务
            mResultReceiver.send(0, bundle);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
