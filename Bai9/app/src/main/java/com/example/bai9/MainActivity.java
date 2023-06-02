package com.example.bai9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.bai9.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvDemo.setText("I'm fine");
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("ttt", "ttt");
                replaceFragment();
                showRecyclerView();
            }
        });
    }

    private void replaceFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(binding.frameLayout.getId(), BlankFragment.newInstance());
        transaction.commit();
    }
    private void showRecyclerView() {
        ArrayList<String> data = new ArrayList<>();
        data.add("Thánh");
        data.add("Thần");
        data.add("Thiên");
        data.add("Địa");
        RecyclerViewDemo adapter = new RecyclerViewDemo(data, MainActivity.this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        binding.recyclerView.setAdapter(adapter);
    }
}