package com.example.android.BelajarRetrofit.data.network;

import com.example.android.BelajarRetrofit.util.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by android on 1/2/2018.
 */

public class RetrofitClient {
    private static RetrofitClient retrofitClient;

    private RetrofitClient(){

    }
    public static RetrofitClient getRetrofitClient(){
        if (retrofitClient == null){
            retrofitClient = new RetrofitClient();

        }
        return retrofitClient;
    }
    public Api getApi(){
        return getRetrofit().create(Api.class);

    }

    public Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
