package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void changeMessage(View view) {
        //TextView textView=(TextView)findViewById(R.id.textview);
        //set text to textview
        //textView.setText("Button clicked");

        Button btn = (Button)findViewById(R.id.btn);
        btn.setText("Clicked");
        btn.setBackgroundColor(Color.parseColor("#B7071f"));
    }
}