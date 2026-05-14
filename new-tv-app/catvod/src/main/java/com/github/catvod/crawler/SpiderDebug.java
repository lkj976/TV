package com.github.catvod.crawler;

import com.github.catvod.utils.Json;

import java.util.HashMap;

public class SpiderDebug extends Spider {
    @Override
    public String homeContent(boolean filter) {
        return Json.toJson(new HashMap<>());
    }

    @Override
    public String categoryContent(String tid, String pg, boolean filter) {
        return Json.toJson(new HashMap<>());
    }

    @Override
    public String detailContent(java.util.List<String> ids) {
        return Json.toJson(new HashMap<>());
    }

    @Override
    public String searchContent(String key, boolean quick) {
        return Json.toJson(new HashMap<>());
    }

    @Override
    public String playerContent(String flag, String id, java.util.List<com.github.catvod.bean.Header> headers) {
        return Json.toJson(new HashMap<>());
    }
}