package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class AccountInfoActivity extends AppCompatActivity {

    EditText editTextUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        editTextUsername = findViewById(R.id.accountInfo_editText_username);
        Intent intent = getIntent();
        editTextUsername.setText(intent.getStringExtra("username"));
    }
}