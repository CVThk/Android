package com.example.apptruyencuoi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StoryDetailsActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView textViewTitle, textViewContent;
    String nameTopic, titleStory, contentStory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_details);

        Intent intent = getIntent();
        nameTopic = intent.getStringExtra("nameTopic");
        titleStory = intent.getStringExtra("titleStory");
        contentStory = intent.getStringExtra("contentStory");

        toolbar         = findViewById(R.id.storyDetails_toolbar);
        textViewTitle   = findViewById(R.id.storyDetails_textView_title);
        textViewContent = findViewById(R.id.storyDetails_textView_content);

        textViewTitle.setText(titleStory);
        textViewContent.setText(contentStory);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(nameTopic);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.getNavigationIcon().setTint(Color.WHITE);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}