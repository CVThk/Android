package com.example.buoi06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        bottomNavigationView = findViewById(R.id.bottomNavigation_bottomNavigation);
//        bottomNavigationView.setSelectedItemId(R.id.menu_qr);
        int id = R.id.menu_qr;
        System.out.println("ID: " + id);
        bottomNavigationView.setSelectedItemId(id);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_scanner:
                        setFragment(DetailsFragment.newInstance("Scanner"));
                        return true;
                    case R.id.menu_email:
                        setFragment(DetailsFragment.newInstance("Email"));
                        return true;
                    case R.id.menu_qr:
                        setFragment(DetailsFragment.newInstance("QR"));
                        return true;
                }
                return true;
            }
        });


    }
    public void setFragment(Fragment f) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(
          R.id.bottomNavigation_frameLayout_fragmentDetails,
          f
        );
        transaction.commit();
    }
}