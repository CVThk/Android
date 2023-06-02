package com.example.databinding_tuan12;

import java.io.Serializable;

public class NhanVien implements Serializable {
    public static final int GENDER_MALE = 1;
    public static final int GENDER_FEMALE = 0;
    String maNV, tenNV;
    int gioiTinh = GENDER_FEMALE;

    public NhanVien() {}
    public NhanVien(String maNV, String tenNV, int gioiTinh) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
