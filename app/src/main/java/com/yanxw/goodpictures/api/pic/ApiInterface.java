package com.yanxw.goodpictures.api.pic;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yanxinwei on 16/7/22.
 */
public interface ApiInterface {

    OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
    CallAdapter.Factory rxJavaAdapterFactory = RxJavaCallAdapterFactory.create();
    Converter.Factory gsonConvertFactory = GsonConverterFactory.create();

    Retrofit.Builder builder = new Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(rxJavaAdapterFactory)
            .addConverterFactory(gsonConvertFactory);

}
