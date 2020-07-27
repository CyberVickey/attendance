package com.jmnl2020.attendanceapp3;

public class ItemAttendanceList {

    String stdName;
    String time = "";
    boolean isAttend;
    boolean isFinish;

    public ItemAttendanceList() {
    }

    public ItemAttendanceList(String stdName, String time, boolean isAttend, boolean isFinish) {
        this.stdName = stdName;
        this.time = time;
        this.isAttend = isAttend;
        this.isFinish = isFinish;
    }

}
