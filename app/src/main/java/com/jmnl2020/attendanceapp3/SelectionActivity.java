package com.jmnl2020.attendanceapp3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        //앱바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    public void clickAttandenceBtn(View view) {
        Intent intent = new Intent(this, NumberInputActivity.class);
        startActivity(intent);
        //번호를 받아서 서버와 학생정보 확인 후 , 문자 전송
    }

    public void clickAdminBtn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
