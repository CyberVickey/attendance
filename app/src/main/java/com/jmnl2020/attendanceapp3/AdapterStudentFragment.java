package com.jmnl2020.attendanceapp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterStudentFragment extends RecyclerView.Adapter {

    Context context;
    ArrayList<ItemStudentList> items;

    public AdapterStudentFragment(Context context, ArrayList<ItemStudentList> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_student, parent, false);

        ViewHolder holder = new ViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        ItemStudentList item = items.get(position);

        viewHolder.tv.setText(item.studentName);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder{

    TextView tv;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        tv= itemView.findViewById(R.id.tv_stdListName);

    }
}
