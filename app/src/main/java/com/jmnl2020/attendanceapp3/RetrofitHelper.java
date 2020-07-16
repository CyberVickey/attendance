package com.jmnl2020.attendanceapp3;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitHelper {

//    static OkHttpClient client = new OkHttpClient();

    public static Retrofit getInstance(){

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("http://projectjm.dothome.co.kr/");
        builder.addConverterFactory(ScalarsConverterFactory.create());

        Log.i("TAG", "addConverterFactory");

        return builder.build();
    }

    //Scalarsconverter

}
