package com.jmnl2020.attendanceapp3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

//    static OkHttpClient client = new OkHttpClient();

    public static Retrofit getInstance(){

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("http://projectjm.dothome.co.kr/");
        builder.addConverterFactory(GsonConverterFactory.create());

//        Gson gson = new GsonBuilder().setLenient().create();
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://projectjm.dothome.co.kr/")
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create(gson)).build();

        return builder.build();
    }

    //Scalarsconverter

}
