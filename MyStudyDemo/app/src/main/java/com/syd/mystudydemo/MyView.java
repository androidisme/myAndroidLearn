package com.syd.mystudydemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sydMobile on 2018/4/16.
 */

public class MyView extends View {
    /**
     *
     * @param context
     */
    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, 0);

    }


}
