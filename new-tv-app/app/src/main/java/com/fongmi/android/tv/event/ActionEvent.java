package com.fongmi.android.tv.event;

public class ActionEvent {
    private final int action;

    public ActionEvent(int action) {
        this.action = action;
    }

    public int getAction() {
        return action;
    }

    public static final int PLAY = 1;
    public static final int PAUSE = 2;
    public static final int STOP = 3;
}