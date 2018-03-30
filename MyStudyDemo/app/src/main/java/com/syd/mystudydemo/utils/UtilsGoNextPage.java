package com.syd.mystudydemo.utils;

import android.content.Context;
import android.content.Intent;

import com.syd.mystudydemo.config.ActivityCategory;
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
     *
     * @param context
     */
    public static void toActivityEventBus(Context context) {
        Intent intent = new Intent(context, ActivityEventBus.class);
        context.startActivity(intent);
    }

    /**
     * 到焦点问题练习页面
     *
     * @param context
     */
    public static void toActivityFocus(Context context) {
        Intent intent = new Intent(context, ActivityMain.class);
        context.startActivity(intent);
    }

    /**
     * 跳转到某个Activity的方法
     *
     * @param context
     * @param cls
     */
    public static void toActivity(Context context, Class cls, ActivityCategory activityCategory) {
        switch (activityCategory) {
            //简单的Activity跳转
            case ACTIVITY_COMMON:
                Intent intent = new Intent(context, cls);
                context.startActivity(intent);
                break;
            case ACTIVITY_BYTEMOBILE:
                break;


        }
    }

/*
    package com.cnd.greencube.view;

    import android.content.Context;
    import android.content.res.TypedArray;
    import android.graphics.Bitmap;
    import android.graphics.Canvas;
    import android.graphics.Paint;
    import android.graphics.PorterDuff;
    import android.graphics.PorterDuffXfermode;
    import android.graphics.Rect;
    import android.graphics.RectF;
    import android.graphics.drawable.BitmapDrawable;
    import android.support.v7.widget.AppCompatImageView;
    import android.util.AttributeSet;
    import android.util.TypedValue;

    import com.cnd.greencube.R;

    *//**
     * 自定义角度ImagView
     *
     * @author 秦亚东
     *//*

    public class CustomAngleImageView extends AppCompatImageView {

        //控件的宽
        private int mMeasuredWidth;
        //控件的高
        private int mMeasuredHeight;
        //绘制预想中的弧线
        private Paint mArcPaint;
        //绘制边框
        private Paint mLinePaint;
        //绘制图片
        private Paint mBitmapPaint;
        //是否绘制边框
        private boolean isFrame;
        //绘制边框颜色
        private int frameColor;
        //预想圆弧角度
        private int angle;
        //绘制边框宽度
        private float frameWidth = dp2px(1);

        public CustomAngleImageView(Context context) {
            this(context, null);
        }

        public CustomAngleImageView(Context context, AttributeSet attrs) {
            this(context, attrs, 0);
        }

        public CustomAngleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            //初始化属性
            initAttrs(context, attrs);
            //初始化画笔
            initPaint();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(0, 0, 0, 0);
            mMeasuredWidth = getWidth();
            mMeasuredHeight = getHeight();
            BitmapDrawable mBitmapDrawable = (BitmapDrawable) getDrawable();
            if (null == mBitmapDrawable) {
                super.onDraw(canvas);
            } else {
                Bitmap mBitmap = mBitmapDrawable.getBitmap();
                Rect mRectSrc = new Rect(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
                Rect mRectDesc;
                if (isFrame) {
                    mRectDesc = new Rect(0 + (int) frameWidth, 0 + (int) frameWidth, mMeasuredWidth - (int) frameWidth, mMeasuredHeight - (int) frameWidth);
                } else {
                    mRectDesc = new Rect(0, 0, mMeasuredWidth, mMeasuredHeight);
                }
                canvas.drawBitmap(getAngleBitmap(mBitmap), mRectSrc, mRectDesc, mBitmapPaint);
                if (isFrame) {
                    canvas.drawRoundRect(new RectF(mRectDesc),
                            dp2px(mMeasuredWidth) / 180 * angle,
                            dp2px(mMeasuredHeight) / 180 * angle,
                            mLinePaint
                    );
                }
            }
        }

        *//**
         * 转换圆形Bitmap
         *
         * @param bitmap
         * @return
         *//*
        private Bitmap getAngleBitmap(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Rect mRect = new Rect(0, 0, width, height);
            RectF mRectF = new RectF(mRect);
            Bitmap mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas mCanvas = new Canvas(mBitmap);
            //绘制底部圆弧
            mCanvas.drawRoundRect(mRectF,
                    dp2px(width) / 180 * angle,
                    dp2px(height) / 180 * angle,
                    mArcPaint);
            //修改画笔属性
            mBitmapPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            //绘制图片
            mCanvas.drawBitmap(bitmap, mRect, mRect, mBitmapPaint);
            //还圆画笔属性
            mBitmapPaint.setXfermode(null);
            return mBitmap;
        }

        *//**
         * 初始化画笔
         *//*
        private void initPaint() {
            //弧形画笔
            initArc();
            //边框画笔
            initLine();
            //图片画笔
            initBitmap();
        }

        *//**
         * 图片画笔
         *//*
        private void initBitmap() {
            mBitmapPaint = new Paint();
            mBitmapPaint.setAntiAlias(true);
            mBitmapPaint.setDither(true);
        }

        *//**
         * 直线画笔
         *//*
        private void initLine() {
            mLinePaint = new Paint();
            mLinePaint.setAntiAlias(true);
            mLinePaint.setDither(true);
            mLinePaint.setStyle(Paint.Style.STROKE);
            mLinePaint.setColor(frameColor);
            mLinePaint.setStrokeWidth(frameWidth);
        }

        *//**
         * 弧形画笔
         *//*
        private void initArc() {
            mArcPaint = new Paint();
            mArcPaint.setAntiAlias(true);
            mArcPaint.setDither(true);
            mArcPaint.setColor(frameColor);
        }

        *//**
         * 初始化属性
         *
         * @param context
         * @param attrs
         *//*
        private void initAttrs(Context context, AttributeSet attrs) {
            TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomAngleImageView);
            isFrame = mTypedArray.getBoolean(R.styleable.CustomAngleImageView_angle_frame, false);
            frameColor = mTypedArray.getColor(R.styleable.CustomAngleImageView_angle_frameColor, getResources().getColor(R.color.greencube__white));
            angle = mTypedArray.getInteger(R.styleable.CustomAngleImageView_angle_radius, 90);
            frameWidth = mTypedArray.getDimension(R.styleable.CustomAngleImageView_angle_frameWidth, frameWidth);
            mTypedArray.recycle();



            <!--自定义ImagView，描边、自定义角度-->
            <declare-styleable name="CustomAngleImageView">
            <!--角度-->
            <attr name="angle_radius" format="integer" />
            <!--是否描边-->
            <attr name="angle_frame" format="boolean" />
            <!--描边的颜色-->
            <attr name="angle_frameColor" format="color" />
            <!--描边的颜色-->
            <attr name="angle_frameWidth" format="dimension" />
            </declare-styleable>

            <com.cnd.greencube.view.CustomAngleImageView
            android:id="@+id/iv_doctot_header"
            android:layout_width="85dp"
            android:layout_height="85dp"
            android:layout_marginLeft="30px"
            android:src="@mipmap/morentouxiang"
            app:angle_frame="true"
            app:angle_radius="90" />


        }


        *//**
         * dp转化px
         *
         * @return
         *//*
        private float dp2px(float value) {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
        }
    }*/


}
