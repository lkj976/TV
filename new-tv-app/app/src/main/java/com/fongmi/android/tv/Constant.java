package com.fongmi.android.tv;

import java.util.concurrent.TimeUnit;

public class Constant {
    public static final long INTERVAL_SEEK = TimeUnit.SECONDS.toMillis(10);
    public static final long INTERVAL_HIDE = TimeUnit.SECONDS.toMillis(5);
    public static final long TIMEOUT_VOD = TimeUnit.SECONDS.toMillis(30);
    public static final long TIMEOUT_LIVE = TimeUnit.SECONDS.toMillis(30);
    public static final long TIMEOUT_PLAY = TimeUnit.SECONDS.toMillis(15);
    public static final long HISTORY_TIME = TimeUnit.DAYS.toMillis(60);
}