package com.syd.mystudydemo.training_focus;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sydMobile on 2018/3/6.
 * 焦点问题
 */

public class ActivityMain extends BaseActivity {
    @BindView(R.id.lv)
    ListView lv;
    List list;
    @BindView(R.id.sv)
    ScrollView sv;
    @BindView(R.id.tv_content1)
    TextView tvContent1;
    @BindView(R.id.tv_content2)
    TextView tvContent2;
    @BindView(R.id.bt)
    Button bt;
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.ll_child)
    LinearLayout llChild;
    @BindView(R.id.ll_group)
    LinearLayout llGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_main);
        ButterKnife.bind(this);
        init();

    }

    //TODO 经验总结：

    /*
    类似于Toast这种一定不要在项目中直接使用，抽离出来。
    还有APP的主色调，字体颜色等等
    凡是在多出使用，多次调用的内容要抽离出来！


     */

    @Override
    protected void initView() {
        super.initView();
        list = new ArrayList<>();
        final ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(arrayAdapter);
        boolean s = tvContent1.isFocused();
        boolean ss = tvContent1.isFocusableInTouchMode();
        boolean s1 = tvContent1.isFocusable();

        boolean s2 = tvContent2.isFocused();
        boolean s3 = tvContent2.isFocusable();
        boolean ss1 = tvContent2.isFocusableInTouchMode();
        boolean s4 = bt.isFocusable();
        boolean s5 = bt.isFocused();
        boolean s6 = et.isFocusable();
        boolean s11 = et.isFocusableInTouchMode();
        boolean s7 = et.isFocused();
        boolean s8 = bt.isFocusableInTouchMode();
        boolean s9 = tvContent2.isFocusableInTouchMode();

        boolean s10 = llChild.isFocusable();
        boolean s12 = llChild.isFocusableInTouchMode();

        boolean s13 = llGroup.isFocusable();
        boolean s14 = llGroup.isFocusableInTouchMode();
        boolean s81 = lv.isFocusableInTouchMode();
        boolean s91 = lv.isFocusable();
        boolean s101 = lv.isFocused();
        tvContent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean s10 = lv.isFocused();
                boolean s = tvContent1.isFocused();
                boolean ss = tvContent1.isFocusableInTouchMode();
                boolean s1 = tvContent1.isFocusable();
                boolean s2 = tvContent2.isFocused();
                boolean s3 = tvContent2.isFocusable();
                boolean ss1 = tvContent2.isFocusableInTouchMode();
                boolean s4 = bt.isFocusable();
                boolean s5 = bt.isFocused();
                boolean s6 = et.isFocusable();
                boolean s11 = et.isFocusableInTouchMode();
                boolean s7 = et.isFocused();
                boolean s8 = bt.isFocusableInTouchMode();
                boolean s9 = tvContent2.isFocusableInTouchMode();
                boolean sss = llGroup.isFocused();
            }
        });


        tvContent1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                boolean s10 = lv.isFocused();
                boolean s = tvContent1.isFocused();
                boolean ss = tvContent1.isFocusableInTouchMode();
                boolean s1 = tvContent1.isFocusable();
                boolean s2 = tvContent2.isFocused();
                boolean s3 = tvContent2.isFocusable();
                boolean ss1 = tvContent2.isFocusableInTouchMode();
                boolean s4 = bt.isFocusable();
                boolean s5 = bt.isFocused();
                boolean s6 = et.isFocusable();
                boolean s11 = et.isFocusableInTouchMode();
                boolean s7 = et.isFocused();
                boolean s8 = bt.isFocusableInTouchMode();
                boolean s9 = tvContent2.isFocusableInTouchMode();
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean s = tvContent1.isFocused();
                boolean ss = tvContent1.isFocusableInTouchMode();
                boolean s1 = tvContent1.isFocusable();
                boolean s2 = tvContent2.isFocused();
                boolean s3 = tvContent2.isFocusable();
                boolean ss1 = tvContent2.isFocusableInTouchMode();
                boolean s4 = bt.isFocusable();
                boolean s5 = bt.isFocused();
                boolean s6 = et.isFocusable();
                boolean s11 = et.isFocusableInTouchMode();
                boolean s7 = et.isFocused();
                boolean s8 = bt.isFocusableInTouchMode();
                boolean s9 = tvContent2.isFocusableInTouchMode();
            }
        });
        final Handler handler = new Handler() {
            @Override
            public String getMessageName(Message message) {
                return super.getMessageName(message);
            }

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    arrayAdapter.notifyDataSetChanged();
                    boolean s = tvContent1.isFocused();
                    boolean s1 = tvContent1.isFocusable();
                    boolean s2 = tvContent2.isFocused();
                    boolean s3 = tvContent2.isFocusable();
                    boolean s4 = bt.isFocusable();
                    boolean s5 = bt.isFocused();
                    boolean s6 = et.isFocusable();
                    boolean s7 = et.isFocused();
                    boolean s8 = lv.isFocusableInTouchMode();
                    boolean s9 = lv.isFocusable();
                    boolean s10 = lv.isFocused();
                }
            }
        };

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {

                    boolean s = tvContent1.isFocused();
                    boolean s1 = tvContent1.isFocusable();
                    boolean s2 = tvContent2.isFocused();
                    boolean s3 = tvContent2.isFocusable();
                    boolean s4 = bt.isFocusable();
                    boolean s5 = bt.isFocused();
                    boolean s6 = et.isFocusable();
                    boolean s7 = et.isFocused();
                    for (int i = 0; i < 20; i++) {
                        list.add("题目" + i + "contnet==" + i);

                    }
                    Thread.sleep(3000);
                    handler.sendEmptyMessage(0);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }
}
