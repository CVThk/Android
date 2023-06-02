package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class CreateActivity extends AppCompatActivity {

    EditText editTextEmail, editTextUsername, editTextPassword, editTextConfirmPassword;
    Button btnSignIn, btnCancle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        btnSignIn = findViewById(R.id.create_btn_signin);
        btnCancle = findViewById(R.id.create_btn_cancle);
        editTextEmail = findViewById(R.id.create_editText_email);
        editTextUsername = findViewById(R.id.create_editText_username);
        editTextPassword = findViewById(R.id.create_editText_password);
        editTextConfirmPassword = findViewById(R.id.create_editText_confirm_password);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isValid(editTextEmail.getText().toString())) {
                    editTextEmail.setError("Invalid email address !!!");
                    return;
                }
                if(editTextUsername.getText().toString().isEmpty()) {
                    editTextUsername.setError("Username cannot be null !!!");
                    return;
                }
                if(editTextPassword.getText().toString().isEmpty()) {
                    editTextPassword.setError("Required password !!!");
                    return;
                }
                if(editTextConfirmPassword.getText().toString().isEmpty()) {
                    editTextConfirmPassword.setError("Required confirm password !!!");
                    return;
                }
                if(editTextConfirmPassword.getText().toString().compareTo(editTextPassword.getText().toString()) != 0) {
                    editTextConfirmPassword.setError("Confirm password and password not matches !!!");
                    return;
                }
                else {
                    Intent i = new Intent(CreateActivity.this, LoginActivity.class);
                    i.putExtra("username", editTextUsername.getText().toString());
                    i.putExtra("password", editTextPassword.getText().toString());
                    setResult(RESULT_OK, i);
                    finish();
                }
            }
        });
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CreateActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}