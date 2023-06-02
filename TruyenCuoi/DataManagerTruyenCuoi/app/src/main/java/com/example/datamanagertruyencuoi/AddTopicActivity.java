package com.example.datamanagertruyencuoi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Notification;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.datamanagertruyencuoi.Models.Topic;

import java.io.FileNotFoundException;
import java.io.InputStream;

import io.realm.Realm;

public class AddTopicActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button btnPickImage, btnAdd;
    ImageView imageViewPick;
    EditText editTextName;
    byte[] image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_topic);

        toolbar         = findViewById(R.id.addTopic_toolbar);
        btnPickImage    = findViewById(R.id.addTopic_btn_pickImage);
        btnAdd          = findViewById(R.id.addTopic_btn_add);
        imageViewPick   = findViewById(R.id.addTopic_imageView_pick);
        editTextName    = findViewById(R.id.addTopic_editText_name);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 113);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int id = DBRealm.getIDTopic();
                    Log.d("IDNew: ", String.valueOf(id));
                    String name = editTextName.getText().toString();
                    if(name == null || name.trim().isEmpty()) {
                        Toast.makeText(AddTopicActivity.this, "Vui lòng nhập tên chủ đề", Toast.LENGTH_LONG).show();
                    }
                    else if(!DBRealm.checkTopic(name)) {
                        Toast.makeText(AddTopicActivity.this, "Chủ đề đã tồn tại", Toast.LENGTH_LONG).show();
                    }
                    else if(image == null || image.length <= 0) {
                        Toast.makeText(AddTopicActivity.this, "Vui lòng chọn ảnh chủ đề", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Realm realm = DBRealm.getRealmInstance();
                        realm.beginTransaction();
                        Topic topic = realm.createObject(Topic.class, id);
                        topic.setName(name);
                        topic.setImage(image);
                        realm.commitTransaction();
                        Toast.makeText(AddTopicActivity.this, "Thêm thành công", Toast.LENGTH_LONG).show();
                        finish();
                    }
                } catch (Exception e) {
                    Toast.makeText(AddTopicActivity.this, "Thêm thất bại", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imageViewPick.setImageBitmap(selectedImage);
                image = Utilities.convertImageToBytes(selectedImage);
                //imageViewPick.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(AddTopicActivity.this, "Lỗi chọn ảnh", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(AddTopicActivity.this, "Bạn chưa chọn ảnh",Toast.LENGTH_LONG).show();
        }
    }
}