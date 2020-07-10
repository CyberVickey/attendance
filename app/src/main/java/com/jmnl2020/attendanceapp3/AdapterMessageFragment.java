package com.jmnl2020.attendanceapp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterMessageFragment extends BaseAdapter {

    //adapter에 추가된 데이터를 저장하기 위한 ArrayList
    ArrayList<ItemMessageFragment> items = new ArrayList<>();

    public AdapterMessageFragment() { // constructor

    }

    @Override
    public int getCount() {
        //1.
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override//3. 지정한 위치(position)에 있는 데이터와 관계된 아이템 ID를 리턴 : 필수 !!!
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //2. position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴 : 필수!!
        final int pos = position;
        final Context context = parent.getContext();

        // listview item 레이아웃을 inflate -> convertView 참조를 가져와야함
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_message, parent, false);
        }

        //화면에 표시될 View (Layout이 inflate된 뷰) 로부터 위젯에 대한 참조 획득
        TextView tv = convertView.findViewById(R.id.tv_nameMsg);

        return convertView;
    }

     //아이템 데이터 추가를 위한 함수
    public void addItem(String name){
        ItemMessageFragment listItem = new ItemMessageFragment();

        listItem.setName(name);

        items.add(listItem);

    }

}
