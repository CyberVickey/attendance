package com.jmnl2020.attendanceapp3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class SelectionActivity extends AppCompatActivity {

    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        //앱바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712"); //테스트광고

        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener(){

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                Toast.makeText(SelectionActivity.this, "광고 로딩 실패", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Toast.makeText(SelectionActivity.this, "광고 로드 성공", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void clickAttendanceBtn(View view) {

        if(mInterstitialAd.isLoaded()) {
            Toast.makeText(this, "광고", Toast.LENGTH_SHORT).show();
            mInterstitialAd.show();
        }


        Intent intent = new Intent(this, NumberInputActivity.class);
        startActivity(intent);
        //번호를 받아서 서버와 학생정보 확인 후 , 문자 전송
    }

    public void clickAdminBtn(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
