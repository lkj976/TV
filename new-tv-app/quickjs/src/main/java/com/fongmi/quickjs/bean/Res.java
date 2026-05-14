package com.fongmi.quickjs.bean;

import java.util.HashMap;
import java.util.Map;

public class Res {
    private int code;
    private String body;
    private Map<String, String> headers = new HashMap<>();

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
    public Map<String, String> getHeaders() { return headers; }
    public void setHeaders(Map<String, String> headers) { this.headers = headers; }
}