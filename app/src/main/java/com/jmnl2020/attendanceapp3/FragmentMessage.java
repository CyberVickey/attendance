package com.jmnl2020.attendanceapp3;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

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

        ArrayList<String> names = new ArrayList<>();

        for(int i=0; i<G.dtos.size(); i++){
            names.add(G.dtos.get(i).name);
            adapter.notifyDataSetChanged();
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        listView = view.findViewById(R.id.listview_msgfg);
        listView.setAdapter(adapter);

        //fab
        fab = view.findViewById(R.id.fab_msg);
        fab.bringToFront();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(intent, 100);

//                sendSMS(data, G.sendMsg);
            }

        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == RESULT_OK){
            sendSMS(data, G.sendMsg);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void sendSMS(Intent data,String msg){
        Cursor cursor = getActivity().getContentResolver().query(data.getData(),
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null, null);

        cursor.moveToFirst();
        String name = cursor.getString(0); //0은 이름을 얻어옴!
        String number = cursor.getString(1); // 1은 번호를 받아옴!

        cursor.close();

        //((TextView) getView().findViewById(R.id.resMsg)).setText("name : "+ name +"/  number: "+number);

        Uri n = Uri.parse("smsto: "+ number);
        Intent intent = new Intent(Intent.ACTION_SENDTO, n);
        intent.putExtra("sms_body", msg);
        startActivity(intent);
    }


}




