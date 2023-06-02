package com.example.buoi9_databinding;

import android.util.Log;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;

//public class MainModel extends BaseObservable {
//    private String name;
//
//    @Bindable
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//        notifyPropertyChanged(BR.name);
//    }
//
//    public void btnClick(View view) {
//        Log.e("Button Click", "Click");
//    }
//    public void btnClick(View view, String value) {
//        Log.e("Button Click", value);
//        this.name += value;
//        notifyPropertyChanged(BR.name);
//    }
//}

public class MainModel {
    public ObservableField<String> name = new ObservableField<>();
    public MainModel() {
        name.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.e("Name", name.get());
            }
        });
    }

    public void btnClick(View view) {
        Log.e("Button Click", "Click");
    }
    public void btnClick(View view, String value) {
        Log.e("Button Click", value);
    }
}
