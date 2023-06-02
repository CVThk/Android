package com.example.buoi08;

import android.util.Log;

public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        for(int i = 0; i <= 10; i++) {
            Log.e("Thread: ", String.valueOf(i));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
