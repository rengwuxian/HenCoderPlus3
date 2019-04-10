package com.hencoder.a09_drawing.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.a09_drawing.Utils;

import androidx.annotation.Nullable;

public class DashBoard extends View {
    private static final float RADIUS = Utils.dp2px(150);
    private static final float ANGLE = 120;
    private static final float LENGTH = Utils.dp2px(100);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path dash = new Path();
    PathDashPathEffect pathEffect;
    Path path;
    PathMeasure pathMeasure;

    public DashBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.dp2px(3));
        dash.addRect(0, 0, Utils.dp2px(2), Utils.dp2px(10), Path.Direction.CCW);
        path = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        path.addArc(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS,
                getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS,
                90 + ANGLE / 2, 360 - ANGLE);
        pathMeasure = new PathMeasure(path, false);
        pathEffect = new PathDashPathEffect(dash, (pathMeasure.getLength() - Utils.dp2px(2)) / 20, 0, PathDashPathEffect.Style.ROTATE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 画原图形
        canvas.drawArc(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS,
                getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS,
                90 + ANGLE / 2, 360 - ANGLE, false, paint);

        // 画刻度
        paint.setPathEffect(pathEffect);
        canvas.drawArc(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS,
                getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS,
                90 + ANGLE / 2, 360 - ANGLE, false, paint);
        paint.setPathEffect(null);

        // 画指针
        canvas.drawLine(getWidth() / 2, getHeight() / 2,
                getWidth() / 2 + (float) Math.cos(Math.toRadians(getAngleForMark(5))) * LENGTH,
                getHeight() / 2 + (float) Math.sin(Math.toRadians(getAngleForMark(5))) * LENGTH,
                paint);
    }

    float getAngleForMark(int mark) {
        return 90 + ANGLE / 2 + (360 - ANGLE) / 20 * mark;
    }
}
