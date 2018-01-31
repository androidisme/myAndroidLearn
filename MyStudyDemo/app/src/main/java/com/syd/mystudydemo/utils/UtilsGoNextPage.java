package com.syd.mystudydemo.utils;

import android.content.Context;
import android.content.Intent;

import com.syd.mystudydemo.training_inputmanager.ActivityInputManager;

/**
 * Created by sydMobile on 2018/1/30.
 */

public class UtilsGoNextPage {
    /**
     * 到软键盘相关内容测试页面
     * @param context
     */
    public static void toActivityInputManager(Context context) {
        Intent intent = new Intent(context, ActivityInputManager.class);
        context.startActivity(intent);
    }
}
