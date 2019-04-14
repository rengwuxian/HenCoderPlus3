package com.hencoder.a11_animation.view;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.a11_animation.Utils;

import androidx.annotation.Nullable;

public class FancyView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Camera camera = new Camera();

    float topFlip = 0;
    float bottomFlip = 0;
    float flipRotation = 0;

    public float getTopFlip() {
        return topFlip;
    }

    public void setTopFlip(float topFlip) {
        this.topFlip = topFlip;
        invalidate();
    }

    public float getBottomFlip() {
        return bottomFlip;
    }

    public void setBottomFlip(float bottomFlip) {
        this.bottomFlip = bottomFlip;
        invalidate();
    }

    public float getFlipRotation() {
        return flipRotation;
    }

    public void setFlipRotation(float flipRotation) {
        this.flipRotation = flipRotation;
        invalidate();
    }

    public FancyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        camera.setLocation(0, 0, Utils.getZForCamera()); // -8 = -8 * 72
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制上半部分
        canvas.save();
        canvas.translate(100 + 600 / 2, 100 + 600 / 2);
        canvas.rotate(-flipRotation);
        camera.save();
        camera.rotateX(topFlip);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.clipRect(- 600, - 600, 600, 0);
        canvas.rotate(flipRotation);
        canvas.translate(- (100 + 600 / 2), - (100 + 600 / 2));
        canvas.drawBitmap(Utils.getAvatar(getResources(), 600), 100, 100, paint);
        canvas.restore();

        // 绘制下半部分
        canvas.save();
        canvas.translate(100 + 600 / 2, 100 + 600 / 2);
        canvas.rotate(-flipRotation);
        camera.save();
        camera.rotateX(bottomFlip);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.clipRect(- 600, 0, 600, 600);
        canvas.rotate(flipRotation);
        canvas.translate(- (100 + 600 / 2), - (100 + 600 / 2));
        canvas.drawBitmap(Utils.getAvatar(getResources(), 600), 100, 100, paint);
        canvas.restore();
    }
}
