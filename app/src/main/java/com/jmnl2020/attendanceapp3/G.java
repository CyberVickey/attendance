package com.jmnl2020.attendanceapp3;

import android.util.Log;

import java.util.ArrayList;

public class G {

    //출석한 학생 정보
    public static StudentDTO student;

    // Retrofit으로 받아올 객체의 arraylist
    public static ArrayList<StudentDTO> dtos = new ArrayList<>();

    //로그인 데이터
    public static boolean isLogin = false;
    public static String nickName; // 프로필 이름
    public static String profileUrl; //프로필 이미지의 uri



    //요일 파싱 메소드
//    public static boolean[] parseIntDay(int day){
//        boolean[] checked = new boolean[6];
//        int num = day;
//        int mask = 0b00000001;
//
//        for(int i=1; i<7; i++){
//            num= num>>1;
//            int n = num & mask;
//            if(n==1) {
//                checked[i] = true;
//            } else {
//                checked[i] = false;
//            }
//            Log.i("aaa", checked[i]+"");
//        }
//        return checked;
//    }


}
