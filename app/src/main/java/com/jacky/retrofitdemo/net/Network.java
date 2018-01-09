package com.jacky.retrofitdemo.net;


import com.jacky.retrofitdemo.utils.ConstantsConfig;

import java.util.logging.Level;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: Jacky
 * Time：2018/1/8
 * ClassName：Network
 * Description：网络请求，实现对Retrofit的封装
 */

public class Network {
    private static Network instance;
    private Retrofit retrofit;

    static {
        instance = new Network();
    }

    private Network() {
    }

    /**
     * 构建一个Retrofit
     *
     * @param baseUrl 基础Url
     * @return Retrofit
     */
    private static Retrofit getRetrofit(String baseUrl) {
        if (instance.retrofit != null)
            return instance.retrofit;
        //自定义OkHttp拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(ConstantsConfig.interceptorTag);
        interceptor.setColorLevel(Level.INFO);//以Info日志输出
        if (ConstantsConfig.isPrintOkHttpLog) {//所有数据全部打印
            interceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        } else {//不打印log
            interceptor.setPrintLevel(HttpLoggingInterceptor.Level.NONE);
        }
        //得到一个OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                // 给所有的请求添加一个拦截器
                .addInterceptor(interceptor)
                .build();

        Retrofit.Builder builder = new Retrofit.Builder();
        instance.retrofit = builder.baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return instance.retrofit;

    }

    /**
     * 返回一个请求代理
     *
     * @param baseUrl 基础Url
     * @return ApiService
     */
    public static ApiService agent(String baseUrl) {
        return Network.getRetrofit(baseUrl).create(ApiService.class);
    }
}
