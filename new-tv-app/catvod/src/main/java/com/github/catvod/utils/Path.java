package com.github.catvod.utils;

import android.os.Environment;

import com.github.catvod.Init;

import java.io.File;

public class Path {
    public static File getCacheDir() {
        return Init.get().getCacheDir();
    }

    public static File getFilesDir() {
        return Init.get().getFilesDir();
    }

    public static File getDownloadDir() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    }

    public static File getDocumentDir() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
    }
}