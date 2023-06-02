package com.example.datamanagertruyencuoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class UpdateStoryActivity extends AppCompatActivity {

    Spinner spinnerTopics;
    EditText editTextTitle, editTextContent;
    Button btnUpdate, btnCancle;
    ArrayList<Topic> topics = new ArrayList<>();
    int idTopicSelected;
    Story story;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_story);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        realm = DBRealm.getRealmInstance();
        story = realm.where(Story.class).equalTo("id", bundle.getInt("idStory")).findFirst();

        spinnerTopics          = findViewById(R.id.updateStories_spinner_topics);
        btnUpdate              = findViewById(R.id.updateStories_btn_add);
        btnCancle              = findViewById(R.id.updateStories_btn_cancle);
        editTextTitle          = findViewById(R.id.updateStories_editText_title);
        editTextContent        = findViewById(R.id.updateStories_editText_content);

        Realm realm = DBRealm.getRealmInstance();
        RealmResults<Topic> realmResultsTopics = realm.where(Topic.class).findAll();
        topics.addAll(realmResultsTopics);

        SpinnerTopicAdapter adapter = new SpinnerTopicAdapter(UpdateStoryActivity.this, R.layout.spinner_item_selected, topics);
        spinnerTopics.setAdapter(adapter);

        editTextTitle.setText(story.getTitle());
        editTextContent.setText(story.getContent());

        int posSelected = 0;
        boolean exit = false;
        for (Topic topic:topics) {
            for(Story st : topic.getStories()) {
                if(st.getId() == story.getId()){
                    exit = true;
                    Log.d("Test Update: ", st.getContent());
                    break;
                }
            }
            if(exit) {
                break;
            }
            posSelected++;
        }
        spinnerTopics.setSelection(posSelected);

        spinnerTopics.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Topic topicSelected = adapter.getItem(i);
                idTopicSelected = topicSelected.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNew = new Intent(UpdateStoryActivity.this, ListStoryActivity.class);
                startActivity(intentNew);
                finish();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString();
                String content = editTextContent.getText().toString();
                if(title == null || title.trim().isEmpty()) {
                    Toast.makeText(UpdateStoryActivity.this, "Vui lòng nhập tiêu đề", Toast.LENGTH_LONG).show();
                }
                else if(content == null || content.trim().isEmpty()) {
                    Toast.makeText(UpdateStoryActivity.this, "Vui lòng nhập nội dung", Toast.LENGTH_LONG).show();
                }
                else {
                    realm.beginTransaction();
                    Story storyUpdate = realm.where(Story.class).equalTo("id", story.getId()).findFirst();
//                    storyUpdate.setIdTopic(idTopicSelected);
                    storyUpdate.setTitle(title);
                    storyUpdate.setContent(content);
                    realm.commitTransaction();
                    Toast.makeText(UpdateStoryActivity.this, "Cập nhật thành công", Toast.LENGTH_LONG).show();
                    Intent intentNew = new Intent(UpdateStoryActivity.this, ListStoryActivity.class);
                    startActivity(intentNew);
                    finish();
                }
            }
        });
    }
}