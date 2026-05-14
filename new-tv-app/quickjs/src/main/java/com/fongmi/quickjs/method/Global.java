package com.fongmi.quickjs.method;

import com.fongmi.quickjs.bean.Req;
import com.fongmi.quickjs.bean.Res;
import com.fongmi.quickjs.utils.Connect;
import com.fongmi.quickjs.utils.Crypto;
import com.fongmi.quickjs.utils.JSUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Global {
    private static final Gson gson = new Gson();

    public static String http(String json) throws Exception {
        Req req = gson.fromJson(json, Req.class);
        Res res = Connect.fetch(req);
        return gson.toJson(res);
    }

    public static String btoa(String s) {
        return JSUtil.btoa(s);
    }

    public static String atob(String s) {
        return JSUtil.atob(s);
    }

    public static String encodeURIComponent(String s) {
        return JSUtil.encodeURIComponent(s);
    }

    public static String decodeURIComponent(String s) {
        return JSUtil.decodeURIComponent(s);
    }

    public static String aesEncrypt(String data, String key, String iv) throws Exception {
        return Crypto.aesEncrypt(data, key, iv);
    }

    public static String aesDecrypt(String data, String key, String iv) throws Exception {
        return Crypto.aesDecrypt(data, key, iv);
    }

    public static void log(String message) {
        Console.log(message);
    }
}