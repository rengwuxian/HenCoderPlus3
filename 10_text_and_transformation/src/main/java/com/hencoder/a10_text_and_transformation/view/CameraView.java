package com.hencoder.a10_text_and_transformation.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.a10_text_and_transformation.Utils;

import androidx.annotation.Nullable;

public class CameraView extends View {
    private static final int IMAGE_WIDTH = (int) Utils.dp2px(200);
    private static final int IMAGE_PADDING = (int) Utils.dp2px(100);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap image;
    Camera camera = new Camera();

    public CameraView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        image = Utils.getAvatar(getResources(), IMAGE_WIDTH);
        camera.rotateX(45);
        camera.setLocation(0 , 0, Utils.getZForCamera()); // -8 * 72
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.translate(IMAGE_PADDING + IMAGE_WIDTH / 2, IMAGE_PADDING + IMAGE_WIDTH / 2);
        canvas.rotate(-30);
        canvas.clipRect(- IMAGE_WIDTH, - IMAGE_WIDTH, IMAGE_WIDTH, 0);
        canvas.rotate(30);
        canvas.translate(- (IMAGE_PADDING + IMAGE_WIDTH / 2), - (IMAGE_PADDING + IMAGE_WIDTH / 2));
        canvas.drawBitmap(image, IMAGE_PADDING, IMAGE_PADDING, paint);
        canvas.restore();


        canvas.save();
        canvas.translate(IMAGE_PADDING + IMAGE_WIDTH / 2, IMAGE_PADDING + IMAGE_WIDTH / 2);
        canvas.rotate(-30);
        camera.applyToCanvas(canvas);
        canvas.clipRect(- IMAGE_WIDTH, 0, IMAGE_WIDTH, IMAGE_WIDTH);
        canvas.rotate(30);
        canvas.translate(- (IMAGE_PADDING + IMAGE_WIDTH / 2), - (IMAGE_PADDING + IMAGE_WIDTH / 2));
        canvas.drawBitmap(image, IMAGE_PADDING, IMAGE_PADDING, paint);
        canvas.restore();
    }
}
