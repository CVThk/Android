package com.example.chauvanthinh_buoi05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lsDemo;
    Button btn;
    RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        lsDemo  = findViewById(R.id.listview_demo);
//        btn     = findViewById(R.id.btn_click);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
//        lsDemo.setAdapter(adapter);
//        adapter.add("Hà Nội");
//        adapter.add("Sài Gòn");
//        adapter.add("Cần Thơ");
//
//
//        lsDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                adapter.add("Mới add");
//            }
//        });


        recyclerView    = findViewById(R.id.rv);
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Nguyễn Văn An", "1111"));
        contacts.add(new Contact("Nguyễn Văn C", "22222"));
        ContactRecyclerAdapter adapter = new ContactRecyclerAdapter(this, contacts);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}