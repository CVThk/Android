package com.example.kt_test;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this, "pokemons");
        ArrayList<Poke> pokes = db.getAllContacts();
        for(Poke p : pokes) {
            Log.d("Poke nè:", p.getId() + " - " + p.getName() + " - " + p.getImage());
        }
    }

    private SQLiteDatabase openDB() {
        return openOrCreateDatabase("dbName", MODE_PRIVATE, null);
    }
}