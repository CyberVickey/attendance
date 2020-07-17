package com.jmnl2020.attendanceapp3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FragmentStudent extends Fragment {

    ///////////////리사이클러뷰///////////////
    ArrayList<ItemStudentList> items = new ArrayList<>();
    RecyclerView recyclerView;
    AdapterStudentFragment adapter;

    //fab
    FloatingActionButton fab;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //학생 아이템 데이터 추가
        Toast.makeText(getActivity(), "oncreate", Toast.LENGTH_SHORT).show();

        items.clear();;
        for(int i = 0; i<G.dtos.size(); i++){

            items.add(new ItemStudentList(G.dtos.get(i).name, Integer.parseInt(G.dtos.get(i).day)));
            //adapter.notifyDataSetChanged();
        }


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student, container, false);

        adapter = new AdapterStudentFragment(getActivity(), items);
        recyclerView = view.findViewById(R.id.recyclerview_frg4);
        recyclerView.setAdapter(adapter);

        fab = view.findViewById(R.id.fab_std);
        fab.bringToFront();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StudentEditActivity.class);
                getActivity().startActivity(intent);

            }
        });

        return view;
    }
}
