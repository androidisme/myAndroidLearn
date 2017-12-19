package com.syd.mystudydemo.manager;

import android.content.Context;
import android.util.Log;

import com.syd.mystudydemo.activity.ActivityThird;

/**
 * Created by Administrator on 2017/11/17.
 */


public class CustomManager {
    private static CustomManager sInstance;
    String TAG = getClass().getSimpleName();
    private Context mContext;

    private CustomManager(Context context) {
        mContext = context;
    }

    public static CustomManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new CustomManager(context);
        }

        return sInstance;
    }

    public void log() {
        Log.e(TAG, "CustomManager" + sInstance);
        Log.e(TAG, "==log()" + mContext);
        Log.e(TAG, "==" + mContext.getPackageName());

        Log.e(TAG, "==" + ((ActivityThird) mContext).TAG);
    }
}

