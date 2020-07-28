package com.jmnl2020.attendanceapp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class IntroActivity extends AppCompatActivity {

    //Create 20-06-23
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        //2초 후에 MainActivity 자동실행하기
        han.sendEmptyMessageDelayed(0,2000);

        //앱 바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        //전면광고 달기

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

//        mInterstitialAd = new InterstitialAd(this);
//        mInterstitialAd.setAdUnitId("3940256099942544/1033173712"); //테스트광고
//
//        mInterstitialAd.loadAd(new AdRequest.Builder().build());
//
//        if(mInterstitialAd.isLoaded()){
//            Toast.makeText(IntroActivity.this, "광고", Toast.LENGTH_SHORT).show();
//            mInterstitialAd.show();
//        }

    }

    Handler han = new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg) {


            Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
            startActivity(intent);

            finish();
        }
    };

}
