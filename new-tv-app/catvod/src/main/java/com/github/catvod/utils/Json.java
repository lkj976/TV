package com.github.catvod.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;

public class Json {
    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static <T> T toObject(String json, Type type) {
        return gson.fromJson(json, type);
    }

    public static JsonElement parse(String json) {
        return JsonParser.parseString(json);
    }
}