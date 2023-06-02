package com.example.databinding_tuan12.modelview;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.databinding_tuan12.NhanVien;
import com.example.databinding_tuan12.R;

public class NhanVienItemModelView extends BaseObservable {
    NhanVien nv;
    boolean check;

    public NhanVienItemModelView(NhanVien nv) {
        this.nv = nv;
    }

    @Bindable
    public int getImageGender() {
        if(nv.getGioiTinh() == NhanVien.GENDER_MALE) {
            return R.drawable.nam;
        }
        return R.drawable.nu;
    }

    @Bindable
    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Bindable
    public String getTitle() {
        return nv.getMaNV() + "-" + nv.getTenNV();
    }

    public NhanVien getNv() {
        return nv;
    }
}
