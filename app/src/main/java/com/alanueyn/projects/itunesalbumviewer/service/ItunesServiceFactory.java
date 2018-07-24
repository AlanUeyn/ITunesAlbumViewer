package com.alanueyn.projects.itunesalbumviewer.service;


import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The singleton class ItunesServiceFactory which creates and returns Retrofit2 service with
 * OkHTTP client
 */

public class ItunesServiceFactory {

    private static final ItunesServiceFactory ourInstance = new ItunesServiceFactory();

    static ItunesServiceFactory getInstance() {
        return ourInstance;
    }

    private ItunesServiceFactory() {}


    private static HttpLoggingInterceptor createHttpLoggingInterceptor(Boolean isDebug) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if(isDebug)
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        else
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);

        return logging;
    }

    private static OkHttpClient createOkHttpClient(HttpLoggingInterceptor interceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return builder
                .addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    private static ItunesService createItunesService(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://itunes.apple.com")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ItunesService.class);

    }

    public static ItunesService createItunesService(Boolean isDebug) {
        OkHttpClient client = createOkHttpClient(createHttpLoggingInterceptor(isDebug));
        return createItunesService(client);
    }



}
