package com.example.ontap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.ontap.fragment.FormNhanVienFragment;
import com.example.ontap.fragment.ListNhanVienFragment;

public class QuanLyNhanVienActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_nhan_vien);
        replaceFormNhanVien();
        replaceListNhanVien();
    }

    public void replaceFormNhanVien()
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_form_nhan_vien, FormNhanVienFragment.newInstance());
        transaction.commit();
    }

    public void replaceListNhanVien()
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_list_nhan_vien, ListNhanVienFragment.newInstance());
        transaction.commit();
    }
}