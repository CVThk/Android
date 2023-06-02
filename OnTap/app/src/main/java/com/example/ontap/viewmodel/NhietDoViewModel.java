package com.example.ontap.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.ontap.BR;

public class NhietDoViewModel extends BaseObservable {

    private int nhietDo;

    private boolean mode = false;

    @Bindable
    public int getNhietDo() {
        return nhietDo;
    }

    public void setNhietDo(int nhietDo) {
        this.nhietDo = nhietDo;
        notifyPropertyChanged(BR.ketQua);
    }

    @Bindable
    public boolean isMode() {
        return mode;
    }

    public void setMode(boolean mode) {
        this.mode = mode;
        notifyPropertyChanged(BR.title);
        notifyPropertyChanged(BR.ketQua);
    }

    @Bindable
    public String getTitle() {
        if (mode) {
            return "Đổi từ độ K sang độ C";
        }

        return "Đổi từ độ C sang độ K";
    }

    @Bindable
    public int getKetQua() {
        if (mode) {
            return nhietDo - 273;
        }

        return nhietDo + 273;
    }
}
