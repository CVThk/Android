package com.example.databinding_tuan12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.databinding_tuan12.fragment.DSNVFragment;
import com.example.databinding_tuan12.fragment.QLNVFragment;

public class Bai2Activity extends AppCompatActivity {

    FrameLayout dsnv, qlnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        replaceQLNVFragment();
        replaceDSNVFragment();
    }

    private void replaceQLNVFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.qlnv, QLNVFragment.newInstance());
        transaction.commit();
    }

    private void replaceDSNVFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.dsnv, DSNVFragment.newInstance());
        transaction.commit();
    }
}