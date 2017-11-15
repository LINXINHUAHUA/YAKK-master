package com.example.bs535.yakk.auxiliary;

import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by baolei on 2017/10/2.
 */

public class HttpUtil {

    public static void sendOkhttpRequest(String address, Callback callback) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url(address)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    public static void postOkhttpRequest(String address, RequestBody body, Callback callback) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }

}
