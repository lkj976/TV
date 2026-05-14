package com.fongmi.quickjs.bean;

import java.util.HashMap;
import java.util.Map;

public class Req {
    private String url;
    private String method = "GET";
    private Map<String, String> headers = new HashMap<>();
    private String body;
    private String proxy;
    private int timeout = 30;

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
    public Map<String, String> getHeaders() { return headers; }
    public void setHeaders(Map<String, String> headers) { this.headers = headers; }
    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
    public String getProxy() { return proxy; }
    public void setProxy(String proxy) { this.proxy = proxy; }
    public int getTimeout() { return timeout; }
    public void setTimeout(int timeout) { this.timeout = timeout; }
}