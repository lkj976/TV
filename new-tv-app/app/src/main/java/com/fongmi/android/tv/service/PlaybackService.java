package com.fongmi.android.tv.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.SessionCommand;
import androidx.media3.session.SessionResult;

public class PlaybackService extends MediaLibraryService {
    private ExoPlayer player;
    private static final String CHANNEL_ID = "playback_channel";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
        player = new ExoPlayer.Builder(this).build();
    }

    @Override
    public void onDestroy() {
        player.release();
        super.onDestroy();
    }

    @NonNull
    @Override
    public MediaLibraryService.MediaLibrarySession onGetSession(@NonNull MediaLibraryService.MediaLibrarySession.SessionActivityResult sessionActivityResult) {
        return new MediaLibraryService.MediaLibrarySession.Builder(this, player, new MediaLibraryService.MediaLibrarySession.Callback() {})
                .setSessionActivity(sessionActivityResult.getActivity())
                .build();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Playback", NotificationManager.IMPORTANCE_LOW);
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
        }
    }
}