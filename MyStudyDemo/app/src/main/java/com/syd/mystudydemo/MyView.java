package com.syd.mystudydemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sydMobile on 2018/4/16.
 */

public class MyView extends View {
    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
       TypedArray typedArray =  context.obtainStyledAttributes(attrs,R.styleable.MyView);
        int isShow = typedArray.getInt(R.styleable.MyView_isShow,9);
        float show1 = typedArray.getDimension(R.styleable.MyView_num,9);

    }


}
