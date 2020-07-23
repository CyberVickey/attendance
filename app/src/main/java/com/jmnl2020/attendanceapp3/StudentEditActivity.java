package com.jmnl2020.attendanceapp3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentEditActivity extends AppCompatActivity {

    ToggleButton mon, tue, wed, thu, fri, sat;
    EditText etName;
    EditText etBirthday;
    EditText etContact;
    EditText etPrnt1name;
    EditText etPrnt1phone;
    EditText etPrnt2name;
    EditText etPrnt2phone;

    int day =0;
    String name = "";
    int birthday = 0;
    int contact = 0;
    String par1name = "";
    int par1phone = 0;
    String par2name = "";
    int par2phone = 0;

    //토글버튼 배열
    boolean[] check = new boolean[6];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_edit);

        Log.i("TAG", "edit Activity");

        //앱바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mon = findViewById(R.id.tb_mon);
        tue = findViewById(R.id.tb_tue);
        wed = findViewById(R.id.tb_wed);
        thu = findViewById(R.id.tb_thu);
        fri = findViewById(R.id.tb_fri);
        sat = findViewById(R.id.tb_sat);

        //mmm
        etName = findViewById(R.id.et_name);
        etBirthday = findViewById(R.id.et_birthday);
        etContact = findViewById(R.id.et_contact);
        etPrnt1name = findViewById(R.id.et_name_prnts1);
        etPrnt1phone= findViewById(R.id.et_num_prnts1);
        etPrnt2name = findViewById(R.id.et_name_prnts2);
        etPrnt2phone= findViewById(R.id.et_num_prnts2);


    }


    public void clickComplete(View view) {

        //체크체크
        String myString = "";

        Log.d("TAG", "click com");
        //서버에 데이터 전송 [day, name, birthday, contact, par1name, par1phone, par2 name, par2phone, toggle]

        name = etName.getText().toString();

        if (etBirthday.getText().toString().equals(myString)) {
            birthday = 0;
        } else birthday = Integer.parseInt(etBirthday.getText().toString());
        if (etContact.getText().toString().equals(myString)) {
            contact = 0;
        } else contact = Integer.parseInt(etContact.getText().toString());
        par1name = etPrnt1name.getText().toString();
        if (etPrnt1phone.getText().toString().equals(myString)) {
            par1phone = 0;
        } else par1phone = Integer.parseInt(etPrnt1phone.getText().toString());
        par2name = etPrnt2name.getText().toString();
        if (etPrnt2phone.getText().toString().equals(myString)) {
            par2phone = 0;
        } else par2phone = Integer.parseInt(etPrnt2phone.getText().toString());


        //boolean
        check[0] = mon.isChecked();
        check[1] = tue.isChecked();
        check[2] = wed.isChecked();
        check[3] = thu.isChecked();
        check[4] = fri.isChecked();
        check[5] = sat.isChecked();

        int num = 0b00000001;
        for (int i = 0; i < check.length; i++) {

            if (check[i] == true) day |= num;
            num = num << 1;

        }
        Log.i("ccc", day + "");


        //레트로핏 라이브러리로 데이터 전송
        Retrofit retrofit = RetrofitHelper.getInstance();
        Log.i("TAG", "retrofit");

        //추상메소드 활용
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Log.i("TAG", "retrofitService");

        //데이터
        Map<String, String> dataPart = new HashMap<>(); //보내야하는 값이 int, String 등 하나 이상일때는 object
        dataPart.put("day", day + "");
        dataPart.put("name", name);
        dataPart.put("birthday", birthday + "");
        dataPart.put("contact", contact + "");
        dataPart.put("par1name", par1name);
        dataPart.put("par1phone", par1phone + "");
        dataPart.put("par2name", par2name);
        dataPart.put("par2phone", par2phone + "");
        Log.i("TAG", "Put data");

        //데이터 전송!
        Call<String> call = retrofitService.postData(dataPart);
        Log.i("TAG", "Before enqueue"); //확인

        //에러를 해결해보자
//        OkHttpClient client = new OkHttpClient();
//
//        Gson gson = new GsonBuilder().setLenient().create();
//
//        Retrofit retrofit1 = new Retrofit.Builder().baseUrl("http://projectjm.dothome.co.kr")
//                .client(client).addConverterFactory(GsonConverterFactory.create(gson)).build();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Log.i("TAG", "enqueue");

                    String s = response.body();
//                    AlertDialog.Builder builder = new AlertDialog.Builder(StudentEditActivity.this);
//                    builder.setMessage(s+"").show();
                    Toast.makeText(StudentEditActivity.this, s + "", Toast.LENGTH_SHORT).show();


                    //액티비티 종료
                    finish();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                AlertDialog.Builder builder = new AlertDialog.Builder(StudentEditActivity.this);
                builder.setMessage(t.getMessage()).show();
            }
        });

    }// click complete end.




    public void clickDay(View v){
        //필요없음
//        switch (v.getId()){
//            case R.id.tb_mon:
//                G.attday |= 0b00000001;
//                break;
//            case R.id.tb_tue:
//                G.attday |= 0b00000010;
//                break;
//            case R.id.tb_wed:
//                G.attday |= 0b00000100;
//                break;
//            case R.id.tb_thu:
//                G.attday |= 0b00001000;
//                break;
//            case R.id.tb_fri:
//                G.attday |= 0b00010000;
//                break;
//            case R.id.tb_sat:
//                G.attday |= 0b00100000;
//                break;
//
        }


//    public void clickBtn(View view) {
//        int n= Integer.parseInt(view.getTag().toString());
//        num += n;
//        Log.i("TAG", "num : " + num);
//    }
//
//    public void clickReset(View view) {
//        num=0;
//    }
//
//    boolean[] checked= new boolean[6];
//
//    public void clickLoad(View view) {


//        int mask= 0b00000001;
//        int n= num & mask;



//        Log.i("TAG", "mask 월 : " + n  );
//        if(n==1) checked[0]=true;
//
//        num= num>>1;
//        n= num & mask;
//        Log.i("TAG", "mask 화 : " + n  );
//        if(n==1) checked[0]=true;
//
//        num= num>>1;
//        n= num & mask;
//        Log.i("TAG", "mask 수 : " + n  );
//        if(n==1) checked[0]=true;
//
//        num= num>>1;
//        n= num & mask;
//        Log.i("TAG", "mask 목 : " + n  );
//        if(n==1) checked[0]=true;
//
//        num= num>>1;
//        n= num & mask;
//        Log.i("TAG", "mask 금 : " + n  );
//        if(n==1) checked[0]=true;
//
//        num= num>>1;
//        n= num & mask;
//        Log.i("TAG", "mask 토 : " + n  );
//        if(n==1) checked[0]=true;
//
//    }


//    for(int i=0; i<6; i++){
//
//        num= num>>i;
//        n= mum&mask;
//        if(n==1) checked[i]=true;
//
//    }


}






