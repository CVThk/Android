package com.example.helloactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Button btnJump;

    public final int REQUEST_PHONE = 123;
    public final int REQUEST_PERMISSION_PHONE = 124;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnJump = (Button) findViewById(R.id.second_btn_jump);
        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                {
                    // Da cap quyen roi
                    System.out.println("Button jump da click...");
                    Intent i = new Intent(
                            SecondActivity.this,
                            MainActivity.class
                    );
                    startActivityForResult(i, REQUEST_PHONE);
                }
                else {
                    // Chua cap quyen
                    requestPermissions(
                            new String[] {
                                    Manifest.permission.CALL_PHONE,
                            },
                            REQUEST_PERMISSION_PHONE
                    );
                }
            }
        });
    }

    public void callPhone(String phone)
    {
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(
                Uri.parse("tel:" + phone)
        );
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_PHONE) {
            if (resultCode == Activity.RESULT_OK) {
                // An Submit
                String phone = data.getStringExtra("phone");
                callPhone(phone);
            } else if (resultCode == Activity.RESULT_CANCELED) {
                // An cancel
                Toast.makeText(this, "Ban da cancel roi", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_PERMISSION_PHONE)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                // Allow
                Intent i = new Intent(
                        SecondActivity.this,
                        MainActivity.class
                );
                startActivityForResult(i, REQUEST_PHONE);
            }
            else {
                // Deny
                Toast.makeText(this, "Khong cho quyen thi sao ma lam", Toast.LENGTH_SHORT).show();
            }
        }
    }
}