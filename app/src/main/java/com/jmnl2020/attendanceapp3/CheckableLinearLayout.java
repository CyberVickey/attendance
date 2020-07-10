package com.jmnl2020.attendanceapp3;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class CheckableLinearLayout extends LinearLayout implements Checkable {

    //만약 Checkbox가 아닌 View를 추가한다면 변수 사용 -> 그치만 체크박스할거임!
    // private boolean mIschecked;

    //constructors

    public CheckableLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    // implements overide methods
    @Override
    public void setChecked(boolean checked) {
        //3.
        CheckBox cb = findViewById(R.id.checkbox);
        if (cb.isChecked() != checked ){
            cb.setChecked(checked);
        }
    }

    @Override
    public boolean isChecked() {
        //1. 체크박스 생성, findview~~
        CheckBox cb = findViewById(R.id.checkbox);
        return cb.isChecked();
    }

    @Override
    public void toggle() {
        //2.
        CheckBox cb = findViewById(R.id.checkbox);
        setChecked(cb.isChecked() ? false:true);
    }
}
