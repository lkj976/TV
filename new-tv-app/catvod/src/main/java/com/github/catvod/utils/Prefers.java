package com.github.catvod.utils;

import android.content.SharedPreferences;

import com.github.catvod.Init;

public class Prefers {
    private static final String NAME = "catvod";
    private static SharedPreferences get() {
        return Init.get().getSharedPreferences(NAME, 0);
    }

    public static String getString(String key, String def) {
        return get().getString(key, def);
    }

    public static void putString(String key, String value) {
        get().edit().putString(key, value).apply();
    }

    public static int getInt(String key, int def) {
        return get().getInt(key, def);
    }

    public static void putInt(String key, int value) {
        get().edit().putInt(key, value).apply();
    }

    public static boolean getBoolean(String key, boolean def) {
        return get().getBoolean(key, def);
    }

    public static void putBoolean(String key, boolean value) {
        get().edit().putBoolean(key, value).apply();
    }
}