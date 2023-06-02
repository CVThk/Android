package com.example.apptruyencuoi;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.apptruyencuoi.Models.Topic;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Topic> topics = new ArrayList<>();
    Toolbar toolbar;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar         = findViewById(R.id.main_toolbar);
        listView        = findViewById(R.id.main_listView);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Truyện cười");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.getNavigationIcon().setTint(Color.WHITE);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Cursor cursor = getContentResolver().query(
                Uri.parse("content://com.example.datamanagertruyencuoi.DataContentProvider/topics"),
                null, null, null, null
        );

        while (cursor.moveToNext()) {
            Topic topic = new Topic();
            topic.setId(cursor.getInt(0));
            topic.setName(cursor.getString(1));
            topic.setImage(cursor.getBlob(2));
            topics.add(topic);
        }
        TopicAdapter adapter = new TopicAdapter(this, topics);
        listView.setAdapter(adapter);
    }
}
