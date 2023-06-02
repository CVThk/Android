package com.example.databinding_tuan12.modelview;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class Temperature extends BaseObservable {
    double input;
    boolean checkSwitch;

    @Bindable
    public double getInput() {
        return input;
    }

    public void setInput(double input) {
        this.input = input;
        notifyPropertyChanged(BR.output);
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public boolean isCheckSwitch() {
        return checkSwitch;
    }

    public void setCheckSwitch(boolean checkSwitch) {
        this.checkSwitch = checkSwitch;
        notifyPropertyChanged(BR.output);
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getTitle() {
        if(checkSwitch) {
            return "Đổi từ độ K sang độ C";
        }
        return "Đổi từ độ C sang độ K";
    }

    @Bindable
    public String getOutput() {
        if(checkSwitch) {
            return (input - 273.5) + "";
        }
        return (input + 273.5) + "";
    }
}
