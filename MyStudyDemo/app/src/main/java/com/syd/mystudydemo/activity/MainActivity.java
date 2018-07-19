package com.syd.mystudydemo.activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;
import com.syd.mystudydemo.config.ActivityCategory;
import com.syd.mystudydemo.process_training.activity.ActivityFirst;
import com.syd.mystudydemo.training_focus.ActivityMain;
import com.syd.mystudydemo.training_inputmanager.ActivityInputManager;
import com.syd.mystudydemo.training_okhttp.ActivityOkHttp;
import com.syd.mystudydemo.training_progressbar.ActivityProgressBarMain;
import com.syd.mystudydemo.training_shadow.ActivityShadow;
import com.syd.mystudydemo.training_surface.ActivitySurface;
import com.syd.mystudydemo.utils.UtilsGoNextPage;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create at sydMobile
 * 练习页面的主页面
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.tv_to_activity_first)
    TextView tvToActivityFirst;
    @BindView(R.id.tv_next_inputmanager)
    TextView tvNextInputmanager;
    @BindView(R.id.tv_next_eventbus)
    TextView tvNextEventbus;
    @BindView(R.id.tv_next_focus)
    TextView tvNextFocus;
    @BindView(R.id.tv_next_progressbar)
    TextView tvNextProgressbar;
    @BindView(R.id.tv_next_surface)
    TextView tvNextSurface;
    @BindView(R.id.tv_next_shadow)
    TextView tvNextShadow;
    @BindView(R.id.tv_next_okhttp)
    TextView tvNextOkhttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();

        /*
        EditText的一个属性（imeOptions）

        首先说明这个词的意思：imeOptions(ime其实是 Input Method Editor Options)翻译过来就是
        输入方法编辑选择。
        我们在Android官方文档查看这个属性
        ![]()



        参考：http://www.jianshu.com/p/060b5f68da79

        ![结构图,没有画]()
        Activity
        PhoneWindow
        DecorView
        TitleView
        ContentView
        DecorView是一个应用窗口的跟容器，本质上是FrameLayout,我们在API中可以
        看到DecorView是继承自FrameLayout的。
        ![DecorView]()
        DecorView在API里面是隐藏的，所以直接查看FrameLayout的子类是找不到的
        DecorView有一个唯一的View，是一个垂直的LinearLayout，包含两个元素
        一个是TitleView（作为ActionBar的容器存在），另一个就是ContentView
        （我们显示的内容）。ContentView是一个FrameLayout，我们平常使用setContentView
        就是这设置它的子View。每一Activity都对应着一个Window（Window是抽象类，
        其实是它的实现类PhoneWindow）
        Window
        Window是一个抽象类，就是代表了一个窗口（与用户进行交互的窗口）
        实际上，窗口是一个宏观的思想，负责在屏幕上用于绘制各种UI元素以及响应用户的输入
        事件的一个矩形的区域。具有下面两个特点：
        独立绘制，不与其它界面相互影响；
        不会触发其它界面的输入事件；

        在Android系统中，窗口是独占一个Surface实例的显示区域，每个窗口的Surface由
        WindowManagerService分配。我们可以把Surface看做是一块画布，应用可以通过
        Canvas或者OpenGL在上面作画，绘画完成后，通过SurfaceFlinger将多块Surface按照
        特定的顺序（即Z-order）进行混合，而后再输出到FrameBuffer中，这样用户界面就可以
        显示了。

        android.view.Window这个抽象类可以看做Android中对窗口这一宏观概念所作出的约定，
        而PhoneWindow是对Window窗口的具体实现。

        Window这个抽象类包含了三个核心组件：


        初步理解，适合入门级别理解（）

        View的呈现过程。


         */
        /*
        参考 http://blog.csdn.net/tgww88/article/details/7973476

        什么是Surface？

        在 sdk文档中，对Surface的描述是：Handle onto a raw buffer that is
        being managed by the screen compositor。翻译过来就就是：由屏幕显示
        内容合成器（screen compositor）所管理的原始缓冲区的句柄（当一个应用程序
        需要引用其他系统（如数据库、操作系统）所管理的内存块或者对象时可以使用句柄，
        说白了就是一个标示，通过这个标示就可找到对应的对象）

        解释一下这句话所包含的意思：
        Surface是由屏幕显示内容合成器（screen compositor）所管理的原生缓冲的句柄

        1.通过Surface（因为Surface就是句柄）就可以获取原生缓冲区以及其中的内容。就像
        在C++语言中，可以通过一个文件的句柄，就可以获得文件的内容一样。

        2.原始缓冲区（a raw buffer）是用于保存当前窗口的像素数据的。
        一般的我们可以理解为Android中的Surface就是一个用来画图形（graphics）或者
        图像（image）的地方。

        3. 在Surface对象中有一个Canvas（画布）对象，专门用于画图。

        总结：Surface中有Canvas成员，这个成员是专门用于供程序员进行画图的场所，就
        像黑板一样；其中原始缓冲区是用来保存数据的地方；Surface本身的作用类似一个句柄，
        得到了这个句柄就可以得到其中的Canvas、原始缓冲区以及其他方面的内容。
        Surface是用来管理数据的。

        Canvas是Java层构建的数据结构，是给View用的画布。ViewGroup会把自己的Canvas拆分
        给子View。View会在onDraw方法里将图形数据绘制在它获得的Canvas上。
        而Surface是Native层构建的数据结构，是给SurfaceFlinger用的画布。它是直接被用
        来绘制到屏幕上的数据结构。

        对于我们开发者来说，一般所用的View都是在Canvas进行绘制，然后最底层的View（通常
        是DecorView）的Canvas的数据信息会转换到一个Surface上，SurfaceFlinger会将
        各个应用窗口的Surface进行合成，然后绘制到屏幕上（实际上是一个Buffer，但是我们
        开发者不用考虑这些）

        简单的说Surface对应了一块屏幕缓冲区，每个window对应一个Surface，任何
        View都要画在Surface的Canvas上。传统的view共享一块屏幕缓冲区，所有的
        绘制必须在UI线程中进行。
        通过Surface可以获得原生缓冲区以及其中内容，可以理解为Surface就是一个
        用来画图形图形的地方。把每个Windows上的View都先绘制到Surface上，然后显示
        到屏幕上。


        SurfaceView

        View的测量（Measure），布局（Layout）以及绘制（Draw）的计算量比较大。计算完
        以后再从Canvas转换成Surface中数据，然后再绘制到屏幕，这个流程比较耗时。对于常规
        的UI绘制不会有什么问题，但是像Camera的预览以及视频的播放这样的应用场景来说就不可
        接受了。
        SurfaceView就是为了解决这个问题，SurfaceView内容不再是绘制在其他的Canvas上，而是直接
        绘制在其持有的一个Surface上。由于省去了很多步骤，其绘制性能大大提高。而SurfaceView
        本身只是用来控制这个Surface的大小和位置而已。

        SurfaceView：首先SurfaceView继承自View。但是SurfaceView有自己的Surface，
        SurfaceView内嵌了一个自己的Surface，可以控制这个Surface的格式和尺寸。
        SurfaceView控制这个Surface的绘制位置。

        参考：http://forlan.iteye.com/blog/2264245

        1.定义

        可以直接从内容或者DMA等硬件接口取得图像数据，是个非常重要的绘图容器。

        它拥有独立的绘图表面，即它不与其宿主窗口共享同一个绘图表面。由于拥有独立的绘图表面，因此
        SurfaceView的UI就可以在一个独立的线程中进行绘制。

        它的特性是：可以在主线程之外的线程中向屏幕绘图，这样可以避免画图任务繁重的时候造成主线程
        阻塞， 从而提高了程序的反应速度。在游戏开发中多用到SurfaceView，游戏中的背景、人物、动画
        等等尽量在画布canvas中画出。

        SurfaceView的核心在于提供了两个线程：UI线程和渲染线程。
        所有SurfaceView和SurfaceHolder.Callback的方法都应该在UI线程里调用，一般来说就是应用
        程序主线程。渲染线程所要访问的各种变量应该作同步处理。
        由于Surface可能被销毁，它只在SurfaceHolder.Callback.surfaceCreated()和SurfaceHolder.
        Callback.surfaceDestroyed之间有效，所以要确保渲染线程访问是合法有效的Surface。

        2.实现

        首先要继承SurfaceView并实现SurfaceHolder.Callback接口
        使用接口的原因：因为使用SurfaceView有一个原则，所有的绘图工作必须得在Surface被创建之后才
        能开始（Surface--表面，这个概念在图形编程中常常被提到。基本上我们可以把它当做显存的一个映射，
        写入到Surface的内容可以被直接复制到显存从而显示出来，这使得显示速度会非常快），而在Surface被
        销毁之前必须结束。所以Callback中的surfaceCreated和surfaceDestroyed就成了绘图处理代码的边界。

        需要重写Callback的方法：
        // 在Surface的大小发生改变时触发
        public void surfaceChanged（SurfaceHolder holder，int format，int width，int height）{}

        //在创建时触发，一般在这里调用画图的线程。
        public void surfaceCreated（SurfaceHolder holder）{}

        //销毁时触发，一般在这里将画图的线程停止、释放。
        public void surfaceDestroy(SurfaceHolder holder){}

        整个过程：
        继承SurfaceView并实现SurfaceHolder.Callback接口---->SurfaceView.getHolder()获得
        SurfaceHolder对象 -----> SurfaceHolder.addCallback(callback)添加回调函数---->
        SurfaceHolder.lockCanvas()获得Canvas对象并锁定画布---->Canvas绘画---->SurfaceHolder.
        unlockCanvasAndPost(Canvas canvas)结束锁定画图，并提交改变，将图形显示。

        3.SurfaceHolder

        这里用到了一个类SurfaceHolder，可以把它当成surface的控制器，用来操纵surface。处理它的
        Canvas上画的效果和动画，控制表面，大小，像素等。
        几个需要注意的方法：
        // 给SurfaceView当前的持有者一个回调对象
        abstract void addCallback（SurfaceHolder.Callback callback）;
        // 锁定画布，一般在锁定后就可以通过其返回的画布对象Canvas，在其上面画图等操纵了。
        abstract Canvas lockCanvas();
        // 锁定画布的某个区域进行画图等..因为画完图后，会调用下面的unlockCanvasAndPost来
        改变显示内容。相对部分内存要求比较高的游戏来说，可以不用重画dirty外的其他区域
        的像素，可以提高速度。

        abstract Canvas lockCanvas(Rect dirty);
        //结束锁定画图，并提交改变
        abstract void unlockCanvasAndPost(Canvas canvas);




         */
    }

    @Override
    protected void initView() {
        super.initView();
        tvNextSurface.setText(getResources().getString(R.string.text_surface));


    }

    @Override
    protected void initListener() {
        super.initListener();
        tvNextSurface.setOnClickListener(this);
        tvToActivityFirst.setOnClickListener(this);
        tvNextInputmanager.setOnClickListener(this);
        //到EventBus练习页面
        tvNextEventbus.setOnClickListener(this);
        //到Focus页面
        tvNextFocus.setOnClickListener(this);
        //到ProgressBar页面
        tvNextProgressbar.setOnClickListener(this);
        tvNextShadow.setOnClickListener(this);
        //到okHttp页面
        tvNextOkhttp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // 到线程练习页面
            case R.id.tv_to_activity_first:
//                Intent intent1 = new Intent(this, ActivityFirst.class);
//                startActivity(intent1);
                UtilsGoNextPage.toActivity(this, ActivityFirst.class, ActivityCategory.ACTIVITY_COMMON);
                break;
            // 到Surface练习页面
            case R.id.tv_next_surface:
                Intent intent2 = new Intent(this, ActivitySurface.class);
                startActivity(intent2);
                break;
            //到软键盘测试页面按钮
            case R.id.tv_next_inputmanager:
                UtilsGoNextPage.toActivity(this, ActivityInputManager.class, ActivityCategory.ACTIVITY_COMMON);
                break;
            case R.id.tv_next_eventbus:
//                UtilsGoNextPage.toActivity(this, ActivityEventBus.class, ActivityCategory.ACTIVITY_COMMON);
                new AlertDialog.Builder(this).setTitle("dddd").setMessage("内容").show();
                break;
            //到焦点练习页面
            case R.id.tv_next_focus:
                UtilsGoNextPage.toActivity(this, ActivityMain.class, ActivityCategory.ACTIVITY_COMMON);
                break;
            //到ProgressBar页面
            case R.id.tv_next_progressbar:
                UtilsGoNextPage.toActivity(this, ActivityProgressBarMain.class, ActivityCategory.ACTIVITY_COMMON);

                break;
            case R.id.tv_next_shadow:
                UtilsGoNextPage.toActivity(this, ActivityShadow.class, ActivityCategory.ACTIVITY_COMMON);
//                int ii = textReturn();
                break;
            case R.id.tv_next_okhttp:
                UtilsGoNextPage.toActivity(this, ActivityOkHttp.class, ActivityCategory.ACTIVITY_COMMON);
                break;
        }
    }

    public int textReturn() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 1) {
                    return 1;
                }
            }

            Log.e("Ddd", "ddd");
        }
        return 111;
    }
}
