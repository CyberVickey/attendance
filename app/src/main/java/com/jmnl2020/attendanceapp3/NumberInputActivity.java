package com.jmnl2020.attendanceapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberInputActivity extends AppCompatActivity {

    TextView tv_num1, tv_num2, tv_num3, tv_num4;
    final Button[] btns = new Button[10];
    //Button 참조변수 10개 배열객체

    TableLayout tableLayout;

    //tv를 배열로 만들어서 현재 들어가야 하는 값을 변수로 생성, 활용 -> 더욱 쉽게 관리 가능
    TextView[] tvs= new TextView[4];
    int cnt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_input);

        tableLayout = findViewById(R.id.tableLayout);


//        tv_num1 = findViewById(R.id.tv_num1);
//        tv_num2 = findViewById(R.id.tv_num2);
//        tv_num3 = findViewById(R.id.tv_num3);
//        tv_num4 = findViewById(R.id.tv_num4);
        // for문을 돌려서 대입

        for(int i=0; i<tvs.length; i++){
            tvs[i]= findViewById(R.id.tv_num1+i);
        }

        for(int i=0; i<btns.length; i++ ){
            btns[i] = findViewById(R.id.btn00+i); //배열에 참조변수 대입
        }

        initial();

    }

    void initial(){


        for(int i=0; i<btns.length; i++){
            btns[i].setText(i+"");
            btns[i].setVisibility(View.VISIBLE);

        }

    }

    //버튼을 눌렀을 때
    public void clickNum(View v) {

        Button bt = (Button) v; // 눌러진 버튼 v 에 써있는 글씨를 얻어와야함.

        String s =bt.getText().toString();
        int num = Integer.parseInt(s);

        if(cnt ==0 ){
            tvs[1].setText("");
            tvs[2].setText("");
            tvs[3].setText("");
        }

        tvs[cnt].setText(num+"");
        cnt++;
        if(cnt>=4) cnt=0;

    }//clickBtn end.

    public void clickCancel(View view) {
        // cancel 버튼이 눌렸을 때

        if(cnt!=0){
            cnt --;
        }
        tvs[cnt].setText("");

    }

    public void clickOK(View view) {
    }


// ---------------------수정된 코드 -----------------------
//    public void clickNum(View view) {
//        //현재 클릭한 버튼
//        //v.getId()를 하게 되면 사용자가 누른 버튼의 아이디가 들어간다.
//        // 따라서 Button btnClicked는 항상 사용자가 누른 버튼을 의미한다.
//
//        Button btnClicked = findViewById(view.getId());
//
//        TextView inputtv;
//
//        if(tv_num1.getText() == ""){
//            inputtv = tv_num1;
//        }else if(tv_num2.getText() == ""){
//            inputtv = tv_num2;
//        }else if(tv_num3.getText() == ""){
//            inputtv = tv_num3;
//        }else if(tv_num4.getText() == ""){
//            inputtv = tv_num4;
//        }else{
//            tv_num1.setText("");
//            tv_num2.setText("");
//            tv_num3.setText("");
//            tv_num4.setText("");
//
//            inputtv = tv_num1;
//
//            //텍스트뷰의 빈칸을 찾아둠
//
//        }
//
//
//        switch (btnClicked.getId()){
//            case R.id.btn00: inputtv.setText("0");
//            case R.id.btn01: inputtv.setText("1");
//            case R.id.btn02: inputtv.setText("2");
//            case R.id.btn03: inputtv.setText("3");
//            case R.id.btn04: inputtv.setText("4");
//            case R.id.btn05: inputtv.setText("5");
//            case R.id.btn06: inputtv.setText("6");
//            case R.id.btn07: inputtv.setText("7");
//            case R.id.btn08: inputtv.setText("8");
//            case R.id.btn09: inputtv.setText("9");
//
//        } ***이렇게 만들 필요 없음! 이미 위에서 num 값을 찾아두었기 때문에 대입하기만 하면 끝!
//
//    }


}
