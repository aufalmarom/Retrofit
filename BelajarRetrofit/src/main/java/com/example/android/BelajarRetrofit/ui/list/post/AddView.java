package com.example.android.BelajarRetrofit.ui.list.post;

import com.example.android.BelajarRetrofit.data.model.Car;

/**
 * Created by android on 1/3/2018.
 */

public interface AddView {
    String getYear();

    String getMake();

    String getModel();

    void showErrorSaveCar(String message);

    void showSuccessSaveCar(Car carResponse);
}
