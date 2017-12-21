package com.syd.mystudydemo.exceptionhandler;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Administrator on 2017/12/21.
 */

public class ExceptionHandler {
    //你自己定义的处理异常类
    private static CustomExceptionHandler mCustomExceptionHandler;
    private static Thread.UncaughtExceptionHandler mUncaughtExceptionHandler;
    //标记是否设置过异常处理
    private static boolean mIsInstall = false;

    private ExceptionHandler() {

    }

    /**
     * 安装自己的全局异常处理
     * @param customExceptionHandler 自定义的出现异常的处理类
     */
    public static synchronized void install(CustomExceptionHandler customExceptionHandler) {
        //如果已经安装过，就不再执行，避免重复执行
        if (mIsInstall) {
            return;
        }
        mIsInstall = true;
        mCustomExceptionHandler = customExceptionHandler;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        Looper.loop();
                    } catch (Throwable throwable) {
                        if (throwable instanceof QuitExceptionHandler) {
                            return;
                        }
                        if (mCustomExceptionHandler != null) {
                            mCustomExceptionHandler.handlerException(Looper.getMainLooper().getThread(), throwable);
                        }
                    }
                }
            }
        });
        mUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (mCustomExceptionHandler != null) {
                    mCustomExceptionHandler.handlerException(t, e);
                }
            }
        });

    }

    public static synchronized void uninstall(){
        if (!mIsInstall){
            return;
        }
        mIsInstall = false;
        mCustomExceptionHandler = null;
        //恢复之前的异常处理状态
        Thread.setDefaultUncaughtExceptionHandler(mUncaughtExceptionHandler);
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                throw new QuitExceptionHandler("Quit ExceptionHandler....");
            }
        });

    }

    /**
     * 自定义的处理异常
     */
    public interface CustomExceptionHandler {
        void handlerException(Thread thread, Throwable throwable);
    }

}
