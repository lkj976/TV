package com.fongmi.android.tv.utils;

import android.text.TextUtils;

import java.util.List;

public class Util {
    public static boolean isEmpty(String s) {
        return TextUtils.isEmpty(s);
    }

    public static boolean notEmpty(String s) {
        return !isEmpty(s);
    }

    public static boolean isListEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean notListEmpty(List<?> list) {
        return !isListEmpty(list);
    }

    public static String formatDuration(long millis) {
        long seconds = millis / 1000;
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        seconds = seconds % 60;
        if (hours > 0) {
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }
        return String.format("%02d:%02d", minutes, seconds);
    }
}