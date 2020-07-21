package com.jmnl2020.attendanceapp3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentSetting extends Fragment {

    LinearLayout linearLayout1;
    LinearLayout linearLayout2;
    LinearLayout linearLayout3;

    //profile
    CircleImageView cv;
    TextView name;

    //Alert Dialog
    EditText etMsgIn;
    EditText etMsgOut;
    EditText etMsg;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        linearLayout1 = view.findViewById(R.id.linearlayout1);
        linearLayout2 = view.findViewById(R.id.linearlayout2);
        linearLayout3 = view.findViewById(R.id.linearlayout3);

        //profile
        cv = view.findViewById(R.id.cv);
        name = view.findViewById(R.id.tv_settingname);

        name.setText(G.nickName);
        //cv.setImageResource(Integer.parseInt(G.profileUrl));

        //안내메세지 수정
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("안내 메세지 수정");
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View v2 = inflater.inflate(R.layout.edit_message, null);
                etMsgIn = v2.findViewById(R.id.et_msgIn);
                etMsgOut = v2.findViewById(R.id.et_msgOut);
                etMsg = v2.findViewById(R.id.et_msg);

                builder.setView(v2);

                //확인버튼 만들기
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //edit text 에서 바뀐 내용 업데이트.
                        G.msgIn = etMsgIn.getText().toString();
                        G.msgOut = etMsgOut.getText().toString();
                        G.sendMsg = etMsg.getText().toString();

                        Toast.makeText(getActivity(), "변경된 내용을 저장했습니다!", Toast.LENGTH_SHORT).show();
                    }
                });

                //취소버튼 만들기
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //아무일도 없음
                        Toast.makeText(getActivity(), "아무일도 일어나지 않았다..", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();

            }
        });

        // 휴,퇴원생 목록
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),LeavingStudentActivity.class);
                startActivity(intent);
            }
        });


        //출석화면으로 전환
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),NumberInputActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
