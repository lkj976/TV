package com.github.catvod.net.interceptor;

import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

public class ResponseInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        return response;
    }
}