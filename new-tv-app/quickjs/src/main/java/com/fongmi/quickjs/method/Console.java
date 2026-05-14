package com.fongmi.quickjs.method;

import android.util.Log;

public class Console {
    private static final String TAG = "QuickJS";

    public static void log(String message) {
        Log.d(TAG, message);
    }

    public static void info(String message) {
        Log.i(TAG, message);
    }

    public static void warn(String message) {
        Log.w(TAG, message);
    }

    public static void error(String message) {
        Log.e(TAG, message);
    }
}