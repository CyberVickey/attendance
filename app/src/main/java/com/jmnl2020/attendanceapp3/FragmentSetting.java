package com.jmnl2020.attendanceapp3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentSetting extends Fragment {

    LinearLayout linearLayout1;
    LinearLayout linearLayout2;
    LinearLayout linearLayout3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        linearLayout1 = view.findViewById(R.id.linearlayout1);
        linearLayout2 = view.findViewById(R.id.linearlayout2);
        linearLayout3 = view.findViewById(R.id.linearlayout3);

        //안내메세지 수정
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),NumberInputActivity.class);
                startActivity(intent);
            }
        });

        // 휴,퇴원생 목록
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),NumberInputActivity.class);
                startActivity(intent);
            }
        });


        //출석화면으로 전환
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),NumberInputActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
