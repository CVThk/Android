package com.example.buoi08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BroadcastReceiverActivity extends AppCompatActivity {

    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
        btn = findViewById(R.id.btnw);
        tv = findViewById(R.id.tvw);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("actionWifi");
                sendBroadcast(intent);
            }
        });

        IntentFilter intentFilter = new IntentFilter("actionWifi");
        registerReceiver(new WifiReceiver(), intentFilter);
    }
}