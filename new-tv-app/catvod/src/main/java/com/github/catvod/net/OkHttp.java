package com.github.catvod.net;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class OkHttp {
    private static OkHttpClient client;

    public static OkHttpClient get() {
        if (client == null) {
            client = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .followRedirects(true)
                    .followSslRedirects(true)
                    .build();
        }
        return client;
    }

    public static void set(OkHttpClient client) {
        OkHttp.client = client;
    }
}