package com.fongmi.android.tv;

import android.app.Application;

import com.github.catvod.Init;
import com.google.gson.Gson;

public class App extends Application {
    private static volatile App instance;
    private final Gson gson;

    public App() {
        instance = this;
        gson = new Gson();
    }

    public static App get() {
        return instance;
    }

    public static Gson gson() {
        return get().gson;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Init.set(this);
    }
}