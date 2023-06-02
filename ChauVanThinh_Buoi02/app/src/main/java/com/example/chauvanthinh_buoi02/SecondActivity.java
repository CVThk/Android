package com.example.chauvanthinh_buoi02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    public final int REQUEST_CALL_PHONE = 111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel: 0972714788"));
            startActivity(i);
        }
        else {
            requestPermissions(
                    new String[] {
                            Manifest.permission.CALL_PHONE
                    }, REQUEST_CALL_PHONE
            );
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_CALL_PHONE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel: 0972714788"));
                startActivity(i);
            }
            else{
                Toast.makeText(this, "Bạn không cấp quyền nên không thể thực hiện cuộc gọi.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}