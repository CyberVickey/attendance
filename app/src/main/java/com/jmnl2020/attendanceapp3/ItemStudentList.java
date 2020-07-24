package com.jmnl2020.attendanceapp3;

public class ItemStudentList {

    String day;
    String name;
    String birthday;
    String contact;
    String par1name;
    String par1phone;
    String par2name;
    String par2phone;

    public ItemStudentList(String name, String birthday, String contact, String par1name, String par1phone, String par2name, String par2phone) {
        this.name = name;
        this.birthday = birthday;
        this.contact = contact;
        this.par1name = par1name;
        this.par1phone = par1phone;
        this.par2name = par2name;
        this.par2phone = par2phone;
    }

    //    public ItemStudentList(String studentName, int day) {
//        this.studentName = studentName;
//        this.day = day;
//    }
}
