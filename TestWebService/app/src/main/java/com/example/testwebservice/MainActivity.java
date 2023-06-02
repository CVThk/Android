package com.example.testwebservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Student student;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn     = findViewById(R.id.btn);

        HttpGetRequest httpGetRequest = new HttpGetRequest();
        httpGetRequest.execute();

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://10.0.2.2:4567/")
//                .addConverterFactory(JacksonConverterFactory.create())
//                .build();
//
//        IDemo api = retrofit.create(IDemo.class);
//        api.getDemo().enqueue(new Callback<Student>() {
//            @Override
//            public void onResponse(Call<Student> call, Response<Student> response) {
//                student = response.body();
//                Log.d("Name:", student.getName());
//                Log.d("Age:", String.valueOf(student.getAge()));
//            }
//
//            @Override
//            public void onFailure(Call<Student> call, Throwable t) {
//
//            }
//        });
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("Name:", student.getName());
//            }
//        });
    }
}