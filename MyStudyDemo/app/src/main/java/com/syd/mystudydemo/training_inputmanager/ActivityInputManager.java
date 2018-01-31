package com.syd.mystudydemo.training_inputmanager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 关于键盘的测试学习内容
 * Created by sydMobile on 2018/1/30.
 */

public class ActivityInputManager extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.et_search)
    EditText etSearch;//搜索框

    @BindView(R.id.iv_search)
    ImageView ivSearch;//搜索按钮

    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputmanger_main);
        ButterKnife.bind(this);
        init();
    }
    //TODO InputManager
    /*
    InputMethodManager类的介绍
    [inputmethodmanager]()
    先来看看API对InputMethodManager类的介绍：
    以整体输入法架构（IMF(input method framework)）为架构
    的中央系统API，关系着应用程序和当前输入方法之间的交互。

    关于这个类有4个主要的主题：
    1.Architecture Overview
    2.Applications
    3.Input Methods
    4.Security

    Architecture Overview
    在输入法架构中有三个主要的部分。
    1.这个类所表达的输入法管理器是管理所有其他部分之间交互的系统中心点。
    它是存在在每个Context中的API，并与管理所有进程间交互的全局系统服务
    进行通信。

    2.输入法（IME）实现了一个特定的交互模型，允许用户来生成文本。系统会
    绑定到当前正在使用的输入法，使其被创建并运行，并且决定它何时隐藏和
    显示其UI。一次只可以运行一个IME

    3.多个客户端应用程序使用输入法管理器进行仲裁，用来获取输入焦点并控制
    IME的状态。一次只有一个这样客户端活动（与IME一起工作）

    Applications

    在大多数情况下，使用标准的TextView或者其子类的应用程序对于使用软输入方
    法工作的很少，你需要知道的主要事情是：

    在可编辑的文本视图中正确的设置inputType，以便输入方法具有足够的上下文来
    帮助用户输入文本。在输入法显示的时候处理丢失的屏幕空间，理想情况下，应用
    程序应该处理其窗口被调整的较小，但是如果需要，它可以依靠系统执行窗口的
    平移。你应该在你的Activity上设置windowSoftInputMode属性(在清单文件中设置
    关于这个属性，在下面会单独列出)，或者在你创建
    的窗口上设置相应的值用来帮助系统确定是平移还是调整大小（它会尝试自动确定，但
    可能会出现错误）。
    你还可以使用windowSoftInputMode属性来控制窗口的首选软输入状态（打开、关闭等）
    通过API可以实现更细致的控制，直接与IMF及IME进行交互-显示或者隐藏输入区域，让
    用户选择输入方法等。

    对于编写自己的文本编辑器的少数人员来说，需要实现
    InputConnection onCreateInputConnection (EditorInfo outAttrs)来返回你自己
    的InputConnection接口的新的实例，从而运行IME与您的编辑器进行交互。

    Input Methods
    输入法（IME）作为服务实现，通常从InputMethodService派生。它必须提供核心的
    InputMethod接口，虽然这通常由InputMethodService处理，实现着只需要在那里处理
    更高级别的API。
    有关实现IME的更多信息，参阅InputMethodService类（这里我们主要讲的是管理应用程序
    和输入法的InputMethodManager，对于InputMethodService不细说，这是关于输入法程序
    的）

    Security

    输入法有很多安全问题，因为它们本质上有完全驱动用户界面和监视用户输入的所有内容
    的自由。Android的输入法框架也允许任意的第三方输入法，所以必须小心限制它们的选择
    和交互。
    下面是一些关于IMF安全架构的一些关键点
    只有系统可以通过BIND_INPUT_METHOD权限来直接访问IME的InputMethod接口。这在系统中
    通过不绑定到不需要此权限的输入法服务来实施，因此系统可以保证其他不受信任的客户端正在
    访问其控制之外的当前输入法。

    在输入法框架（IMF）中可能会有很多客户进程，但是一次只能有一个活动的，不活跃的不能
    通过下面描述的机制与IMF的关键部分互动。

    输入方法的客户端只能访问其InputMethodSession接口。此接口的一个实例为每个客户端创建，
    并且只有来自与活动的客户端关联的会话的调用将被当前的IME处理。这是由AbstractInputMethod
    Service为普通的IME强制执行的，但必须由定制原始InputMethodSession实现的IME明确处理


















     */

    @Override
    protected void initDef() {
        super.initDef();
        //获取manager
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        boolean isActive = imm.isActive();


    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initListener() {
        super.initListener();
        ivSearch.setOnClickListener(this);
        imm.toggleSoftInput(0,0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //搜索按钮
            case R.id.iv_search:
                imm.hideSoftInputFromInputMethod(etSearch.getWindowToken(), 0);
//                imm.toggleSoftInput(0,0);
                break;

        }
    }
}
