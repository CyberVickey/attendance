package com.jmnl2020.attendanceapp3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BaseCalendar {

    private static final int DAYS_OF_WEEK = 7;
    private static final int LOW_OF_CALENDAR = 6;

    Calendar calendar = Calendar.getInstance();

    int prevMonthTailOffset = 0;
    int nextMonthHeadOffset = 0;
    int currentMonthMaxDate = 0;

    ArrayList<Integer> data = new ArrayList<>();

    public BaseCalendar() {

    }

    public void changeToPrevMonth(){
        if(calendar.get(Calendar.MONTH) == 0){
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) -1);
            calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        }else {
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) -1);
        }
        makeMonthDate(refreshCallbak);
    }

    public void changeToNextMonth(){
        if(calendar.get(Calendar.MONTH) == Calendar.DECEMBER){
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
            calendar.set(Calendar.MONTH, 0);
        }else {
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) +1);
        }
        makeMonthDate(refreshCallback);
    }

    ////// make month date //////

    public void makeMonthDate(){
        data.clear();

        calendar.set(Calendar.DATE, 1);
        currentMonthMaxDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        prevMonthTailOffset = calendar.get(Calendar.DAY_OF_WEEK) -1;
        makePrevMonthTail((Calendar) calendar.clone());
        makeCurrentMonth(calendar);

        nextMonthHeadOffset = LOW_OF_CALENDAR * DAYS_OF_WEEK- (prevMonthTailOffset + currentMonthMaxDate);
        makeNextMonthHead();

        refreshCallback(calendar);
    }

    //이전달의 마지막날을 얻어와서 현재달의 첫째날 생성
    private void makePrevMonthTail(Calendar calendar){
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) -1);
        int maxDate = calendar.getActualMaximum(Calendar.DATE);
        int maxOffsetDate = maxDate - prevMonthTailOffset;
        for(int i=1; i<calendar.getActualMaximum(Calendar.DATE); i++){
            data.add(i);
        }
    }


    //현재 달의 data 생성
    private void makeCurrentMonth(Calendar calendar){
        for (int i=1; i<calendar.getActualMaximum(Calendar.DATE); i++){
            data.add(i);
        }
    }


    //다음달 data 생성
    private void makeNextMonthHead(){
        int date = 1;
        for(int i=1; i<nextMonthHeadOffset; i++){
            data.add(date++);
        }
    }


}

