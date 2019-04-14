package com.hencoder.a11_animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.a11_animation.Utils;

import androidx.annotation.Nullable;

public class ProvinceView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    String province = "北京市";

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        invalidate();
        this.province = province;
    }

    public ProvinceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setTextSize(Utils.dpToPixel(50));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(province, getWidth() / 2, getHeight() / 2, paint);
    }
}
