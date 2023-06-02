package com.example.datamanagertruyencuoi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.datamanagertruyencuoi.Adapters.SpinnerTopicAdapter;
import com.example.datamanagertruyencuoi.Models.Story;
import com.example.datamanagertruyencuoi.Models.Topic;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class AddStoryActivity extends AppCompatActivity {

    Spinner spinnerTopics;
    EditText editTextTitle, editTextContent;
    Button btnAdd;
    ArrayList<Topic> topics = new ArrayList<>();
    int idTopicSelected;
    int idStory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_story);

        spinnerTopics          = findViewById(R.id.addStories_spinner_topics);
        btnAdd                 = findViewById(R.id.addStories_btn_add);
        editTextTitle          = findViewById(R.id.addStories_editText_title);
        editTextContent        = findViewById(R.id.addStories_editText_content);

        Realm realm = DBRealm.getRealmInstance();
        RealmResults<Topic> realmResultsTopics = realm.where(Topic.class).findAll();
        topics.addAll(realmResultsTopics);

        SpinnerTopicAdapter adapter = new SpinnerTopicAdapter(AddStoryActivity.this, R.layout.spinner_item_selected, topics);
        spinnerTopics.setAdapter(adapter);

        spinnerTopics.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Topic topicSelected = adapter.getItem(i);
                idTopicSelected = topicSelected.getId();
//                Toast.makeText(AddStoryActivity.this, "ID: " + topicSelected.getId() + ", Name: " + topicSelected.getName(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString();
                String content = editTextContent.getText().toString();
                if(title == null || title.trim().isEmpty()) {
                    Toast.makeText(AddStoryActivity.this, "Vui lòng nhập tiêu đề", Toast.LENGTH_LONG).show();
                }
                else if(!DBRealm.checkStory(title)) {
                    Toast.makeText(AddStoryActivity.this, "Truyện đã tồn tại", Toast.LENGTH_LONG).show();
                }
                else if(content == null || content.trim().isEmpty()) {
                    Toast.makeText(AddStoryActivity.this, "Vui lòng nhập nội dung", Toast.LENGTH_LONG).show();
                }
                else {
                    idStory = DBRealm.getIDStory();
                    realm.beginTransaction();
                    Story story = realm.createObject(Story.class, idStory);
//                    story.setIdTopic(idTopicSelected);
                    story.setTitle(title);
                    story.setContent(content);
                    Topic topic = null;
                    for(Topic t : topics) {
                        if(t.getId() == idTopicSelected) {
                            topic = t;
                            break;
                        }
                    }
                    if(topic != null) {
                        topic.getStories().add(story);
                    }
                    realm.commitTransaction();
                    Toast.makeText(AddStoryActivity.this, "Thêm thành công", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
}