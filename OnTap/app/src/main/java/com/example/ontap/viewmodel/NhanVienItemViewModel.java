package com.example.ontap.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.ontap.NhanVien;
import com.example.ontap.R;

public class NhanVienItemViewModel extends BaseObservable {
    private NhanVien nhanVien;

    private boolean checked = false;

    public NhanVienItemViewModel(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Bindable
    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Bindable
    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Bindable
    public int getGenderLogo() {
        if (nhanVien.getGender() == NhanVien.GENDER_FEMALE) {
            return R.drawable.girl_medium_light_skin_tone_svgrepo_com;
        }

        return R.drawable.boy_medium_light_skin_tone_svgrepo_com;
    }
}
