package ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class CustomAdapter extends AppCompatActivity {
    Context context;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        ArrayList<Contact> list = new ArrayList<>();

        list.add(new Contact("Son", "0123456789"));
        list.add(new Contact("Son1", "0123456710"));
        list.add(new Contact("Son2", "0123456711"));

        ContactAdapter contactAdapter = new ContactAdapter(list, this);

        lv = findViewById(R.id.custome_listView);

        lv.setAdapter(contactAdapter);
    }
}