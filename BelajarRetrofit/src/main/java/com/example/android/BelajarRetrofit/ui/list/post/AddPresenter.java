package com.example.android.BelajarRetrofit.ui.list.post;

import android.util.Log;

import com.example.android.BelajarRetrofit.data.model.Car;
import com.example.android.BelajarRetrofit.data.network.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by android on 1/3/2018.
 */

public class AddPresenter {

    private final AddView mView;

    public AddPresenter(AddView addView) { mView = addView;}

    public void saveCar(){
        String year = mView.getYear();
        String make = mView.getMake();
        String model = mView.getModel();

        RetrofitClient.getRetrofitClient()
                .getApi()
                .saveCar(year, make, model)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()){
                            JsonObject body= response.body();
                            JsonObject data = body.get("data").getAsJsonObject();
                            Car carResponse = new Gson().fromJson(data, Car.class);

                            mView.showSuccessSaveCar(carResponse);

                        }else{
                            Log.d("Data", "Error");
                            mView.showErrorSaveCar("Error");
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.d("Data", t.getMessage());
                        mView.showErrorSaveCar(t.getMessage());


                    }
                });



    }
}
