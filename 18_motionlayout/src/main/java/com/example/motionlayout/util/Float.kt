package com.example.motionlayout.util

import android.content.res.Resources
import android.util.TypedValue

fun Float.dp() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)