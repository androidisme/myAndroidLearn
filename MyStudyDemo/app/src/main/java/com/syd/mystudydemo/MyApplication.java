package com.syd.mystudydemo;

import android.app.Application;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

import com.syd.mystudydemo.config.AppConst;
import com.syd.mystudydemo.utils.UtilsProcess;

/**
 * Created by Administrator on 2017/11/8.
 */

public class MyApplication extends Application {
    public static String string =
            MyApplication.class.getSimpleName() + Process.myPid() + "===" + Process.myUid() + "===" + Process.myTid();
    String TAG = getClass().getSimpleName();
    public static String ss;

    @Override
    public void onCreate() {
//        startActivity(new Intent(this, ActivityThird.class));
        super.onCreate();
        ss = UtilsProcess.getProcessName(Process.myPid(),getApplicationContext());
        Log.e(TAG, TAG + AppConst.LOG_TAG);
        Log.e(TAG, TAG + "onCreate()");
        Log.e(TAG, "MyApplication.class.getName()-->" + MyApplication.class.getName());
        Log.e(TAG, "getBaseContext-->" + getBaseContext());
        Log.e(TAG, "getApplicationContext()-->" + getApplicationContext());
        Toast.makeText(this, "ddddd", Toast.LENGTH_LONG).show();

    }
}
