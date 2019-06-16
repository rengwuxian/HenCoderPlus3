package com.hencoder.a30_arch.mvc;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.hencoder.a30_arch.R;

public class DataView extends LinearLayout implements MvcActivity.IView {
    EditText data1View;
    EditText data2View;

    public DataView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        data1View = findViewById(R.id.data1View);
        data2View = findViewById(R.id.data2View);
    }

    @Override
    public void showData(String datum0, String datum1) {
        data1View.setText(datum0);
        data2View.setText(datum1);
    }
}
