package com.syd.mystudydemo.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;

/**
 * 关于 测量尺寸 的工具类
 * Created by 孙亦东 on 2018/5/23.
 */

public class UtilsMeasure {
    /**
     * 获取屏幕高度（不包括底部虚拟导航栏，但是包括顶部状态栏高度）
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }

    /**
     * 获取屏幕高度 （不包括底部虚拟导航栏，但是包括顶部状态栏高度）
     *
     * @param activity
     * @return
     */
    public static int getScreenHeightByPoint(Activity activity) {

        return getPoint(activity).y;

    }

    /**
     * 获取 屏幕真正的高度（包括了底部导航栏）
     *
     * @param activity
     * @return
     */
    public static int getRealScreenHeightByPoint(Activity activity) {
        return getRealPoint(activity).y;
    }

    /**
     * 获取 屏幕真正的高度 （包括了底部导航栏）
     *
     * @param activity
     * @return
     */
    public static int getRealScreenHeight(Activity activity) {
        return getRealDisplayMetrics(activity).heightPixels;
    }

    //============================================================================================

    /**
     * 获取顶部状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusHeight(Context context) {

        int id = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(id);

    }

    /**
     * 获取顶部状态栏高度
     *
     * @param activity
     * @return
     */
    public static int getStatusHeightByRect(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }


    //=============================================================================

    /**
     * 通过 context 获取 DisplayMetrics
     *
     * @param context
     * @return
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {

        return context.getResources().getDisplayMetrics();

    }

    /**
     * 通过 activity 获取 DisplayMetrics （不包括底部导航栏）
     *
     * @param activity
     * @return
     */
    public static DisplayMetrics getDisplayMetrics(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;

    }

    /**
     * 通过 activity 获取 DisplayMetrics （整个屏幕，包括了底部导航栏）
     *
     * @param activity
     * @return
     */
    public static DisplayMetrics getRealDisplayMetrics(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindow().getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;

    }

    /**
     * 返回 Point 这个 Point 是不包括 底部导航栏的
     *
     * @param activity
     * @return
     */
    public static Point getPoint(Activity activity) {
        Point point = new Point();
        activity.getWindow().getWindowManager().getDefaultDisplay().getSize(point);
        return point;
    }

    /**
     * 返回 Point 这个 Point 是整个屏幕的 Point （包括底部导航栏）
     *
     * @param activity
     * @return
     */
    public static Point getRealPoint(Activity activity) {
        Point point = new Point();
        activity.getWindow().getWindowManager().getDefaultDisplay().getRealSize(point);
        return point;
    }


}
