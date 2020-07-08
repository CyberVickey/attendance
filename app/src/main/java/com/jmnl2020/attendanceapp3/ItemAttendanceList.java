package com.jmnl2020.attendanceapp3;

public class ItemAttendanceList {

    String stdName;
    String time;
    String att;
    String fin;
    String abs;
    int iv;

    public ItemAttendanceList() {
    }

    public ItemAttendanceList(String stdName, String time, String att, String fin, String abs, int iv) {
        this.stdName = stdName;
        this.time = time;
        this.att = att;
        this.fin = fin;
        this.abs = abs;
        this.iv = iv;
    }

}
