package com.jmnl2020.attendanceapp3;

import java.util.ArrayList;

public class G {

    //학생들이 입력한 비밀번호(학생번호) 저장
    public static int stuNum;

    // Retrofit으로 받아올 객체의 arraylist
    public static ArrayList<StudentDTO> dtos = new ArrayList<>();

    //학생 출석 요일
    public static int attday =0;

    //로그인 데이터
    public static boolean isLogin = false;
    public static String nickName; // 프로필 이름
    public static String profileUrl; //프로필 이미지의 uri

    //메세지 보낼 문구
    public static String sendMsg = "안녕하세요.";


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


}
