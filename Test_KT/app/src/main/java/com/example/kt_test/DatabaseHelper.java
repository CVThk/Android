package com.example.kt_test;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "pokemon.db";
    private String table_name;

    public DatabaseHelper(Context context, String table_name) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.table_name = table_name;
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<Poke> getAllContacts() {
        ArrayList<Poke> pokes = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + table_name;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Poke poke = new Poke();
                poke.setId(Integer.parseInt(cursor.getString(0)));
                poke.setName(cursor.getString(1));
                poke.setImage(cursor.getString(2));
                pokes.add(poke);
            } while (cursor.moveToNext());
        }
        return pokes;
    }
}