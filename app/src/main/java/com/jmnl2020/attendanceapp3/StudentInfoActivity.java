package com.jmnl2020.attendanceapp3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StudentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_info);

        //앱바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }
}
