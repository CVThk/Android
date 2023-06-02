package com.example.hellocontentresolver;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cursor cursor = getContentResolver().query(
                Uri.parse("content://com.example.buoi07.DemoContentProvider/rex/1"),
                null, null, null, null
        );
        while (cursor.moveToNext()) {
            Log.d(getClass().getCanonicalName(), "Test Name: " + cursor.getString(1));
        }
    }
}