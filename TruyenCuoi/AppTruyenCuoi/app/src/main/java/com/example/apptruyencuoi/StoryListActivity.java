package com.example.apptruyencuoi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.apptruyencuoi.Models.Story;
import com.example.apptruyencuoi.Models.Topic;

import java.util.ArrayList;

public class StoryListActivity extends AppCompatActivity {

    ArrayList<Story> stories = new ArrayList<>();
    Toolbar toolbar;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);

        int idTopic;
        String nameTopic;
        Intent intent = getIntent();
        idTopic = intent.getIntExtra("idTopic", -1);
        nameTopic = intent.getStringExtra("nameTopic");

        toolbar         = findViewById(R.id.storyList_toolBar);
        listView        = findViewById(R.id.storyList_listView);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(nameTopic);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.getNavigationIcon().setTint(Color.WHITE);

        if(idTopic != -1) {
            Cursor cursor = getContentResolver().query(Uri.parse("content://com.example.datamanagertruyencuoi.DataContentProvider/stories"),
                    null, String.valueOf(idTopic), null, null);
            while (cursor.moveToNext()) {
                Story story = new Story();
                story.setId(cursor.getInt(0));
                story.setTitle(cursor.getString(1));
                story.setContent(cursor.getString(2));
                stories.add(story);
            }
        }

        StoryAdapter adapter = new StoryAdapter(this, stories, nameTopic);
        listView.setAdapter(adapter);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}