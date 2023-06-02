package com.example.datamanagertruyencuoi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.datamanagertruyencuoi.Adapters.TopicAdapter;
import com.example.datamanagertruyencuoi.Models.Topic;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class ListTopicActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_topic);

        toolbar         = findViewById(R.id.listTopic_toolbar);
        listView        = findViewById(R.id.listTopic_listView);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Danh sách chủ đề");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Realm realm = DBRealm.getRealmInstance();
        RealmResults<Topic> realmResults = realm.where(Topic.class).findAll();
        ArrayList<Topic> topics = new ArrayList<>();
        topics.addAll(realmResults);
        TopicAdapter adapter = new TopicAdapter(ListTopicActivity.this, topics);
        listView.setAdapter(adapter);
    }
}