package com.example.helloactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtPhone;
    Button btnSubmit, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Lifecycle: " + "Create");

        edtPhone = (EditText) findViewById(R.id.edt_phone);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnCancel = (Button) findViewById(R.id.btn_cancel);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = edtPhone.getText().toString();
                Intent i = new Intent();
                i.putExtra("phone", data);
                setResult(Activity.RESULT_OK, i);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Lifecycle: " + "Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Lifecycle: " + "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Lifecycle: " + "Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Lifecycle: " + "Stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("Lifecycle: " + "Restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Lifecycle: " + "Destroy");
    }
}