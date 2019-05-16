package com.hencoder.a19_constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.Placeholder

class PlaceHolder : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_holder)
    }

    fun onClick(view: View) {

        TransitionManager.beginDelayedTransition(view.parent as ViewGroup)

        findViewById<Placeholder>(R.id.placeholder).setContentId(view.id)
    }
}
