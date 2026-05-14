package com.fongmi.quickjs.utils;

import android.util.Base64;

import java.nio.charset.StandardCharsets;

public class JSUtil {
    public static String btoa(String s) {
        return Base64.encodeToString(s.getBytes(StandardCharsets.UTF_8), Base64.DEFAULT).trim();
    }

    public static String atob(String s) {
        return new String(Base64.decode(s, Base64.DEFAULT), StandardCharsets.UTF_8);
    }

    public static String encodeURIComponent(String s) {
        try {
            return java.net.URLEncoder.encode(s, StandardCharsets.UTF_8.name())
                    .replace("+", "%20")
                    .replace("%21", "!")
                    .replace("%27", "'")
                    .replace("%28", "(")
                    .replace("%29", ")")
                    .replace("%7E", "~");
        } catch (Exception e) {
            return s;
        }
    }

    public static String decodeURIComponent(String s) {
        try {
            return java.net.URLDecoder.decode(s, StandardCharsets.UTF_8.name());
        } catch (Exception e) {
            return s;
        }
    }
}