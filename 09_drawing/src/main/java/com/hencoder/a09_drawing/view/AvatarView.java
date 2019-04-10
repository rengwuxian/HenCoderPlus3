package com.hencoder.a09_drawing.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.a09_drawing.R;
import com.hencoder.a09_drawing.Utils;

import androidx.annotation.Nullable;

public class AvatarView extends View {
    private static final float WIDTH = Utils.dp2px(300);
    private static final float PADDING = Utils.dp2px(40);
    private static final float BORDER_WIDTH = Utils.dp2px(10);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap avatar;
    Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    RectF cut = new RectF();
    RectF border = new RectF();

    public AvatarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        avatar = getAvatar((int) WIDTH);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        cut.set(PADDING, PADDING, PADDING + WIDTH, PADDING + WIDTH);
        border.set(PADDING - BORDER_WIDTH, PADDING - BORDER_WIDTH, PADDING + WIDTH + BORDER_WIDTH, PADDING + WIDTH + BORDER_WIDTH);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawOval(border, paint);
        int saved = canvas.saveLayer(cut, paint);
        canvas.drawOval(cut, paint);
        paint.setXfermode(xfermode);
        canvas.drawBitmap(avatar, PADDING, PADDING, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(saved);
    }

    Bitmap getAvatar(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.avatar_rengwuxian, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(getResources(), R.drawable.avatar_rengwuxian, options);
    }
}
