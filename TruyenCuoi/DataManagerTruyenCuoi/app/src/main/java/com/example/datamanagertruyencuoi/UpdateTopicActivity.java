package com.example.datamanagertruyencuoi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

public class UpdateTopicActivity extends AppCompatActivity {

    EditText editTextName;
    ImageView imageViewPick;
    Button btnPick, btnUpdate, btnCancle;
    byte[] image;
    Realm realm = DBRealm.getRealmInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_topic);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        int idTopic = bundle.getInt("idTopic");
        Topic topic = realm.where(Topic.class).equalTo("id", idTopic).findFirst();
        image = topic.getImage();

        editTextName            = findViewById(R.id.updateTopic_editText_name);
        imageViewPick           = findViewById(R.id.updateTopic_imageView_pick);
        btnPick                 = findViewById(R.id.updateTopic_btn_pickImage);
        btnUpdate               = findViewById(R.id.updateTopic_btn_update);
        btnCancle               = findViewById(R.id.updateTopic_btn_cancle);

        editTextName.setText(topic.getName());
        imageViewPick.setImageBitmap(BitmapFactory.decodeByteArray(topic.getImage(), 0, topic.getImage().length));


        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent picImage = new Intent(Intent.ACTION_PICK);
                picImage.setType("image/*");
                startActivityForResult(picImage, 113);
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String name = editTextName.getText().toString();
                    if(name == null || name == "" || name.length() <= 0) {
                        Toast.makeText(UpdateTopicActivity.this, "Vui lòng nhập tên chủ đề", Toast.LENGTH_LONG).show();
                    }
                    else if(!DBRealm.checkTopic(name)) {
                        Toast.makeText(UpdateTopicActivity.this, "Chủ đề đã tồn tại", Toast.LENGTH_LONG).show();
                    }
                    else if(image == null || image.length <= 0) {
                        Toast.makeText(UpdateTopicActivity.this, "Vui lòng chọn ảnh chủ đề", Toast.LENGTH_LONG).show();
                    }
                    else {
                        realm.beginTransaction();
                        Topic topicUpdate = realm.where(Topic.class).equalTo("id", topic.getId()).findFirst();
                        topicUpdate.setName(name);
                        topicUpdate.setImage(image);
                        realm.commitTransaction();
                        Toast.makeText(UpdateTopicActivity.this, "Cập nhật thành công", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(UpdateTopicActivity.this, ListTopicActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } catch (Exception e) {
                    Toast.makeText(UpdateTopicActivity.this, "Thêm thất bại", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            Log.d("request: ", requestCode + "");
            try {
                final Uri imageUri = data.getData();
                final InputStream inputStream = getContentResolver().openInputStream(imageUri);
                final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                image = Utilities.convertImageToBytes(bitmap);
                imageViewPick.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(UpdateTopicActivity.this, "Lỗi chọn ảnh", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(UpdateTopicActivity.this, "Bạn chưa chọn ảnh",Toast.LENGTH_LONG).show();
        }
    }

}