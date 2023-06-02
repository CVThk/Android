package com.example.datamanagertruyencuoi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.datamanagertruyencuoi.Adapters.StoryAdapter;
import com.example.datamanagertruyencuoi.Models.Story;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class ListStoryActivity extends AppCompatActivity {

    ListView listView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_story);

        toolbar         = findViewById(R.id.listStory_toolbar);
        listView        = findViewById(R.id.listStory_listView);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Danh sách truyện cười");

        ArrayList<Story> stories = new ArrayList<>();
        Realm realm = DBRealm.getRealmInstance();
        RealmResults<Story> realmResults = realm.where(Story.class).findAll();
        stories.addAll(realmResults);

        StoryAdapter adapter = new StoryAdapter(ListStoryActivity.this, stories);
        listView.setAdapter(adapter);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}