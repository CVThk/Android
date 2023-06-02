package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lvDemo;
    Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lvDemo = findViewById(R.id.main_listView);
        btnAddItem = findViewById(R.id.main_btn_addItem);

        adapter.add("Quận 1");
        adapter.add("Quận 2");
        adapter.add("Quận 3");
        adapter.add("Quận 4");

        lvDemo.setAdapter(adapter);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add("Quận 12");
            }
        });

    }
}