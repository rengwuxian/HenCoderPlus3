package com.hencoder.a30_arch.mvp;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.hencoder.a30_arch.R;

public class MvpActivity extends AppCompatActivity implements Presenter.IView {
    EditText data1View;
    EditText data2View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data1View = findViewById(R.id.data1View);
        data2View = findViewById(R.id.data2View);

        new Presenter(this).load();
    }

    @Override
    public void showData(String datum0, String datum1) {
        data1View.setText(datum0);
        data2View.setText(datum1);
    }
}
