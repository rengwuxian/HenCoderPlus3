package com.hencoder.a14_touch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class TouchLayout extends ViewGroup {
    float downY;

    public TouchLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        float delta = ev.getY() - downY;

        if (Math.abs(delta) < 80) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
