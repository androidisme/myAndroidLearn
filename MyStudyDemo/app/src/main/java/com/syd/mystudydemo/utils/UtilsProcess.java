package com.syd.mystudydemo.utils;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by Administrator on 2017/11/8.
 */

public class UtilsProcess {
    /**
     *
     * @param pid 当前进程id
     * @param context
     * @return
     */
    public static String getProcessName(int pid, Context context) {
        String processName = "";
        ActivityManager activityManager = (ActivityManager)
                context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess :
                activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                processName = appProcess.processName;
                return processName;
            }
        }
        return processName;
    }
}
