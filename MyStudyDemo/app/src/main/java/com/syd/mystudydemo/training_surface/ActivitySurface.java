package com.syd.mystudydemo.training_surface;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/1/22.
 */

public class ActivitySurface extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MySurfaceView(this));
    }

    class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
        // 定义控制器
        private SurfaceHolder holder;
        private MyThread myThread;

        public MySurfaceView(Context context) {
            super(context);
            holder = this.getHolder();
            holder.addCallback(this);
            myThread = new MyThread(holder);
        }

        public MySurfaceView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            this(context, attrs, defStyleAttr);
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
//            myThread.isRun = true;
//            myThread.start();
            Canvas canvas = holder.lockCanvas();
            canvas.drawColor(Color.RED);
            //创建画笔
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setAntiAlias(true);
            Rect rect = new Rect(100, 50, 300, 250);
            canvas.drawRect(rect, paint);
//            canvas.drawText("这是第" + (count++) + "秒", 100, 300, paint);
//            Thread.sleep(1000);
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            Toast.makeText(ActivitySurface.this, "format=" + format + "width=" + width + "height=" + height, Toast.LENGTH_LONG).show();

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            myThread.isRun = false;
        }
    }

    class MyThread extends Thread {
        public boolean isRun;
        private SurfaceHolder holder;

        public MyThread(SurfaceHolder holder) {
            this.holder = holder;
            isRun = true;
        }

        @Override
        public void run() {
            super.run();
            int count = 0;
            while (isRun) {
                Canvas canvas = null;
                try {
                    synchronized (holder) {

                        //锁定画布，一般在锁定后就可以通过其返回的画布对象Canvas，在其上面画图等操作
                        canvas = holder.lockCanvas();
                        canvas.drawColor(Color.RED);
                        //创建画笔
                        Paint paint = new Paint();
                        paint.setColor(Color.WHITE);
                        paint.setAntiAlias(true);
                        Rect rect = new Rect(100, 50, 300, 250);
                        canvas.drawRect(rect, paint);
                        canvas.drawText("这是第" + (count++) + "秒", 100, 300, paint);
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (canvas != null) {
                        holder.unlockCanvasAndPost(canvas);
                    }
                }
            }
        }
    }
}
