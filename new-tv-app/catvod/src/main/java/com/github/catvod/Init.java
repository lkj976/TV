package com.github.catvod;

import android.content.Context;

public class Init {
    private static Context context;

    public static void set(Context context) {
        Init.context = context.getApplicationContext();
    }

    public static Context get() {
        return context;
    }
}