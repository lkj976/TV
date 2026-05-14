package com.fongmi.android.tv.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    public static boolean exists(File file) {
        return file != null && file.exists();
    }

    public static boolean delete(File file) {
        if (file == null) return false;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) delete(f);
            }
        }
        return file.delete();
    }

    public static String read(File file) {
        if (!exists(file)) return "";
        try (FileInputStream is = new FileInputStream(file)) {
            byte[] buffer = new byte[(int) file.length()];
            is.read(buffer);
            return new String(buffer);
        } catch (IOException e) {
            return "";
        }
    }

    public static boolean write(File file, String content) {
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try (FileOutputStream os = new FileOutputStream(file)) {
                os.write(content.getBytes());
                return true;
            }
        } catch (IOException e) {
            return false;
        }
    }
}