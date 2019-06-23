package com.hencoder.a33_annotation_processing;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hencoder.a33_lib.Binding;
import com.hencoder.a33_lib_annotations.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView) TextView textView;
    @BindView(R.id.parentLayout) ViewGroup parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Binding.bind(this);

        textView.setText("HenCoder Plus");
        parentLayout.setBackgroundColor(Color.CYAN);
    }
}
