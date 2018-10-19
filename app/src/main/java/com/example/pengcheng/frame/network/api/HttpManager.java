package com.example.pengcheng.frame.network.api;

import com.example.pengcheng.frame.conf.Property;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {

    private Retrofit mRetrofit;
    private static OkHttpClient mOkHttpClient;

    public HttpManager() {
        setRetrofit(Property.APP_URL);
    }

    public HttpManager(String baseUrl){
        setRetrofit(baseUrl);
    }

    public  void setRetrofit(String appUrl){
//        if (null == mRetrofit) {
        if (null == mOkHttpClient) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .writeTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .addInterceptor(new LoggingInterceptor())
                    .build();
        }
        //Retrofit2后使用build设计模式
        mRetrofit = new Retrofit.Builder()
                //设置服务器路径
                .baseUrl(appUrl)
                //常规转化库
//                    .addConverterFactory(ScalarsConverterFactory.create())
                //添加转化库，默认是Gson
                .addConverterFactory(GsonConverterFactory.create())
                //添加回调库，采用RxJava
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                //设置使用okhttp网络请求
                .client(mOkHttpClient)
                .build();
//        }
    }

    public <T> T getMyServer(Class<T> server) {
        return mRetrofit.create(server);
    }

}
