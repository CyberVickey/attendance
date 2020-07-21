package com.jmnl2020.attendanceapp3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
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
        // boolean 배열을 하나씩 입력시키자!

        //1. 개인마다 토글버튼 배열이 있음
        //2. 개인의 토글버튼을 체크해주는 메소드가 필요

        //토글버튼 on/off
        boolean[] checking =parseIntDay(Integer.parseInt(G.dtos.get(position).day));

        viewHolder.tbMon.setChecked(checking[0]);
        viewHolder.tbTue.setChecked(checking[1]);
        viewHolder.tbWed.setChecked(checking[2]);
        viewHolder.tbThu.setChecked(checking[3]);
        viewHolder.tbFri.setChecked(checking[4]);
        viewHolder.tbSat.setChecked(checking[5]);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }




    public static boolean[] parseIntDay(int day) {
        int pid = android.os.Process.myPid();
        String whiteList = "logcat -P '" + pid + "'";
        try {
            Runtime.getRuntime().exec(whiteList).waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean[] checked = new boolean[6];
        int num = day;
        int mask = 0b00000001;

        for (int i = 0; i < 6; i++) {

            int n = num & mask;
            if (n == 1) {
                checked[i] = true;

            } else {
                checked[i] = false;
            }
            num = num >> 1;
            Log.i("aaa", checked[i] + "");
        }
        Log.i("aa", "한바퀴!");
        Log.i("aaa", day+"");

        return checked;
    }

    public void removeItem(int adapterPosition) {
        items.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }

    public void restoreItem(ItemStudentList item, int position) {
        items.add(position, item);
        // notify item added by position
        notifyItemInserted(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ToggleButton tbMon, tbTue, tbWed, tbThu, tbFri, tbSat;
        TextView tv;

        LinearLayout viewForeground;
        RelativeLayout viewBackground;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv= itemView.findViewById(R.id.tv_stdListName);
            tbMon = itemView.findViewById(R.id.tb_mon);
            tbTue = itemView.findViewById(R.id.tb_tue);
            tbWed = itemView.findViewById(R.id.tb_wed);
            tbThu = itemView.findViewById(R.id.tb_thu);
            tbFri = itemView.findViewById(R.id.tb_fri);
            tbSat = itemView.findViewById(R.id.tb_sat);

            viewForeground = itemView.findViewById(R.id.view_foreground);
            viewBackground = itemView.findViewById(R.id.view_background);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    //student info xml 이용해서 alertdialog 만들기
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);


                }
            });


        }// constructor

    }// ViewHolder end.

}


