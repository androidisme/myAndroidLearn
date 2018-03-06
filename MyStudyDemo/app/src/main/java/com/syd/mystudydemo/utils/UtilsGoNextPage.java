package com.syd.mystudydemo.utils;

import android.content.Context;
import android.content.Intent;

import com.syd.mystudydemo.training_eventbus.ActivityEventBus;
import com.syd.mystudydemo.training_focus.ActivityMain;
import com.syd.mystudydemo.training_inputmanager.ActivityInputManager;

/**
 * Created by sydMobile on 2018/1/30.
 */

public class UtilsGoNextPage {
    /**
     * 到软键盘相关内容测试页面
     *
     * @param context
     */
    public static void toActivityInputManager(Context context) {
        Intent intent = new Intent(context, ActivityInputManager.class);
        context.startActivity(intent);
    }

    /**
     * 到EventBus练习页面
     * @param context
     */
    public static void toActivityEventBus(Context context) {
        Intent intent = new Intent(context, ActivityEventBus.class);
        context.startActivity(intent);
    }

    /**
     * 到焦点问题练习页面
     * @param context
     */
    public static void toActivityFocus(Context context) {
        Intent intent = new Intent(context, ActivityMain.class);
        context.startActivity(intent);
    }
}
