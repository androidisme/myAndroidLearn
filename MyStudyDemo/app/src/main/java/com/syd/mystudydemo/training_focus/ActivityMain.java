package com.syd.mystudydemo.training_focus;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_main);
        ButterKnife.bind(this);
        init();
    }
    //todo MeasureSpec
    /*
    MeasureSpec类介绍
    [图片]
    首先MearsureSpec类是View类的一个内部静态类

    MeasureSpec封装了从父布局到子布局传递的布局需求，每个MeasureSpec代表了宽度或者高度
    的要求。

    MeasureSpec类由size和mode组成。有三种模式

    UNSPECIFIED 父布局没有施加任何的限制对子布局。它可以是任何他想要的大小

    EXACTLY    父布局已经确定了子布局的大小，子布局会在给出的界限内，不管他有多大

    AT_MOST    子布局可以像他希望的size一样大。

    MeasureSpecs用整数形式来实现用来减少对象的分配。




     */

    @Override
    protected void initView() {
        super.initView();
        List list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("题目" + i + "contnet==" + i);
        }
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
    }
}
