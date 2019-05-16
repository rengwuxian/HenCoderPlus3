package com.hencoder.a19_constraintlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.content.pm.PackageInfo
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayout = findViewById<LinearLayout>(R.id.root)

        packageManager.getPackageInfo(
                packageName, PackageManager.GET_ACTIVITIES).activities.forEach { activity ->
            if (activity.name == this::class.java.name) {
                return@forEach
            }

            if (activity.name == ConstraintLayoutSample::class.java.name) {
                return@forEach
            }

            val clazz = Class.forName(activity.name)

            val button = Button(this).apply {
                isAllCaps = false
                text = clazz.simpleName
                setOnClickListener {
                    startActivity(Intent(this@MainActivity, clazz))
                }
            }
            linearLayout.addView(button)
        }
    }
}
