package com.hencoder.a10_text_and_transformation.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.a10_text_and_transformation.Utils;

import androidx.annotation.Nullable;

public class ImageTextView extends View {
    private static final int IMAGE_WIDTH = (int) Utils.dp2px(150);
    private static final int IMAGE_PADDING = (int) Utils.dp2px(80);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    TextPaint textPaint = new TextPaint();
    String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean justo sem, sollicitudin in maximus a, vulputate id magna. Nulla non quam a massa sollicitudin commodo fermentum et est. Suspendisse potenti. Praesent dolor dui, dignissim quis tellus tincidunt, porttitor vulputate nisl. Aenean tempus lobortis finibus. Quisque nec nisl laoreet, placerat metus sit amet, consectetur est. Donec nec quam tortor. Aenean aliquet dui in enim venenatis, sed luctus ipsum maximus. Nam feugiat nisi rhoncus lacus facilisis pellentesque nec vitae lorem. Donec et risus eu ligula dapibus lobortis vel vulputate turpis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In porttitor, risus aliquam rutrum finibus, ex mi ultricies arcu, quis ornare lectus tortor nec metus. Donec ultricies metus at magna cursus congue. Nam eu sem eget enim pretium venenatis. Duis nibh ligula, lacinia ac nisi vestibulum, vulputate lacinia tortor.";
    Bitmap image;
    Paint.FontMetrics metrics = new Paint.FontMetrics();
    float[] measuredWidth = new float[1];

    public ImageTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        textPaint.setTextSize(Utils.dp2px(15));
        paint.setTextSize(Utils.dp2px(16));
        paint.getFontMetrics(metrics);
        image = Utils.getAvatar(getResources(), IMAGE_WIDTH);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(image, getWidth() - IMAGE_WIDTH, IMAGE_PADDING, paint);

        int length = text.length();
        float yOffset = paint.getFontSpacing();
        int usableWidth;
        for (int start = 0, count; start < length; start += count, yOffset += paint.getFontSpacing()) {
            float textTop = yOffset + metrics.ascent;
            float textBottom = yOffset + metrics.descent;
            if (textTop > IMAGE_PADDING && textTop < IMAGE_PADDING + IMAGE_WIDTH ||
                    textBottom > IMAGE_PADDING && textBottom < IMAGE_PADDING + IMAGE_WIDTH) {
                usableWidth = getWidth() - IMAGE_WIDTH;
            } else {
                usableWidth = getWidth();
            }
            count = paint.breakText(text, start, length, true, usableWidth, measuredWidth);
            canvas.drawText(text, start, start + count, 0, yOffset, paint);
        }
    }
}
