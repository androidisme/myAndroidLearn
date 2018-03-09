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
    //todo MeasureSpec
    /*

    http://blog.csdn.net/minimicall/article/details/40983331

    http://blog.csdn.net/hanhailong726188/article/details/46136569

    https://www.jianshu.com/p/a1c5ee18c072

    MeasureSpec类介绍
    [图片]
    首先MearsureSpec类是View类的一个内部静态类

    MeasureSpec封装了从父布局到子布局传递的布局需求，每个MeasureSpec代表了宽度或者高度
    的要求。

    MeasureSpec类由size和mode组成。有三种模式

    UNSPECIFIED  父布局没有施加任何的限制对子布局。它可以是任何他想要的大小


    EXACTLY    父布局已经确定了子布局的大小，子布局会在给出的界限内，子布局
    的大小是精确的，父布局给多大就是多大。

    AT_MOST    父布局会给定一个最大的值，子布局的大小是不能超过这个值的，可以比这个

    值小。

    MeasureSpecs用整数形式来实现用来减少对象的分配。那么是如何用整数形式来表示模式和
    大小的呢。

    [图片]

    就像图中画的那样前两位代表了模式，后30位代表了组件的大小，这样就用整数形式来表示
    模式和大小了。

    我们再来看看这三种模式分别对应的值是多少


    UNSPECIFIED == 0 << MODE_SHIFT   也就是0向左位移30位，也就是int类型的最高位
    是00

    EXACTLY = 1 <<MODE_SHIF;  也就是 01向左位移30位，也就是int类型的最高是01

    AT_MOST = 2 <<MODE_SHIF  也就是 10向左位移30位，int类型的最高位是 10

    再来看一看 makeMeasureSpec()这个方法

    [图片]

    用给定的大小和模式创建一个measure（上面已经说了这个值用整数的形式来表示）

    其中模式只能在上面给定这几个中选择

    再来说一下Scroll内部嵌套ListView的问题，如果我们直接嵌套ListView问题，出现
    的问题想必大家到知道了，就是ListView会显示不全。
    为什么会出现这种问题呢？
    原因是scrollView事件的消费处理和ListView的滑动处理冲突了，造成ListView控件的
    高度设定有问题。ScrollView中的ListView在OnMeasure阶段无法测出实际高度。

    解决方法：

    1.方法一：给他设置成AT_MOST模式，给定最大高度。

    代码中需要写的就是：自定义ListView类继承ListView，重写onMeasure方法
      @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
         super.onMeasure(widthMeasureSpec
                 ,MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST));
    }

    我们并没有改变widthMeasureSpec，仅仅是修改了heightMeasureSpec，也就是说在父布局中给我传入的
    heightMeasureSpec是不对的，这个时候这个值不是实际的高度。我们需要做的就是调用makeMeasureSpec
    (Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST)方法，返回一个可以让ListView程序全部内容的值，
    上面这个方法也有介绍。
    第一个参数为什么是Integer.MAX_VALUE >> 2呢？我们说了MeasureSpec用int类型表示前两位代表模式
    后30位代表大小，我们就需要让后面30位是int类型中最大的值就可以了。为什么选择AT_MOST模式呢？这个模式
    是父布局给定一个值，不能超过这个值，我们很显然已经给了最大值了。

    方法二：既然测不出高度，那么我就手中在代码中设置ListView的高度
public static void setListViewHeightBasedOnChildren(ListView listView) {
    if(listView == null) return;

    ListAdapter listAdapter = listView.getAdapter();
    if (listAdapter == null) {
        // pre-condition
        return;
    }

    int totalHeight = 0;
    for (int i = 0; i < listAdapter.getCount(); i++) {
        View listItem = listAdapter.getView(i, null, listView);
        listItem.measure(0, 0);
        totalHeight += listItem.getMeasuredHeight();
    }

    ViewGroup.LayoutParams params = listView.getLayoutParams();
    params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
    listView.setLayoutParams(params);
}
     一是Adapter中getView方法返回的View的必须由LinearLayout组成，因为只有LinearLayout才有measure()方法，
     如果使用其他的布局如RelativeLayout，在调用listItem.measure(0, 0);
     时就会抛异常，因为除LinearLayout外的其他布局的这个方法就是直接抛异常的，没理由…。

     二是需要手动把ScrollView滚动至最顶端

    总结起来，还是自定义Lisview比较好，但是会有一个问题，就是ListView在加载数据的时候，如果一页没有展示完全，那么
    scrollView会自动往下滑一点，造成刚进入这个页面的时候，看不到你想看的最顶部。

    解决方法很简单：

    1.在加载完数据后设置scrollView滑动顶部（scrollView.smoothScrollTo(0,0)）

    这种方法有一个缺点就是，你会看到屏幕会滑动一下。

    2.使用 descendantFousability属性

    descendantFocusability有三种属性

    beforeDescendants：viewgroup会优先其子类控件而获取到焦点

    afterDescendants：viewgroup只有当其子类控件不需要获取焦点时才获取焦点

     blocksDescendants：viewgroup会覆盖子类控件而直接获得焦点

     在ScrollView的LinearLayout中添加 android：denscendantFocusability = "blocksDescendants"



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
        tvContent1.setOnClickListener(new View.OnClickListener() {
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

        tvContent1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
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
//                    arrayAdapter.notifyDataSetChanged();

                    boolean s = tvContent1.isFocused();
                    boolean s1 = tvContent1.isFocusable();
                    boolean s2 = tvContent2.isFocused();
                    boolean s3 = tvContent2.isFocusable();
                    boolean s4 = bt.isFocusable();
                    boolean s5 = bt.isFocused();
                    boolean s6 = et.isFocusable();
                    boolean s7 = et.isFocused();
                    tvContent1.requestFocus();
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
                        Thread.sleep(3000);
                        handler.sendEmptyMessage(0);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }
}
