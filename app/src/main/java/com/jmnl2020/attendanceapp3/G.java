package com.jmnl2020.attendanceapp3;

import android.util.Log;

import java.util.ArrayList;

public class G {

    //학생들이 입력한 비밀번호(학생번호) 저장
    public static int stuNum;

    // Retrofit으로 받아올 객체의 arraylist
    public static ArrayList<StudentDTO> dtos = new ArrayList<>();

    //로그인 데이터
    public static boolean isLogin = false;
    public static String nickName; // 프로필 이름
    public static String profileUrl; //프로필 이미지의 uri

    //메세지 보낼 문구
    public static String msgIn = "";
    public static String msgOut = "";
    public static String sendMsg = "";





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
