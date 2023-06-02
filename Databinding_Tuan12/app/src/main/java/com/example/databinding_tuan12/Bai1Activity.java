package com.example.databinding_tuan12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.databinding_tuan12.databinding.ActivityBai1Binding;
import com.example.databinding_tuan12.modelview.Temperature;

public class Bai1Activity extends AppCompatActivity {

    ActivityBai1Binding binding;
    Temperature temperature = new Temperature();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBai1Binding.inflate(getLayoutInflater());
        binding.setM(temperature);
        setContentView(binding.getRoot());
    }
}