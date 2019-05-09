package com.hencoder.a19_constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.helper.widget.Flow.VERTICAL
import androidx.constraintlayout.helper.widget.Flow.WRAP_NONE

class FlowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)
    }
}
