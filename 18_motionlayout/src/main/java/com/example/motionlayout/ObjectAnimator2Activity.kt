package com.example.motionlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout

class ObjectAnimator2Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_animator2)

        findViewById<View>(R.id.button_2).setOnClickListener(this)
    }

    override fun onClick(v: View) {


        TransitionManager.beginDelayedTransition(v.parent as ViewGroup)

        val params = v.layoutParams as LinearLayout.LayoutParams
        params.height *= 2
        params.width *= 2
        v.layoutParams = params

        /**
         * 过渡动画的大致流程
         * 1. 两个场景，一个「开始场景」一个「结束场景」，记录场景上的控件的各种参数
         * 2. 有了参数，创建出动画对象
         * 3. 播放动画
         */
    }
}
