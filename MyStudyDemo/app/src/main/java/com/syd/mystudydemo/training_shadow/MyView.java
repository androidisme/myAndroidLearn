package com.syd.mystudydemo.training_shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by sydMobile on 2018/4/10.
 */

public class MyView extends View {
    Paint paint;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        TypedArray typedArray = context.getResources().obtainTypedArray(R)
//        TypedArray typedArray = context.getResources().obtainAttributes()
        initPaint();
    }

    public void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(200);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = getWidth();
        int h = getHeight();
        float h1 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,150,getResources().getDisplayMetrics());
        float w1 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100,getResources().getDisplayMetrics());
        canvas.drawText("sss", 0, 2, 20, 100, paint);
        canvas.drawRect(0,376,100,600,paint);
    }
}
