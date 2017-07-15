package com.rxandroid.elice.skeletonpj.module;

import com.rxandroid.elice.skeletonpj.repository.ImageRepository;
import com.rxandroid.elice.skeletonpj.util.constant.WoConstant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by elice.kim on 2017. 7. 15..
 */

public class RestClient {

    public ImageRepository getImageRepository(){
        return new Retrofit.Builder()
                .baseUrl(WoConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getOkHttpClient())
                .build().create(ImageRepository.class);
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(59, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor())
                .writeTimeout(59, TimeUnit.SECONDS)
                .readTimeout(59, TimeUnit.SECONDS)
                .build();
    }
}
