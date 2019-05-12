package com.example.youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class YoutubeActivity : AppCompatActivity() {

    // 过渡动画
    /**
     * View 动画 API 1
     * 属性动画  API 11
     * 过渡动画  API 18
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)
    }
}
