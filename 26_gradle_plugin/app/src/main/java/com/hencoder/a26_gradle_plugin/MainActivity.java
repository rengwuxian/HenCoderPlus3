package com.hencoder.a26_gradle_plugin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        long startTime = SystemClock.uptimeMillis();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        long timePassed = SystemClock.uptimeMillis() - startTime;
        if (timePassed > 500) {
            Log.d("方法执行时间", "onCreate - " + timePassed);
        }
    }
}
