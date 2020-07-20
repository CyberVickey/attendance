package com.jmnl2020.attendanceapp3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LeavingStudentActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ItemLeavingStudent> listItems = new ArrayList<>();
    AdapterLeavingStudentList adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaving_student);

        //앱바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        long now = System.currentTimeMillis();
        Date mDate = new Date(now);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/ MM/ dd  hh:mm");
        String getTime = simpleDateFormat.format(mDate);

        adapter = new AdapterLeavingStudentList(listItems);
        listView = findViewById(R.id.leaving_listview);
        listView.setAdapter(adapter);

        listItems.clear();
        for(int i = 0; i<G.dtos.size(); i++){
            listItems.add(new ItemLeavingStudent(G.dtos.get(i).name, getTime));
        }

        //1. 현재시간 얻어와서 items에 넣기
        //2. 학생 데이터 받아서 items에 넣기


    }
}
