package com.jmnl2020.attendanceapp3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentStudent extends Fragment {

    Context context;

    ///////////////리사이클러뷰///////////////
    ArrayList<ItemStudentList> items = new ArrayList<>();
    RecyclerView recyclerView;
    AdapterStudentFragment adapter;

    public FragmentStudent(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //학생 아이템 데이터 추가
        items.add(new ItemStudentList("이학생"));
        items.add(new ItemStudentList("신학생"));
        items.add(new ItemStudentList("재학생"));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student, container, false);

        adapter = new AdapterStudentFragment(context, items);
        recyclerView = view.findViewById(R.id.recyclerview_frg4);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
