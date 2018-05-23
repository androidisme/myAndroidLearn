package com.syd.mystudydemo.training_okhttp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by sydMobile on 2018/5/21.
 */

public class ActivityOkHttp extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.bt_net)
    Button btNet;
    // 创建okHttpClient对象
    OkHttpClient mOkHttpClent = new OkHttpClient();

    String url = "http://192.168.1.118:8080/userhmv2/hppic";
    PopupWindow popupWindow = null;
    @BindView(R.id.bt_select_photo)
    Button btSelectPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_okhttp);
        ButterKnife.bind(this);
        init();

    }

    @Override
    protected void initView() {
        super.initView();
        View view = View.inflate(this, R.layout.pop_selectphoto, null);
        popupWindow = new PopupWindow(this, null, 0);
        popupWindow.setContentView(view);

    }

    @Override
    protected void initListener() {
        super.initListener();
        btNet.setOnClickListener(this);
        btSelectPhoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //开始请求网络
            case R.id.bt_net:
                net();
                break;
            //选择照片
            case R.id.bt_select_photo:
//                popupWindow.setTouchable(true);
//                popupWindow.setOutsideTouchable(true);
//                popupWindow.set

                popupWindow.setOutsideTouchable(true);
                popupWindow.setTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.RED));
                Point point = new Point();
                int x1 = point.x;
                int y1 = point.y;
                //获取屏幕宽高方法1
                getWindow().getWindowManager().getDefaultDisplay().getSize(point);
                int x = point.x;
                int y = point.y;

                //获取屏幕宽高方法2
                WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                int width = windowManager.getDefaultDisplay().getWidth();
                int height = windowManager.getDefaultDisplay().getHeight();

                //获取屏幕宽高方法3  去掉底部虚拟按键的
                DisplayMetrics metrics = new DisplayMetrics();
                WindowManager manager = getWindowManager();
                manager.getDefaultDisplay().getMetrics(metrics);
                int widthPixels = metrics.widthPixels;
                int heightPixels = metrics.heightPixels;


                // realMetrics
                manager.getDefaultDisplay().getRealMetrics(metrics);
                int width1 = metrics.widthPixels;
                int height1 = metrics.heightPixels;

                //获取屏幕宽高方法4
                Resources resources = getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                float density = displayMetrics.density;
                int densityDpi = displayMetrics.densityDpi;
//                popupWindow.showAsDropDown(btSelectPhoto);


                //获取状态栏高度----方法1
                int statusBarHeight1 = -1;
                //获取status_bar_height资源的ID
                int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");


                int IdTextView = getResources().getIdentifier("tv_content", "id", getPackageName());
                TextView textView = findViewById(IdTextView);
                textView.setText("getIdentifier");

                if (resourceId > 0) {
                    //通过 dimen里面的id获取对应的值
                    statusBarHeight1 = getResources().getDimensionPixelSize(resourceId);

                }
                //获取状态栏高度-----方法2
                Rect rect = new Rect();
                getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int top = rect.top;
                int right = rect.right;


                break;

        }
    }


    /**
     * 发送网络请求
     */
    public void net() {
        // 创建一个Request
        OkHttpClient.Builder builder = new OkHttpClient.Builder();


        FormBody formBody = new FormBody.Builder().add("longitude", "116.2861").add("latitude", "39.8585").build();

//        MediaType.parse("text/plain;charset=utf-8")
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), "");
        Request request = new Request.Builder().url(url).post(formBody).build();
        Call call = mOkHttpClent.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure===", "=====");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String htmlStr = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvContent.setText(htmlStr);
                    }
                });
            }
        });


    }
}
