package com.hencoder.a09_drawing.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.a09_drawing.Utils;

import androidx.annotation.Nullable;

public class PieChart extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private static final float RADIUS = Utils.dp2px(150);
    private static final float PULLED_LENGTH = Utils.dp2px(20);
    RectF bounds = new RectF();
    int[] COLORS = {Color.parseColor("#448AFF"),
            Color.parseColor("#D81B60"),
            Color.parseColor("#43A047"),
            Color.parseColor("#FDD835")};
    int[] ANGLES = {60, 100, 120, 80};
    private static final int PULLED_INDEX = 1;

    public PieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        bounds.set(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS,
                getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int currentAngle = 0;
        for (int i = 0; i < COLORS.length; i++) {
            paint.setColor(COLORS[i]);
            if (i == PULLED_INDEX) {
                canvas.save();
                canvas.translate((float) Math.cos(Math.toRadians(currentAngle + ANGLES[i] / 2)) * PULLED_LENGTH,
                        (float) Math.sin(Math.toRadians(currentAngle + ANGLES[i] / 2)) * PULLED_LENGTH);
            }
            canvas.drawArc(bounds, currentAngle, ANGLES[i], true, paint);
            if (i == PULLED_INDEX) {
                canvas.restore();
            }
            currentAngle += ANGLES[i];
        }
    }
}
