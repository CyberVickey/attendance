package com.jmnl2020.attendanceapp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdapterAttendanceFragment extends RecyclerView.Adapter {

    Context context;
    ArrayList<ItemAttendanceList> items;

    //생성자

    public AdapterAttendanceFragment(Context context, ArrayList<ItemAttendanceList> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_attendance, parent, false);

        VH holder = new VH(itemView);

        return holder;
    }

//    public String timeSet(){
//        long now = System.currentTimeMillis();
//        Date mDate = new Date(now);
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH시 mm분 ss초");
//        String getTime = simpleDateFormat.format(mDate);
//
//        //StringBuffer timeBuffer = new StringBuffer();
//
//        return getTime;
//    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh = (VH)holder;
        ItemAttendanceList item = items.get(position);

        //String time = timeSet();

        vh.tv_name.setText(item.stdName);
        vh.tv_att.setText("");
        vh.tv_fin.setText("");
        vh.tv_time.setText("");

//        if (item.isAttend == true){
//            vh.tv_att.setText("출석");
//            vh.tv_absent.setText("");
//        } //작동 안됨~!!
//
//        if (item.isFinish == true){
//            vh.tv_fin.setText("종료");
//        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //이너클래스 : 아이템뷰 안의 참조변수를 뷰id 를 찾아서 넣어줌

    class VH extends RecyclerView.ViewHolder{

        TextView tv_name;
        TextView tv_time;
        TextView tv_att;
        TextView tv_absent;
        TextView tv_fin;

        public VH(@NonNull View itemView) {             
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_stdName);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_att = itemView.findViewById(R.id.tv_attendance);
            tv_fin = itemView.findViewById(R.id.tv_finish);
            tv_absent = itemView.findViewById(R.id.tv_absent);

        }
    }

}


