package com.rxandroid.elice.skeletonpj.data.net;

import android.content.Context;

import com.readystatesoftware.chuck.ChuckInterceptor;
import com.rxandroid.elice.skeletonpj.data.repository.ImageRepository;

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

    private Context context;

    public RestClient(Context context) {
        this.context = context;
    }

    public ImageRepository getImageRepository(){
        return new Retrofit.Builder()
                .baseUrl(EliceConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getOkHttpClient())
                .build().create(ImageRepository.class);
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(59, TimeUnit.SECONDS)
                .addInterceptor(new ChuckInterceptor(context))
                .addInterceptor(new HttpLoggingInterceptor())
                .writeTimeout(59, TimeUnit.SECONDS)
                .readTimeout(59, TimeUnit.SECONDS)
                .build();
    }
}
