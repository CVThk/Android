package com.example.datamanagertruyencuoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAddTopic, btnAddStories, btnListTopic, btnListStories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddTopic     = findViewById(R.id.main_btn_addTopic);
        btnAddStories   = findViewById(R.id.main_btn_addStories);
        btnListTopic    = findViewById(R.id.main_btn_listTopic);
        btnListStories  = findViewById(R.id.main_btn_listStories);

        btnAddTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddTopicActivity.class);
                startActivity(i);
            }
        });
        btnAddStories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddStoryActivity.class);
                startActivity(i);
            }
        });
        btnListTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Realm realm = DBRealm.getRealmInstance();
//                RealmResults<Topic> topics = realm.where(Topic.class).findAll();
//                for(Topic topic:topics) {
//                    Log.d("topic:", topic.getId() + ", " + topic.getName());
//                }
                Intent i = new Intent(MainActivity.this, ListTopicActivity.class);
                startActivity(i);
            }
        });
        btnListStories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListStoryActivity.class);
                startActivity(i);
            }
        });
    }
}