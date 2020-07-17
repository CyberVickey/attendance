package com.jmnl2020.attendanceapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LeavingStudentActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ItemLeavingStudent> listItems = new ArrayList<>();
    AdapterLeavingStudentList adapter = new AdapterLeavingStudentList(listItems);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaving_student);

        listView = findViewById(R.id.leaving_listview);
        listView.setAdapter(adapter);

        //1. 현재시간 얻어와서 items에 넣기
        //2. 학생 데이터 받아서 items에 넣기


    }
}
