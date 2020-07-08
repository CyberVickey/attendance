package com.jmnl2020.attendanceapp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        VH vh = (VH)holder;
        ItemAttendanceList item = items.get(position);

        vh.tv_name.setText(item.stdName);
        vh.tv_time.setText(item.time);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
    //이너클래스 : 아이템뷰 안의 참조변수를 뷰id 를 찾아서 넣어줌

    class VH extends RecyclerView.ViewHolder{

        TextView tv_name;
        TextView tv_time;

        public VH(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_stdName);
            tv_time = itemView.findViewById(R.id.tv_time);

        }
    }

