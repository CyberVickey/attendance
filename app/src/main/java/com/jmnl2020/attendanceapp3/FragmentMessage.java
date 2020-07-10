package com.jmnl2020.attendanceapp3;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FragmentMessage extends Fragment {

    Context context;

    ListView listView;
    ArrayList<ItemMessageFragment> listItem = new ArrayList<>();
    AdapterMessageFragment adapter = new AdapterMessageFragment();;

    //전체선택 가능하게 만들어주자
    boolean checkbox = false;

    //click msg fab
    FloatingActionButton fab;


    public FragmentMessage(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter.addItem("김학생");
        adapter.addItem("이학생");
        adapter.addItem("박학생");


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        listView = view.findViewById(R.id.listview_msgfg);
        listView.setAdapter(adapter);

        //fab
        fab = view.findViewById(R.id.fab_msg);
        fab.bringToFront();;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tag", "click fab");
                Toast.makeText(context, "click fab", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }



}



