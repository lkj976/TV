package com.github.catvod.crawler;

import com.github.catvod.bean.Header;

import java.util.List;

public abstract class Spider {
    public void init() {}
    public void destroy() {}
    public String homeContent(boolean filter) throws Exception { return ""; }
    public String categoryContent(String tid, String pg, boolean filter) throws Exception { return ""; }
    public String detailContent(List<String> ids) throws Exception { return ""; }
    public String searchContent(String key, boolean quick) throws Exception { return ""; }
    public String playerContent(String flag, String id, List<Header> headers) throws Exception { return ""; }
    public boolean isVideoFormat(String url) { return false; }
}