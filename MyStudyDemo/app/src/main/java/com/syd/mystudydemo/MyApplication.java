package com.syd.mystudydemo;

import android.app.Application;
import android.os.Process;

/**
 * Created by Administrator on 2017/11/8.
 */

public class MyApplication extends Application {
    public static String string =
            MyApplication.class.getSimpleName() + Process.myPid() + "===" + Process.myUid() + "===" + Process.myTid();
    public static String ss;
    String TAG = getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        //用于 process_training初始化
//        ProcessBusinessImp.getInstance(this).init(getApplicationContext(), getBaseContext());
        //ExceptionHander的使用
//        ExceptionHandler.install(new ExceptionHandler.CustomExceptionHandler() {
//            @Override
//            public void handlerException(Thread thread, Throwable throwable) {
//                if (throwable != null)
//                    Log.e("ExceptionHandler=====", throwable.getMessage() + "");
//            }
//        });


    }
}
