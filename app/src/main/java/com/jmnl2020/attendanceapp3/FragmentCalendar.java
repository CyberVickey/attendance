package com.jmnl2020.attendanceapp3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FragmentCalendar extends Fragment {

    RecyclerView rv_schecule;
    TextView tv_prev_month;
    TextView tv_next_month;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        rv_schecule = view.findViewById(R.id.rv_schedule);
        tv_prev_month = view.findViewById(R.id.tv_prev_month);
        tv_next_month = view.findViewById(R.id.tv_next_month);

        initView();

        return view;
    }

    public void initView(){
        // 어댑터를 만들어서 붙여주기

        //클릭 리스너
        tv_prev_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tv_next_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}


