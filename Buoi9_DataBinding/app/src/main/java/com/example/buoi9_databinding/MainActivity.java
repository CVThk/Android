package com.example.buoi9_databinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.buoi9_databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MainModel model = new MainModel();
        //model.setName("I'm fine ...");
        model.name.set("I'm fine ...");
        binding.setBien(model);
    }
}