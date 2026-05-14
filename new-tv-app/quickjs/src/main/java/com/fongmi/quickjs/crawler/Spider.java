package com.fongmi.quickjs.crawler;

import com.github.catvod.crawler.SpiderNull;

public class Spider extends SpiderNull {
    private String script;

    public Spider(String script) {
        this.script = script;
    }

    @Override
    public String homeContent(boolean filter) {
        return exec("home", filter ? "1" : "0");
    }

    @Override
    public String categoryContent(String tid, String pg, boolean filter) {
        return exec("category", tid, pg, filter ? "1" : "0");
    }

    @Override
    public String detailContent(java.util.List<String> ids) {
        return exec("detail", String.join(",", ids));
    }

    @Override
    public String searchContent(String key, boolean quick) {
        return exec("search", key, quick ? "1" : "0");
    }

    @Override
    public String playerContent(String flag, String id, java.util.List<com.github.catvod.bean.Header> headers) {
        return exec("player", flag, id);
    }

    private String exec(String method, String... args) {
        try {
            return Loader.exec(script, method, args);
        } catch (Exception e) {
            return "{}";
        }
    }
}