package com.jmnl2020.attendanceapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void clickLogin(View view) {
        //로그인 구현해서 Selection Activity로 넘기기
        Intent intent = new Intent(this, SelectionActivity.class);
        startActivity(intent);
    }
}
