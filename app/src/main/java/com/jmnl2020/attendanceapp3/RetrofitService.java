package com.jmnl2020.attendanceapp3;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface RetrofitService {

    //데이터와 파일을 동시에 전송
    @Multipart
    @POST("/Retrofit/insertDB.php")
    Call<String> postData(@PartMap Map<String, String> datapart,
                                 @Part MultipartBody.Part filepart);

    // 서버에서 데이터 json을 읽어와서 GSON라이브러리를 통해 곧바로 자바 객체로 응답결과를 주는 추상메소드

    @GET("/Retrofit/load.php")
    Call<ArrayList<StudentDTO>> loadData();

    //

}
