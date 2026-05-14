package com.github.catvod.crawler;

public class SpiderNull extends Spider {
    @Override
    public String homeContent(boolean filter) {
        return "[]";
    }

    @Override
    public String categoryContent(String tid, String pg, boolean filter) {
        return "[]";
    }

    @Override
    public String detailContent(java.util.List<String> ids) {
        return "[]";
    }

    @Override
    public String searchContent(String key, boolean quick) {
        return "[]";
    }

    @Override
    public String playerContent(String flag, String id, java.util.List<com.github.catvod.bean.Header> headers) {
        return "{}";
    }
}