package com.hencoder.a13_layout;

import android.content.res.Resources;
import android.util.TypedValue;

public class Utils {
    public static float dpToPixel(float dp) {
        return  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                Resources.getSystem().getDisplayMetrics());
    }
}
