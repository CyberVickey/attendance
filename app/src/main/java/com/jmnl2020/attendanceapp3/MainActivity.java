package com.jmnl2020.attendanceapp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    FragmentManager fragmentManager;
    Fragment[] fragments = new Fragment[5];

    //Retrofit으로 받아올 객체의 arraylist
    ArrayList<StudentDTO> dtos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //앱바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //프래그먼트의 동적 관리를 위한 관리자 객체
        fragmentManager = getSupportFragmentManager();

        //각 탭 화면의 프래그먼트 생성
        fragments[0] = new FragmentCalendar();
        fragments[1] = new FragmentAttendance(this);
        fragments[2] = new FragmentMessage(this);
        fragments[3] = new FragmentStudent(this);
        fragments[4] = new FragmentSetting();

        //제일 처음 띄워줄 뷰 세팅
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragments[0]).commitAllowingStateLoss();

        bottomNavigationView = findViewById(R.id.bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //프레그먼트 작업 트랜잭션 시작
                FragmentTransaction tran = fragmentManager.beginTransaction();
                tran.addToBackStack(null); // fragment를 백 스택에 저장

                switch ( menuItem.getItemId() ){
                    case R.id.menu_calendar:
                        tran.replace(R.id.container, fragments[0]);
                        break;

                    case R.id.menu_attendance:
                        tran.replace(R.id.container, fragments[1]);
                        break;

                    case R.id.menu_message:
                        tran.replace(R.id.container, fragments[2]);
                        break;

                    case R.id.menu_student:
                        tran.replace(R.id.container, fragments[3]);
                        break;

                    case R.id.menu_setting:
                        tran.replace(R.id.container, fragments[4]);
                        break;

                }

                //트랜잭션 작업 완료 명령
                tran.commit();

                //return true 가 아니면 탭은 선택이 되지만 선택 효과가 이동하지 않음.
                return true;

            }

        });

    }//onCreate end.

    @Override
    protected void onResume() {
        super.onResume();
        //서버에서 데이터를 읽어오기
        loadData();
    }

    //서버에서 데이터를 불러들이는 작업 메소드
    void loadData(){

        Retrofit retrofit = RetrofitHelper.getInstance();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<ArrayList <StudentDTO>> call = retrofitService.loadData();

        call.enqueue(new Callback<ArrayList<StudentDTO>>() {
            @Override
            public void onResponse(Call<ArrayList<StudentDTO>> call, Response<ArrayList<StudentDTO>> response) {
                if(response.isSuccessful()){
                    //서버 데이터를 읽어와서 새로운 arrayList 객체에 넣음




                }
            }

            @Override
            public void onFailure(Call<ArrayList<StudentDTO>> call, Throwable t) {

            }
        });

    }//load Data end.


    public void parseIntDay(int day){
        boolean[] checked = new boolean[6];
        int num = day;
        int mask = 0b00000001;

        for(int i=0; i<checked.length; i++){
            num= num>>i;
            int n = num & mask;
            if(n==1) checked[i] = true;
        }

    }


    @Override
    protected void onDestroy() {

        Log.i("TAG", "main Destroy");

        super.onDestroy();

    }
}
