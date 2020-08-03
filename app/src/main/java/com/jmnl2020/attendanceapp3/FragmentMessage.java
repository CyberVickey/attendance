package com.jmnl2020.attendanceapp3;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class FragmentMessage extends Fragment {

    int clickNum= 0;

    ListView listView;
    ArrayList<ItemMessageFragment> listItem = new ArrayList<>();
    AdapterMessageFragment adapter = new AdapterMessageFragment(listItem);

    //전체선택 가능하게 만들어주자
    boolean checkbox = false;

    //click msg fab
    FloatingActionButton fab;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ArrayList<String> names = new ArrayList<>();
//
//        for(int i=0; i<G.dtos.size(); i++){
//            names.set(i, G.dtos.get(i).name);
//            adapter.notifyDataSetChanged();
//        }

        Log.i("load","onCreate");



    }

    ArrayList<String> tels= new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        listView = view.findViewById(R.id.listview_msgfg);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();


                String t= listItem.get(position).par1phone;
                tels.add( listItem.get(position).par1phone );

                /////////////////////////////////// how to cancel checked phone???????????!!!!!!!!!?!?!?!!?!?

//                if (  ){
//                    for(int i = 0; i<tels.size(); i++){
//                        if (t.equals(tels.get(i))) tels.remove(i);
//                    }
//                }



//                for( String tel : tels){
//                    if ( tel.equals(t)){
//                        tels.remove(position);
//                    }
//                }

                //1. tels에 정보가없다면 클릭된 아이템을 tels에 입력
//                for(int i=0; i<tels.size(); i++){
//                    if (t.equals(tels.get(i))){
//                        tels.remove(i);
//                    }else {
//                        tels.add( listItem.get(position).par1phone );
//                    }
//                }


                //2. tels에 정보가 있는데 클릭되었다면, tels에서 remove
//                for(int i=0; i<tels.size(); i++){
//                    if(t.equals(tels.get(i))){
//                        tels.remove(i);
//                    }
//                }



                //for( String tel : tels){
                //    if( tel.equals( t ) ) listItem.remove(t);
                    //else tels.add( listItem.get(position).par1phone );
               //     Toast.makeText(getActivity(), ""+listItem.get(position).par1phone, Toast.LENGTH_SHORT).show();
               // }

//                tels.add(  listItem.get(position).par1phone  );
//                Toast.makeText(getActivity(), ""+listItem.get(position).par1phone, Toast.LENGTH_SHORT).show(); // 번호 불러오기 확인



            }
        });

        listItem.clear();
        for(int i = 0; i<G.dtos.size(); i++){
            listItem.add(new ItemMessageFragment(G.dtos.get(i).name.toString(), G.dtos.get(i).par1phone, G.dtos.get(i).par1phone));
        }Log.i("load","done for");
        adapter.notifyDataSetChanged();
        Log.i("load","onCreateView");

        String sfName = "sfKey";
        SharedPreferences pref = getActivity().getSharedPreferences(sfName, Context.MODE_PRIVATE);

        //fab
        fab = view.findViewById(R.id.fab_msg);
        fab.bringToFront();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuffer buffer = new StringBuffer();

                for(int i=0; i<tels.size(); i++){
                    buffer.append(tels.get(i).toString());
                    buffer.append(", ");
                }

                String sendingMsgList = buffer.toString();


                Uri msgList = Uri.parse("smsto:"+sendingMsgList);

                Intent intent = new Intent(Intent.ACTION_SENDTO, msgList);
                intent.putExtra("sms_body",  pref.getString("sendMsg", "금일 호우주의보로 인해 수업이 취소되었습니다."));
                startActivity(intent);


//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setData(ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
//                startActivityForResult(intent, 100);

//                sendSMS(data, G.sendMsg);
            }

        });

        return view;
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if(requestCode == RESULT_OK){
//            //공지로 보낼 메세지
// //           sendSMS(data, G.sendMsg);
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }

//    private void sendSMS(Intent data,String msg){
//        Cursor cursor = getActivity().getContentResolver().query(data.getData(),
//                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
//                ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null, null);
//
//        cursor.moveToFirst();
//        String name = cursor.getString(0); //0은 이름을 얻어옴!
//        String number = cursor.getString(1); // 1은 번호를 받아옴!
//
//        cursor.close();
//
//        //((TextView) getView().findViewById(R.id.resMsg)).setText("name : "+ name +"/  number: "+number);
//
//        Uri n = Uri.parse("smsto: "+ number);
//        Intent intent = new Intent(Intent.ACTION_SENDTO, n);
//        intent.putExtra("sms_body", msg);
//        startActivity(intent);
//
//    }


}




