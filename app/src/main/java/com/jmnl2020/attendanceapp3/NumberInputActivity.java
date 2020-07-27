package com.jmnl2020.attendanceapp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;


public class NumberInputActivity extends AppCompatActivity {

    TextView tv_stuNum;
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

        //액션바로 현재 화면에서 나갈 수 있는 아이콘 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
        //여기서 하위버전의 Actionbar 호환성 문제를 해결해주는 com.android.support appcompat-v7 implementation 추가

        tableLayout = findViewById(R.id.tableLayout);
        tv_stuNum = findViewById(R.id.tv_stunum);

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

    //옵션메뉴에 X 아이콘 설정
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_action, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_cancel){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("현재 화면에서 나갑니다. 계속 하시겠습니까?");
            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        return true;
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

        if(cnt>=4) cnt=0;
        if(cnt ==0 ){
            tvs[1].setText("");
            tvs[2].setText("");
            tvs[3].setText("");
        }

        tvs[cnt].setText(num+"");
        cnt++;


    }//clickBtn end.

    public void clickCancel(View view) {
        // cancel 버튼이 눌렸을 때

        if(cnt!=0){
            cnt --;
        }

        tvs[cnt].setText("");

    }

    public void clickOK(View view) {
        //입력받은 번호를 받아와서 확인
        StringBuffer buffer = new StringBuffer();
        buffer.append(tvs[0].getText().toString());
        buffer.append(tvs[1].getText().toString());
        buffer.append(tvs[2].getText().toString());
        buffer.append(tvs[3].getText().toString());

//        tv_stuNum.setText(buffer); 동작 테스트 확인

        //G stunum에 buffer로 받은 숫자 입력 : 이용자가 적은 출석번호 = stuNum
        String stuNum = buffer.toString();

        //SharedPreference 사용해서 미리 적어둔 메세지 가져와 사용하기!
        SharedPreferences sf = this.getSharedPreferences("autoMsg", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor;

        boolean in = false;
        for(int i=0; i<G.dtos.size(); i++){
            if (stuNum.equals(G.dtos.get(i).contact) ){
                Toast.makeText(this, "** "+G.dtos.get(i).name + " 출석 완료! **", Toast.LENGTH_SHORT).show();
                in = true;
                G.student = G.dtos.get(i);

                tvs[0].setText("");
                tvs[1].setText("");
                tvs[2].setText("");
                tvs[3].setText("");

//                SendMsg sendMsg = new SendMsg(this);
//                sendMsg.sendMsgTo(G.student.par1phone, sf.getString("MsgIn", G.student.name+" 학생이 출석했습니다."));
//                sendMsg.sendMsgTo(G.student.par2phone, sf.getString("MsgIn", G.student.name+" 학생이 출석했습니다."));

            }

        }
        if (in==false) Toast.makeText(this, "출석번호가 옳은지 확인해주세요.", Toast.LENGTH_SHORT).show();

    }

    public class SendMsg{

        private Context context;
        public SendMsg(Context context){
            this.context = context;
        }

        public void sendMsgTo(String phoneNum, String msg){

//            SmsManager manager = SmsManager.getDefault();
//            manager.sendTextMessage(phoneNum, null, msg, null, null);
//            Toast.makeText(context, "메세지 전송을 완료했습니다.", Toast.LENGTH_SHORT).show();

        }

    }


}
