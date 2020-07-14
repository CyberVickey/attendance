package com.jmnl2020.attendanceapp3;

public class StudentDTO {

    int day;
    String name;
    int birthday;
    int stucontact;
    String par1name;
    int par1phone;
    String par2name;
    int par2phone;

    public StudentDTO() {
    }

    public StudentDTO(int day, String name, int birthday, int stucontact, String par1name, int par1phone, String par2name, int par2phone) {
        this.day = day;
        this.name = name;
        this.birthday = birthday;
        this.stucontact = stucontact;
        this.par1name = par1name;
        this.par1phone = par1phone;
        this.par2name = par2name;
        this.par2phone = par2phone;
    }
}
