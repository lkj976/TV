package com.fongmi.chaquo;

import com.github.catvod.crawler.SpiderNull;

public class Spider extends SpiderNull {
    private final String script;

    public Spider(String script) {
        this.script = script;
    }

    @Override
    public String homeContent(boolean filter) {
        return call("home", filter);
    }

    @Override
    public String categoryContent(String tid, String pg, boolean filter) {
        return call("category", tid, pg, filter);
    }

    @Override
    public String detailContent(java.util.List<String> ids) {
        return call("detail", String.join(",", ids));
    }

    @Override
    public String searchContent(String key, boolean quick) {
        return call("search", key, quick);
    }

    @Override
    public String playerContent(String flag, String id, java.util.List<com.github.catvod.bean.Header> headers) {
        return call("player", flag, id);
    }

    private String call(String method, Object... args) {
        try {
            return Runner.exec(script, method, args);
        } catch (Exception e) {
            return "{}";
        }
    }
}