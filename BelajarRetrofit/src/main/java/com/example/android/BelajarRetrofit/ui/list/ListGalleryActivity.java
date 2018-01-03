package com.example.android.BelajarRetrofit.ui.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.BelajarRetrofit.R;
import com.example.android.BelajarRetrofit.data.model.Car;

import java.util.List;

public class ListGalleryActivity extends AppCompatActivity implements ListGalleryView {
    private RecyclerView rvListGallery;
    private GalleryAdapter adapter;
    private ListGalleryPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_gallery);

        rvListGallery = findViewById(R.id.rv_list_gallery);
        initView();
    }
    private void initView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adapter = new GalleryAdapter(this);
        rvListGallery.setAdapter(adapter);
        rvListGallery.setLayoutManager(linearLayoutManager);

        presenter = new ListGalleryPresenter(this);
        presenter.showListGallery();


        }

    @Override
    public void showData(List<Car> car) {adapter.setData(car);
    }

    @Override
    public void onFailure(String errorMessage) {

    }
}
