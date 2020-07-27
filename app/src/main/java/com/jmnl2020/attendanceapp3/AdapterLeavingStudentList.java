package com.jmnl2020.attendanceapp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class AdapterLeavingStudentList extends BaseAdapter {

    ArrayList<ItemLeavingStudent> items;

    public AdapterLeavingStudentList(ArrayList<ItemLeavingStudent> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        //1. arraylist만큼 만들것
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
//            Log.i("aaa", checked[i] + "");
        }
//        Log.i("aa", "한바퀴!");
//        Log.i("aaa", day+"");

        return checked;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){ // if convertVeiw != 재활용
            convertView = inflater.inflate(R.layout.item_leftstulist, null);
        }

        TextView name = convertView.findViewById(R.id.leaving_name);
        TextView date = convertView.findViewById(R.id.leaving_date);

        //참조로 찾아와서 내용 set 해주기
        ItemLeavingStudent item = items.get(position);
        name.setText(item.name);
        date.setText(item.date);

        return convertView;
    }
}
