package com.study.activitytransitiondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        mIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivityWithCustomAnimation();
//                startActivityWithSceneTransitionAnimationForFadeOrSlideOrExplore();
//                startActivityWithSceneTransitionAnimationForOneShareElement();
                startActivityWithSceneTransitionAnimationForShareElements();
            }
        });
    }

    /**
     * 使用1个共享元素开启过渡动画效果
     * 第一步、在要共享的View里面添加（两个activity的元素得要添加哦！）
     *   android:transitionName="xxx"
     * 第二步、调用下面的方法，注意“xxx”要一致
     */
    private void startActivityWithSceneTransitionAnimationForShareElements() {
        ActivityOptionsCompat compat = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this,
                        Pair.create((View)mIv,"img"),
                        Pair.create((View)mIv,"text"));
        Intent intent = new Intent(this, Main2Activity.class);
        ActivityCompat.startActivity(this, intent, compat.toBundle());
    }
    /**
     * 使用1个共享元素开启过渡动画效果
     * 第一步、在要共享的View里面添加（两个activity的元素得要添加哦！）
     *   android:transitionName="xxx"
     * 第二步、调用下面的方法，注意“xxx”要一致
    */
    private void startActivityWithSceneTransitionAnimationForOneShareElement() {
        ActivityOptionsCompat compat = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this,mIv,"img");
        Intent intent = new Intent(this, Main2Activity.class);
        ActivityCompat.startActivity(this, intent, compat.toBundle());
    }
    /**
     * 使用内置的过渡动画方式Slide、Explode、Fade
     * 只有在这里使用如下方式打开另一个Activity，
     * 另一个Activity里设置的基本的过渡动画才会生效
     * 例如：
     * getWindow().setEnterTransition(new Slide(Gravity.RIGHT));
     * getWindow().setExitTransition(new Explode());等
     */
    private void startActivityWithSceneTransitionAnimationForFadeOrSlideOrExplore() {
        ActivityOptionsCompat compat = ActivityOptionsCompat.
        makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, Main2Activity.class);
        ActivityCompat.startActivity(this, intent, compat.toBundle());
    }

    /**
     * 类似古老方式
     * makeCustomAnimation
     * 使用自定义动画效果，打开另一个Activity
     * 与旧的方式overridePendingTransition(enterAnim, exitAnim)一样
     */
    private void startActivityWithCustomAnimation() {
        ActivityOptionsCompat compat = ActivityOptionsCompat
        .makeCustomAnimation(this, R.anim.in, R.anim.out);
        Intent intent = new Intent(this, Main2Activity.class);
        ActivityCompat.startActivity(this, intent, compat.toBundle());
    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        mTv = (TextView) findViewById(R.id.tv);
    }
}
