package com.jmnl2020.attendanceapp3;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class StudentEditActivity extends AppCompatActivity {

    EditText etName;
    EditText etBtd;
    TextView tvName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_edit);

        //앱바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        etName = findViewById(R.id.et_name);
        etBtd = findViewById(R.id.et_birthday);
        tvName = findViewById(R.id.tv_nameInfo);

        etBtd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvName.setText(etName.getText().toString());
            }
        });



    }

}
