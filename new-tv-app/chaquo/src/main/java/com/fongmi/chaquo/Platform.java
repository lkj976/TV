package com.fongmi.chaquo;

import android.content.Context;

public class Platform {
    private static Context context;

    public static void setContext(Context context) {
        Platform.context = context;
    }

    public static Context getContext() {
        return context;
    }
}