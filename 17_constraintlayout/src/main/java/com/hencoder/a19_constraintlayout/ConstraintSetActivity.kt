package com.hencoder.a19_constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class ConstraintSetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_start)
    }


    fun onClick(view: View) {
        val constraintLayout = view as ConstraintLayout
        TransitionManager.beginDelayedTransition(constraintLayout)

        val constraintSet = ConstraintSet().apply {
            clone(this@ConstraintSetActivity, R.layout.activity_constraint_end)
        }
        constraintSet.applyTo(constraintLayout)
    }
}
