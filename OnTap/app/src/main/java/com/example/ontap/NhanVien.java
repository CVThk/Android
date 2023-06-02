package com.example.ontap;

import java.io.Serializable;

public class NhanVien implements Serializable {

    public static final int GENDER_FEMALE = 1;
    public static final int GENDER_MALE = 2;

    private String ma, ten;
    private int gender = GENDER_MALE;

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getMaTen()
    {
        return ma + " - " + ten;
    }
}
