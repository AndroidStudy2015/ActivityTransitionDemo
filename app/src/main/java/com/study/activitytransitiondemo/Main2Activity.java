package com.study.activitytransitiondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView mTv;
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        要使用内置的过渡动画Slide、Explode、Fade，
//        必须设置如下的话，并且必须在setContentView之前（用于单个Activity）
//        或者在style文件里设置（用于全局）
//        <item name="android:windowContentTransitions">true</item>

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

//        注意:当你点击返回键时，是不会触发这个activity的ExitTransition动画的，
//        这个ExitTransition动画是在当前的activity打开新的activity时才会出发的
//        如果点击的是返回，显示的是与进入这个activity时候相反的动画
        getWindow().setEnterTransition(new Slide(Gravity.TOP));
        getWindow().setExitTransition(new Slide(Gravity.LEFT));


        setContentView(R.layout.activity_main2);

        initView();

    }





    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        mTv = (TextView) findViewById(R.id.tv);
    }
}
