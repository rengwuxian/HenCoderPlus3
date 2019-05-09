package com.hencoder.a19_constraintlayout

import android.animation.ValueAnimator
import android.animation.ValueAnimator.INFINITE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.constraintlayout.widget.ConstraintLayout

class CircularPositioning : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular_positioning)

        val earth = findViewById<View>(R.id.earth)
        val moon = findViewById<View>(R.id.moon)
        val sun = findViewById<View>(R.id.sun)

        val earthAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 10000L
            repeatCount = INFINITE
            interpolator = LinearInterpolator()
        }

        val moonAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 2000L
            repeatCount = INFINITE
            interpolator = LinearInterpolator()
        }

        earthAnimator.addUpdateListener {
            val params = earth.layoutParams as ConstraintLayout.LayoutParams
            params.circleAngle = 45 + it.animatedFraction * 360
            moon.requestLayout()
        }
        moonAnimator.addUpdateListener {
            val params = moon.layoutParams as ConstraintLayout.LayoutParams
            params.circleAngle = 270 + it.animatedFraction * 360
            moon.requestLayout()
        }

        sun.setOnClickListener {
            earthAnimator.start()
            moonAnimator.start()
        }
    }
}
