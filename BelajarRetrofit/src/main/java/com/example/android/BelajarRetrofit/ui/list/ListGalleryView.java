package com.example.android.BelajarRetrofit.ui.list;

import com.example.android.BelajarRetrofit.data.model.Car;
import java.util.List;

/**
 * Created by android on 1/2/2018.
 */

public interface ListGalleryView {
    void showData(List<Car> car);

    void onFailure(String errorMessage);


}
