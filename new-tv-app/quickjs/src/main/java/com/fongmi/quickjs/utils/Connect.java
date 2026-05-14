package com.fongmi.quickjs.utils;

import com.fongmi.quickjs.bean.Req;
import com.fongmi.quickjs.bean.Res;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.concurrent.TimeUnit;

public class Connect {
    public static Res fetch(Req req) throws Exception {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(req.getTimeout(), TimeUnit.SECONDS)
                .readTimeout(req.getTimeout(), TimeUnit.SECONDS)
                .writeTimeout(req.getTimeout(), TimeUnit.SECONDS)
                .build();

        Request.Builder builder = new Request.Builder().url(req.getUrl());
        for (String key : req.getHeaders().keySet()) {
            builder.addHeader(key, req.getHeaders().get(key));
        }

        if ("POST".equalsIgnoreCase(req.getMethod())) {
            builder.post(RequestBody.create(req.getBody(), null));
        }

        Response response = client.newCall(builder.build()).execute();
        Res res = new Res();
        res.setCode(response.code());
        res.setBody(response.body() != null ? response.body().string() : "");
        response.headers().names().forEach(name -> res.getHeaders().put(name, response.header(name)));
        return res;
    }
}