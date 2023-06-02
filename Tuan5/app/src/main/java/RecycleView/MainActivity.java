package RecycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;

import ListView.Contact;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        rv = findViewById(R.id.recycle_view);

        ArrayList<Contact> list = new ArrayList<>();

        list.add(new Contact("Son", "0123456789"));
        list.add(new Contact("Son1", "0123456710"));
        list.add(new Contact("Son2", "0123456711"));

        RecyleAdapter adapter = new RecyleAdapter(this, list);

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}