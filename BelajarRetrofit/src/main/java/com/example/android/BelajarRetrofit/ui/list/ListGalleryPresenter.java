package com.example.android.BelajarRetrofit.ui.list;

import com.example.android.BelajarRetrofit.data.model.Car;
import com.example.android.BelajarRetrofit.data.network.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListGalleryPresenter {

    private ListGalleryView listGalleryView;

    public ListGalleryPresenter(ListGalleryView listGalleryView){
        this.listGalleryView = listGalleryView;

    }

    public void showListGallery() {
        RetrofitClient.getRetrofitClient()
                .getApi()
                .getCarAll()
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {
                            JsonObject body = response.body();
                            JsonArray jsonArray = body.get("data").getAsJsonArray();

                            Type type = new TypeToken<List<Car>>() {
                            }.getType();

                            List<Car> carList = new Gson().fromJson(jsonArray, type);

                            listGalleryView.showData(carList);
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        listGalleryView.onFailure(t.getMessage());
                    }


                });


    }}
