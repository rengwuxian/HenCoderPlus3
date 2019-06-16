package com.hencoder.a30_arch.mvc;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.hencoder.a30_arch.R;
import com.hencoder.a30_arch.data.DataCenter;

public class MvcActivity extends AppCompatActivity {
    IView dataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);

        dataView = findViewById(R.id.dataView);

        String[] data = DataCenter.getData();
        dataView.showData(data[0], data[1]);
    }

    interface IView {
        void showData(String datum0, String datum1);
    }

}
