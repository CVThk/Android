package com.example.buoi07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SharedPreferences

//        SharedPreferences sp = getSharedPreferences("PREF_Buoi07", MainActivity.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sp.edit();
//        editor.putString("k1", "v1");
//        editor.commit();
//
//        Log.d("Test: ", sp.getString("k1", null));


        // sqlite

        SQLiteDatabase sql = openDB();

        sql.close();
        createPhoneTable();
        insert("T", "0909090909");
    }
    private String dbName = "phonebook.db";
    private SQLiteDatabase openDB() {
        return openOrCreateDatabase(dbName, MODE_PRIVATE, null);
    }
    private void closeDB(SQLiteDatabase db) {
        db.close();
    }
    private void createPhoneTable() {
        SQLiteDatabase db = openOrCreateDatabase(dbName, MODE_PRIVATE, null);
        String sql = "create table if not exists tblPhonebook(id integer PRIMARY KEY autoincrement, name text, phone text);";
        db.execSQL(sql);
        db.close();
    }

    private void insert(String name, String phone) {
        SQLiteDatabase db = openOrCreateDatabase(dbName, MODE_PRIVATE, null);
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("phone", phone);
        db.insert("tblPhonebook", null, cv);
        db.close();
    }

}