package com.fongmi.android.tv.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.fongmi.android.tv.bean.History;
import com.fongmi.android.tv.bean.Keep;
import com.fongmi.android.tv.bean.Site;
import com.fongmi.android.tv.bean.Vod;

@Database(entities = {Site.class, Vod.class, History.class, Keep.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
}