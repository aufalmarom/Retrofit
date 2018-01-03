package com.example.android.BelajarRetrofit.data.model;

/**
 * Created by android on 1/2/2018.
 */

public class Car {
    private int id;
    private String year;
    private String make;
    private String model;
    private String imgeUrl = "https://images.toyota-europe.com/gb/c-hr/width/1200/exterior-3.jpg";

    public int getId() {
        return id;
    }

     public String getYear() { return year; }

    public String getMake() { return make; }

    public String getModel() { return model; }

    public String getImgeUrl() { return imgeUrl; }

  }
