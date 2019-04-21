package com.hencoder.a12_bitmap_drawable;

import android.os.Bundle;

import com.hencoder.a12_bitmap_drawable.view.MaterialEditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    MaterialEditText materialEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        materialEditText = findViewById(R.id.editText);
//        materialEditText.setUseFloatingLabel(false);
    }
}
