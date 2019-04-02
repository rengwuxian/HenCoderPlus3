package com.example.core;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;

public class BaseApplication extends Application {

    private static Context currentApplication;

    @NonNull
    public static Context currentApplication() {
        return currentApplication;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        currentApplication = this;
    }
}