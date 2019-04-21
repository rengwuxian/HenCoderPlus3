package com.hencoder.a12_bitmap_drawable.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.a12_bitmap_drawable.drawable.CandleDrawable;

import androidx.annotation.Nullable;

public class SmallCandleView extends View {
    CandleDrawable candleDrawable;

    public SmallCandleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        candleDrawable.draw(canvas);
        
        // ...
    }
}
