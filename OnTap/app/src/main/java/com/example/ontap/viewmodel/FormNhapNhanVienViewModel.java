package com.example.ontap.viewmodel;

import android.util.Log;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;

import com.example.ontap.NhanVien;

public class FormNhapNhanVienViewModel {

    public ObservableField<NhanVien> nhanVien = new ObservableField<>();

    public FormNhapNhanVienViewModel() {
        resetNhanVien();
    }

    public void setGender(int gender) {
        this.nhanVien.get().setGender(gender);
        this.nhanVien.notifyChange();
    }

    public void resetNhanVien()
    {
        this.nhanVien.set(new NhanVien());
        this.nhanVien.notifyChange();
    }
}
