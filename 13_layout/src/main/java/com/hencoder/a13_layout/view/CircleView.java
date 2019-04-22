package com.hencoder.a13_layout.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.a13_layout.Utils;

import androidx.annotation.Nullable;

public class CircleView extends View {
    private static final float PADDING = Utils.dpToPixel(20);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    float radius = Utils.dpToPixel(80);

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = (int) ((PADDING + radius) * 2);

        int measuredWidth = resolveSize(size, widthMeasureSpec);
        int measuredHeight = resolveSize(size, heightMeasureSpec);

        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.RED);
        canvas.drawCircle(PADDING + radius, PADDING + radius, radius, paint);
    }
}
