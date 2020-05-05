package com.softsquared.mangoplate_snow.config;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.softsquared.mangoplate_snow.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.mangoplate_snow.src.ApplicationClass.sSharedPreferences;

public class XAccessTokenInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
        //final String jwtToken = sSharedPreferences.getString(X_ACCESS_TOKEN, null);
        //if(jwtToken != null){
            builder.addHeader("x-access-token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYXRlIjoiMjAyMC0wNS0wNSAxOTowNDo0OCIsImVtYWlsIjoidGVzdEBuYXZlci5jb20iLCJwdyI6InRlc3QxMjMifQ.nXRHwYUjloRplDrvlSycfYuVEr3bEMmArOlMb9fZY3Y");
        //}
        return chain.proceed(builder.build());
    }
}
