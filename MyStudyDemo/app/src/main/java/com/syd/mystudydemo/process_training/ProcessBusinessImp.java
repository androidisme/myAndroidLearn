package com.syd.mystudydemo.process_training;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.util.Log;

import com.syd.mystudydemo.MyApplication;
import com.syd.mystudydemo.config.AppConst;
import com.syd.mystudydemo.utils.UtilsProcess;

import static android.content.ContentValues.TAG;
import static com.syd.mystudydemo.MyApplication.ss;

/** 业务实现
 * Created by sydMobile on 2018/1/22.
 */

public class ProcessBusinessImp {
    public static ProcessBusinessImp processBusinessImp;
    public Application application;
    private ProcessBusinessImp(){

    }
    private ProcessBusinessImp(Application application) {
        this.application = application;
    }

    public static synchronized ProcessBusinessImp getInstance(Application application) {
        if (processBusinessImp == null) {
            processBusinessImp = new ProcessBusinessImp(application);
        }
        return processBusinessImp;
    }

    /**用于Application中初始化
     *
     * @param getApplicationContext
     * @param getBaseContext
     */
    public void init(Context getApplicationContext, Context getBaseContext) {
        ss = UtilsProcess.getProcessName(Process.myPid(), getApplicationContext);
        Log.e(TAG, TAG + AppConst.LOG_TAG);
        Log.e(TAG, TAG + "onCreate()");
        Log.e(TAG, "MyApplication.class.getName()-->" + MyApplication.class.getName());
        Log.e(TAG, "getBaseContext-->" + getBaseContext);
        Log.e(TAG, "getApplicationContext()-->" + getApplicationContext);

    }
}
