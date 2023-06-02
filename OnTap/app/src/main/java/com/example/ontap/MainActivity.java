package com.example.ontap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ontap.databinding.ActivityMainBinding;
import com.example.ontap.viewmodel.NhietDoViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    NhietDoViewModel vm = new NhietDoViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        binding.setM(vm);

    }
}