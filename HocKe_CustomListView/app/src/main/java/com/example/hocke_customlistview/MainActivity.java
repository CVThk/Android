package com.example.hocke_customlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.main_listView_lv);

        ArrayList<Fruit> arrayList = new ArrayList<>();
        arrayList.add(new Fruit("avocado"));
        arrayList.add(new Fruit("durian"));
        arrayList.add(new Fruit("guava"));
        arrayList.add(new Fruit("orange"));
        arrayList.add(new Fruit("strawberry"));

        CustomAdapter adapter = new CustomAdapter(this, arrayList);
        lv.setAdapter(adapter);
//        System.out.println("resourceId 2");
    }
}
