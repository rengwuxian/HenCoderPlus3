package com.hencoder.a31_pluginnable;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Class utilsClass = Class.forName("com.hencoder.a31_pluginnable.utils.Utils");
            Constructor utilsConstructor = utilsClass.getDeclaredConstructors()[0];
            utilsConstructor.setAccessible(true);
            Object utils = utilsConstructor.newInstance();
            Method shoutMethod = utilsClass.getDeclaredMethod("shout");
            shoutMethod.setAccessible(true);
            shoutMethod.invoke(utils);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        File apk = new File(getCacheDir() + "/31_pluginnable_plugin-debug.apk");
        try (Source source = Okio.source(getAssets().open("apk/31_pluginnable_plugin-debug.apk"));
             BufferedSink sink = Okio.buffer(Okio.sink(apk))){
            sink.writeAll(source);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DexClassLoader classLoader = new DexClassLoader(apk.getPath(), getCacheDir().getPath(), null, null);
        try {
            Class pluginUtilsClass = classLoader.loadClass("com.hencoder.a31_pluginnable_plugin.Utils");
            Constructor utilsConstructor = pluginUtilsClass.getDeclaredConstructors()[0];
            Object utils = utilsConstructor.newInstance();
            Method shoutMethod = pluginUtilsClass.getDeclaredMethod("shout");
            shoutMethod.invoke(utils);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent();
        intent.setClassName(this, "com.hencoder.a31_pluginnable_plugin.SecondActivity");
        startActivity(intent);
    }
}
