package com.example.databinding_tuan12.modelview;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;

import com.example.databinding_tuan12.NhanVien;

public class FormNhapModelView extends BaseObservable {
    public ObservableField<NhanVien> nv = new ObservableField<>();

    public FormNhapModelView() {
        resetNV();
    }

    public void setGender(int gender) {
        this.nv.get().setGioiTinh(gender);
    }

    public void resetNV() {
        this.nv.set(new NhanVien());
        this.nv.notifyChange();
    }
}
