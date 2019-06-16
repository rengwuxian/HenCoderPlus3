package com.hencoder.a30_arch.mvvm;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.hencoder.a30_arch.R;

public class MvvmActivity extends AppCompatActivity {
    EditText data1View;
    EditText data2View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data1View = findViewById(R.id.data1View);
        data2View = findViewById(R.id.data2View);

        new ViewModel(new ViewBinder(), data1View, data2View).load();
    }
}
