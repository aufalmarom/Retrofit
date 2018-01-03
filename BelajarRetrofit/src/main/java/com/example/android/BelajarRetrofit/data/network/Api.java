package com.example.android.BelajarRetrofit.data.network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by android on 1/2/2018.
 */

public interface Api {
    @GET("cars")
    Call<JsonObject>getCarAll();

    @FormUrlEncoded
    @POST("cars")
    Call<JsonObject> saveCar(
            @Field("year") String year,
            @Field("make") String make,
            @Field("model") String model);
}
