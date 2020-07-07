package com.jmnl2020.attendanceapp3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentAttendance extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);

        // TODO: 2020-07-07 액션바 만들기 

//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//
//            getMenuInflater().inflate(R.menu.actionbar, menu);
//
//            return super.onCreateOptionsMenu(menu);
//        }

        return view;
    }
}
