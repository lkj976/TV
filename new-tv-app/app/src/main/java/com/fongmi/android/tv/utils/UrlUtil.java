package com.fongmi.android.tv.utils;

import android.net.Uri;

import java.util.Set;

public class UrlUtil {
    public static boolean isHttpUrl(String url) {
        return url != null && (url.startsWith("http://") || url.startsWith("https://"));
    }

    public static String getHost(String url) {
        try {
            return Uri.parse(url).getHost();
        } catch (Exception e) {
            return "";
        }
    }

    public static String getParam(String url, String key) {
        try {
            return Uri.parse(url).getQueryParameter(key);
        } catch (Exception e) {
            return "";
        }
    }

    public static String addParam(String url, String key, String value) {
        try {
            Uri uri = Uri.parse(url);
            Uri.Builder builder = uri.buildUpon();
            builder.appendQueryParameter(key, value);
            return builder.build().toString();
        } catch (Exception e) {
            return url;
        }
    }
}