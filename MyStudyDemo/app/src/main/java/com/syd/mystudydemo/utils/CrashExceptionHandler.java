package com.syd.mystudydemo.utils;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/21.
 */

public class CrashExceptionHandler implements Thread.UncaughtExceptionHandler {
    public static CrashExceptionHandler crashExceptionHandler;
    String TAG = getClass().getSimpleName();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    private CrashExceptionHandler() {

    }

    /**
     * 获取自定义的异常处理类
     *
     * @return
     */
    public static synchronized CrashExceptionHandler getInstace() {
        if (crashExceptionHandler == null) {
            crashExceptionHandler = new CrashExceptionHandler();
        }
        return crashExceptionHandler;
    }

    /**
     * 初始操作
     */
    public void init() {
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
//        new Handler().post(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        Looper.loop();
//                    } catch (Throwable e) {
//                        if (e != null) {
//                            Log.e("====", e.getMessage());
//                        }
//                    }
//                }
//            }
//        });
    }

    /**
     * 异常处理
     *
     * @param t
     * @param e
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
//        if (e != null && mDefaultHandler != null) {
//            mDefaultHandler.uncaughtException(t, e);
//        }
        if (e != null) {
            // 在这里你就可以对异常进行处理了（比如：把错误日志发送到服务器端，等等操作）
            Log.e(TAG + simpleDateFormat.format(new Date()), e.getMessage());
        }


    }

}
