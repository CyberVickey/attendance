package com.jmnl2020.attendanceapp3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Retrofit;

public class StudentEditActivity extends AppCompatActivity {

    ToggleButton mon, tue, wed, thu, fri, sat;
    EditText etName;
    EditText etBirthday;
    EditText etContact;
    EditText etPrnt1name;
    EditText etPrnt1phone;
    EditText etPrnt2name;
    EditText etPrnt2phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_edit);

        //앱바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mon = findViewById(R.id.tb_mon);
        tue = findViewById(R.id.tb_tue);
        wed = findViewById(R.id.tb_wed);
        thu = findViewById(R.id.tb_thu);
        fri = findViewById(R.id.tb_fri);
        sat = findViewById(R.id.tb_sat);

        //mmm
        etName = findViewById(R.id.et_name);
        etBirthday = findViewById(R.id.et_birthday);
        etContact = findViewById(R.id.et_contact);
        etPrnt1name = findViewById(R.id.et_name_prnts1);
        etPrnt1phone= findViewById(R.id.et_num_prnts1);
        etPrnt2name = findViewById(R.id.et_name_prnts2);
        etPrnt2phone= findViewById(R.id.et_num_prnts2);

    }


    public void clickComplete(View view){
        //서버에 데이터 전송 [name, birthday, contact, par1name, par1phone, par2 name, par2phone, toggle]
        String name = etName.getText().toString();
        int birthday = Integer.parseInt(etBirthday.getText().toString());
        int contact = Integer.parseInt(etContact.getText().toString());
        String par1name = etPrnt1name.getText().toString();
        int par1phone = Integer.parseInt(etPrnt1phone.getText().toString());
        String par2name = etPrnt2name.getText().toString();
        int par2phone = Integer.parseInt(etPrnt2phone.getText().toString());

        //레트로핏 라이브러리로 데이터 전송
        Retrofit retrofit =

    }


    public void clickDay(View v){
        switch (v.getId()){
            case R.id.tb_mon:
                G.attday = 0b00000001;
                break;
            case R.id.tb_tue:
                G.attday |= 0b00000010;
                break;
            case R.id.tb_wed:
                G.attday |= 0b00000100;
                break;
            case R.id.tb_thu:
                G.attday |= 0b00001000;
                break;
            case R.id.tb_fri:
                G.attday |= 0b00010000;
                break;
            case R.id.tb_sat:
                G.attday |= 0b00100000;
                break;
        }

    }

}
