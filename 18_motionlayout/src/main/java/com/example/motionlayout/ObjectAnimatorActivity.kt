package com.example.motionlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import com.example.motionlayout.util.dp

class ObjectAnimatorActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var root: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_animator)
        root = findViewById(R.id.root)

        findViewById<ImageView>(R.id.heart).setOnClickListener(this)
    }

    override fun onClick(v: View) {

        TransitionManager.beginDelayedTransition(root)
        val params = v.layoutParams as FrameLayout.LayoutParams
        params.height *= 2
        params.width *= 2
        params.gravity = Gravity.CENTER
        v.layoutParams = params

    }
}
