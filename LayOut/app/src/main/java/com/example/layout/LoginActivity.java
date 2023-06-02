package com.example.layout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button btnRegister, btnLogin;
    EditText editTextUsername, editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnRegister = findViewById(R.id.login_btn_register);
        btnLogin = findViewById(R.id.login_btn_login);
        editTextUsername = findViewById(R.id.login_editText_usename);
        editTextPassword = findViewById(R.id.login_editText_password);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, AccountInfoActivity.class);
                startActivityForResult(i, 100);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextUsername.getText().toString().isEmpty() || editTextPassword.getText().toString().isEmpty()) {
                    Intent i = new Intent(LoginActivity.this, CreateAccountActivity.class);
                    startActivityForResult(i, 100);
                }
                else {
                    Intent i = new Intent(LoginActivity.this, AccountInfoActivity.class);
                    i.putExtra("username", editTextUsername.getText().toString());
                    i.putExtra("password", editTextPassword.getText().toString());
                    setResult(101, i);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("bên ngoài");
        if(resultCode == 100) {
            System.out.println("đã vô");
            editTextUsername.setText(data.getStringExtra("username"));
            editTextPassword.setText(data.getStringExtra("password"));
        }
    }
}