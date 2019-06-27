package com.hencoder.a30_arch;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.hencoder.a30_arch.data.DataCenter;

public class MainActivity extends AppCompatActivity {
    EditText data1View;
    EditText data2View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data1View = findViewById(R.id.data1View);
        data2View = findViewById(R.id.data2View);

        String[] data = DataCenter.getData();
        data1View.setText(data[0]);
        data2View.setText(data[1]);
    }
}