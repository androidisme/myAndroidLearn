package com.syd.mystudydemo.training_progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.syd.mystudydemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sydMobile on 2018/3/16.
 */

public class ActivityProgressBarMain extends Activity {
    @BindView(R.id.pb)
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar_main);
        ButterKnife.bind(this);
//        R.attr.actionBarSize
//        init();
        //TODO ProgressBar 介绍和使用
        /*
        ProgressBar
        [图片ProgressBar1]
        [图片ProgressBar2]
        [图片ProgressBar3]

        指示用户操作进度的控件，进度条支持两种模式的进度：确定的和不确定的。
        这两种模式之间的差异介绍可以参考（<a href="https://material.io/guidelines/components/
        progress-activity.html#progress-activity-types-of-indicators">）这里面介绍的，
        我查看了一下：Progress 和 activity indicators 都是程序在加载内容的时候的可视化的提示
        应该使用单个视觉指示器来表示每种类型的操作。例如，刷新操作应显示刷新栏或者活动圈两者
        中的一个，不能同时显示。
        确定进度的指示器：可以显示操作将花费的时间

        不确定进度的指示器：只显示等待的状态，没有具体时间

        指示器类型：

        当可以检测到完成部分的百分比的时候，确定进度

        Android  4.0

        targetSdkVersion： 14
        minSdkVersion  14

        android:theme="@style/Theme.AppCompat.Light"

        手机 6.0

        样式 Metrail

        手机 4.4
        样式 Holo

        支持库

        彻底搞清楚 Attr 、 Style 、Theme
        相信这三个词对于Android开发者来说是十分熟悉了，那么你对他们到底了解吗？
        回忆起我刚开始接触Android的时候对这三个词有一些迷惑。
        今天就来仔细说说这三个词，总的说来 attr、style、theme都是用来表达样式风格的，
        只是范围不一样。下面我们来具体的一个一个的说明。

                 Attr :单词的意思是属性的意思（但是这里的属性和xml控件中的属性不是一个意思，不要混淆
                 ，Attr说是属性只是说的是它的单词的意思是属性），是通过
                Attr来定义我们控件中所使用的属性的，这样说可能大家会有一迷惑，
               那么来举个栗子：
               比如我们在控件中最多使用的 layout_width 属性，
               [图片layout_width]
               这个属性就是在Attr里面定义的,那么如何来查找这个属性呢？上图
               [图片Attribute位置]
               [图片Attribute位置1]
               看到上面的图片，我们可以看到在Android的sdk中给我们建立了一个attr文件，
               这里面就是定义了我们在控件中用到的属性。我们再到Android的SDK给我们定义的
               attr文件中去看看
               [图片view]
               [图片view1]
               [图片view2]
               [图片view3]
               看到这是为view这个控件定义的属性,看注释介绍的很清楚，这是为View和他的子类提供
               的属性组，也就是说这里面的属性都可以用在view和它的子类中。看到这里面的属性是不是
               很眼熟啊，这里面的属性是不是我们在写布局的时候都有用到过啊。
               再来看看Android SDK为TextView定义的属性组
               [TextView 属性]
               等等，我们用到的控件在这里都有对应的属性进行声明。看到这里是不是明白了attr的意思了，
               说attr其实就是一个文件，这里面定义了我们的控件中所使用的属性。

               下面我们就再来具体的说一下attr的一些知识。

               如何定义attr ？

               我们首先来看看Android的官方属性是如何进行定义了

               [TextView属性定义]
               我们看到首先声明了一组属性，取了一个名字叫 TextView，
               然后在这里面定义了一系列的属性。
               我在这里总结了属性的定义格式

                  1   <declare-styleable name="TextView">
                          2  <attr  name ="属性1" format = "这个属性的取值格式">

                             3  <enum name="取值1" value="程序中对应的值"/>
                                <enum name="取值1" value="程序中对应的值"/>
                                <enum name="取值1" value="程序中对应的值"/>
                                <enum name="取值1" value="程序中对应的值"/>

                             4  <flag name="取值1" value="程序中对应的值" />
                                <flag name="取值2" value="程序中对应的值" />
                                <flag name="取值3" value="程序中对应的值" />

                     </declare-styleable>
                其中3和4是可以省略的， format也是可以省略的（我们之所以定义属性，一般就是在自定义View中
                使用，如果省略了format的话只是在布局中我们使用这个属性的时候没有提示，只要在布局中填的
                属性内容和你的java文件的取值对应就没问题。不过还是建议format要定义好，这样更清晰不容易乱）

                3就是我们提前给这个属性设置了几个值，可以直接在这几个值中取，与4的区别就是，flag可以在布局文件
                这样使用 取值1|取值2 也就是说可以取多个值。
                例子：
                [layout_width定义]
                这里就是我们常用的layout_width的定义方式：看到我们可以将layout_width的值设置为fill_parent
                或者match_parent或wrap_content或者自己填写大小

                textStyle   我们的取值就可以是多个了，就不再多介绍了。

                好了，下面我们可以自己来定义属性了

                [图片自定义属性]
                重点来介绍format里面的一些值
                fraction：百分数
                例子： <attr name = "xshow" format= "fraction"/>
                 使用：

                 app:xshow = "70%"

                reference : 指定某一资源ID

                例子： <attr  name = "backgroundresourece" format = "reference"/>

                使用 ： app:backgroundresourece = "@drawable/id"
                别的格式基本上就是见名知意，就不再介绍了。


               属性的取值

               在某些情况下，我们可能想让某个属性取另一个属性的值，这样说可能不太好懂。看例子!

               [test_attr图片]

               上图是我自己定义的一个属性。
               在我的布局中有一个TextView,我想让Text的内容取test_attr的内容，怎么办呢？
               [textView中使用test_attr属性]
               没错就是 ?attr/属性名字 这样就是取 test_attr这个属性的值，如果test_attr是
               android里面的attr值呢？那么引入方式就是 ：?android:attr/属性名字 或者 省去
               attr
               以上的操作都有一个前提：

               attr的值只有在theme中被赋值才有效(否则这样取值的结果就是程序报错，注意在有些
               主题中有些属性给了默认值，这个时候引用就没有错，但是如果没有默认值，而你又没有在主题中给定义
               上那样就会出错了)。
               也就是说必须在清单文件中的 Application或者 Activity中设置 Theme，并且Theme指向的属性有值
               才可以引用attr的值。

                在单独的控件中使用 android：Theme 或者 app：theme添加样式是没有用的


                Style介绍
                style就像单词意思一样，风格，这里面是属性的集合，如果页面中有许多控件的属性值相同

                那么就可以把这些属性抽出来放到style里面。
















         */
    }

//    @Override
//    protected void initView() {
//        super.initView();
//
//    }
}
