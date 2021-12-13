package com.lvlin.lib_network.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCreateUtil {

    private static final int TIMEOUT_READ = 60;
    private static final int TIMEOUT_CONNECTION = 60;

    private static RetrofitCreateUtil instance;

    public static RetrofitCreateUtil getInstance() {
        if (instance == null) {
            synchronized (RetrofitCreateUtil.class) {
                instance = new RetrofitCreateUtil();
            }
        }
        return instance;
    }

    public RetrofitCreateUtil() {
    }

    public <T> T create(String baseURL, Class<T> service) {
        return initRetrofit(baseURL, initOkHttp()).create(service);
    }

    /**
     * 初始化Retrofit
     **/
    private Retrofit initRetrofit(String baseURL, OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 初始化okhttp
     **/

    private OkHttpClient initOkHttp() {
        return new OkHttpClient().newBuilder()
                .readTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }
}
