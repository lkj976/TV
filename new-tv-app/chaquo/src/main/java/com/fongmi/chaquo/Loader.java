package com.fongmi.chaquo;

import android.content.Context;

import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class Loader {
    private static boolean initialized = false;

    public static synchronized void init(Context context) {
        if (!initialized) {
            if (!Python.isStarted()) {
                Python.start(new AndroidPlatform(context));
            }
            initialized = true;
        }
    }

    public static Python getPython() {
        return Python.getInstance();
    }
}