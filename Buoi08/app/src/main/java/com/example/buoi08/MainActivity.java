package com.example.buoi08;

import static java.lang.Thread.sleep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tv;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message message) {
            int i = message.getData().getInt("step");
            tv.setText(i + "");
            return true;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv);
//        MyThread thread = new MyThread();
//        thread.start();


//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0; i <= 10; i++) {
//                    Log.e("Thread: ", String.valueOf(i));
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        });
//        thread.start();



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0; i < 10; i++) {
                            Message message = handler.obtainMessage();
                            Intent intent = new Intent();
                            intent.putExtra("step", i);
                            message.setData(intent.getExtras());
                            handler.sendMessage(message);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });
                thread.start();
            }
        });
    }
}