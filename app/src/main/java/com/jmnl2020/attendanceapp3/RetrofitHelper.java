package com.jmnl2020.attendanceapp3;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    public static Retrofit getInstance(){

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("http://projectjm.dothome.co.kr/");
        builder.addConverterFactory(GsonConverterFactory.create());

        return builder.build();
    }

    //Scalarsconverter

}
