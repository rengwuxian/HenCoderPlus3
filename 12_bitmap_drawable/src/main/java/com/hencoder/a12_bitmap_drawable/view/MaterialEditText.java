package com.hencoder.a12_bitmap_drawable.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.hencoder.a12_bitmap_drawable.R;
import com.hencoder.a12_bitmap_drawable.Utils;

import androidx.appcompat.widget.AppCompatEditText;

public class MaterialEditText extends AppCompatEditText {
    private static final float TEXT_SIZE = Utils.dp2px(12);
    private static final float TEXT_MARGIN = Utils.dp2px(8);
    private static final float VERTICAL_OFFSET = Utils.dp2px(38);
    private static final float HORIZONTAL_OFFSET = Utils.dp2px(5);
    private static final float VERTICAL_OFFSET_EXTRA = Utils.dp2px(16);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private boolean floatingLabelShown;
    private float floatingLabelFraction;
    private boolean useFloatingLabel = true;
    ObjectAnimator animator;
    Rect backgroundPaddings = new Rect();

    public MaterialEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaterialEditText);
        useFloatingLabel = typedArray.getBoolean(R.styleable.MaterialEditText_useFloatingLabel, true);
        typedArray.recycle();

        paint.setTextSize(TEXT_SIZE);

        getBackground().getPadding(backgroundPaddings);
        if (useFloatingLabel) {
            setPadding(backgroundPaddings.left, (int) (backgroundPaddings.top + TEXT_SIZE + TEXT_MARGIN), backgroundPaddings.right, backgroundPaddings.bottom);
        } else {
            setPadding(backgroundPaddings.left, backgroundPaddings.top, backgroundPaddings.right, backgroundPaddings.bottom);
        }

        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (floatingLabelShown && TextUtils.isEmpty(s)) {
                    floatingLabelShown = !floatingLabelShown;
                    getAnimator().reverse();
                } else if (!floatingLabelShown && !TextUtils.isEmpty(s)) {
                    floatingLabelShown = !floatingLabelShown;
                    getAnimator().start();
                }
            }
        });
    }

    private ObjectAnimator getAnimator() {
        if (animator == null) {
            animator = ObjectAnimator.ofFloat(MaterialEditText.this, "floatingLabelFraction", 0, 1);
        }
        return animator;
    }

    public float getFloatingLabelFraction() {
        return floatingLabelFraction;
    }

    public void setFloatingLabelFraction(float floatingLabelFraction) {
        this.floatingLabelFraction = floatingLabelFraction;
        invalidate();
    }

    public void setUseFloatingLabel(boolean useFloatingLabel) {
        if (this.useFloatingLabel != useFloatingLabel) {
            this.useFloatingLabel = useFloatingLabel;
            getBackground().getPadding(backgroundPaddings);
            if (useFloatingLabel) {
                setPadding(backgroundPaddings.left, (int) (backgroundPaddings.top + TEXT_SIZE + TEXT_MARGIN), backgroundPaddings.right, backgroundPaddings.bottom);
            } else {
                setPadding(backgroundPaddings.left, backgroundPaddings.top, backgroundPaddings.right, backgroundPaddings.bottom);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setAlpha((int) (floatingLabelFraction * 0xff));
        canvas.drawText(getHint().toString(), HORIZONTAL_OFFSET,
                VERTICAL_OFFSET - floatingLabelFraction * VERTICAL_OFFSET_EXTRA, paint);
    }
}
