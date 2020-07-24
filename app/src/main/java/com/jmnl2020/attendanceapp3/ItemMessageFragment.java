package com.jmnl2020.attendanceapp3;

public class ItemMessageFragment {

    String name;
    String par1phone;
    String par2phone;

    public ItemMessageFragment(String name, String par1phone, String par2phone) {
        this.name = name;
        this.par1phone = par1phone;
        this.par2phone = par2phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
