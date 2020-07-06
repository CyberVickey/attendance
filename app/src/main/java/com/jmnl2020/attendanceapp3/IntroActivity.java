package com.jmnl2020.attendanceapp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class IntroActivity extends AppCompatActivity {

    //Create 20-06-23

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        //3초 후에 MainActivity 자동실행하기
        han.sendEmptyMessageDelayed(0,3000);

    }

    Handler han = new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg) {
            Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
            startActivity(intent);

            finish();
        }
    };

}
