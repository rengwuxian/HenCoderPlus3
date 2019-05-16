package com.example.motionlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionScene
import com.google.android.material.appbar.AppBarLayout

class WithCoordinator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_coordinator)

        val motionLayout = findViewById<MotionLayout>(R.id.motion_layout)
        findViewById<AppBarLayout>(R.id.app_bar).addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            motionLayout.progress = -verticalOffset / appBarLayout.totalScrollRange.toFloat()

        })
    }
}
