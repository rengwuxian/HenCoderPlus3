package com.hencoder.a09_drawing;

import android.content.res.Resources;
import android.util.TypedValue;

public class Utils {
    public static float dp2px(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}
