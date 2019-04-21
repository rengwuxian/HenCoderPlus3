package com.hencoder.a12_bitmap_drawable.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.a12_bitmap_drawable.Utils;
import com.hencoder.a12_bitmap_drawable.drawable.MeshDrawable;

import androidx.annotation.Nullable;

public class DrawableView extends View {
    Drawable drawable;

    public DrawableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        drawable = new MeshDrawable();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawable.setBounds(0, 0, getWidth(), getHeight());
        drawable.draw(canvas);
    }
}
