package com.syd.mystudydemo.training_bytemobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;
import com.syd.mystudydemo.process_training.activity.ActivitySecond;

import butterknife.BindView;
import butterknife.ButterKnife;

/**关于位运算测试页面
 * Created by sydMobile on 2018/1/22.
 */

public class ActivityByteMobile extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.et_input_num)
    EditText etInputNum;
    @BindView(R.id.et_input_move)
    EditText etInputMove;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.acBt_right)
    AppCompatButton acBtRight;
    @BindView(R.id.acBt_left)
    AppCompatButton acBtLeft;
    @BindView(R.id.acBt_right_no)
    AppCompatButton acBtRightNo;
    String num;
    String values;
    private Button bt_toSenconActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_main_bytetest);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void initView() {
        super.initView();
        bt_toSenconActivity = (Button) findViewById(R.id.bt_secondprocess);
        num = etInputNum.getText().toString();
        values = etInputMove.getText().toString();

    }

    @Override
    protected void initListener() {
        super.initListener();
        bt_toSenconActivity.setOnClickListener(this);
        acBtLeft.setOnClickListener(this);
        acBtRight.setOnClickListener(this);
        acBtRightNo.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_secondprocess:
                Intent intent = new Intent(this, ActivitySecond.class);
                startActivity(intent);
                break;
            //
            case R.id.acBt_left:

                break;
            case R.id.acBt_right:

                break;
            case R.id.acBt_right_no:

                break;
        }
    }
}
