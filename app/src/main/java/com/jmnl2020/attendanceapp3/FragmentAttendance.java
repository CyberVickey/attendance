package com.jmnl2020.attendanceapp3;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FragmentAttendance extends Fragment {

    TextView tv_date;
    TextView tv_totalStd;
    String date;

    //////////////////////리사이클러뷰 ////////////////////////////////
    //Item (Cardview) 안에 입력할 대량의 데이터 임의생성
    ArrayList<ItemAttendanceList> recyclerviewItems = new ArrayList<>();
    RecyclerView recyclerView;
    AdapterAttendanceFragment attendanceAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //cardview 추가시 현재 시간 가져오기
        long now = System.currentTimeMillis();
        Date mDate = new Date(now);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH시 mm분 ss초");
        String getTime = simpleDateFormat.format(mDate);

        StringBuffer timeBuffer = new StringBuffer();

//        timeBuffer.append(getTime);
//        timeBuffer.append(" ~ ");
        // 끝나는 시간 append 시켜주기


        //오늘의 날짜 가져오기
        SimpleDateFormat format = new SimpleDateFormat("MM월 dd일");
        date = format.format(mDate);


        //아이템 추가
        for(int i=0; i<G.dtos.size(); i++){
            recyclerviewItems.add(new ItemAttendanceList(G.dtos.get(i).name, getTime));
        }

//        recyclerviewItems.add(new ItemAttendanceList("김학생", getTime+""));
//        recyclerviewItems.add(new ItemAttendanceList("전학생", getTime+""));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);

        //재원생수
        tv_totalStd = view.findViewById(R.id.tv_totalstd);
        StringBuffer stuBuffer = new StringBuffer();
        stuBuffer.append("재원생: ");
        stuBuffer.append(G.dtos.size()+"");

        tv_totalStd.setText(stuBuffer);

        //Fragment에 액션바 만들기 -> TextView
        tv_date = view.findViewById(R.id.tv_date);
        tv_date.setText(date+"");

        //fragment와 연결된 xml 파일을 여기서 inflate

        attendanceAdapter = new AdapterAttendanceFragment(getActivity(), recyclerviewItems);
        recyclerView = view.findViewById(R.id.recyclerview_frg2);
        recyclerView.setAdapter(attendanceAdapter);


        return view;
    }


//    @Override
//    public void onResume() {
//        super.onResume();
//
//        if (G.student != null) {
//            for(int i=0; i<recyclerviewItems.size(); i++ ){
//                if(G.student.name.equals(recyclerviewItems.get(i).stdName)){
//                    recyclerviewItems.set(i,)
//                }
//            }
//        }
//
//    }
}
