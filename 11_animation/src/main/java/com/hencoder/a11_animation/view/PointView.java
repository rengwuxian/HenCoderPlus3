package com.hencoder.a11_animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.a11_animation.Utils;

import androidx.annotation.Nullable;

public class PointView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    PointF point = new PointF(0, 0);

    public PointF getPoint() {
        return point;
    }

    public void setPoint(PointF point) {
        this.point = point;
        invalidate();
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setStrokeWidth(Utils.dpToPixel(20));
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPoint(point.x, point.y, paint);
    }
}
