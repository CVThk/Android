package GridView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.myapplication.R;

public class GridActivity extends AppCompatActivity {
    GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gv = findViewById(R.id.grid_gridView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        adapter.addAll(getResources().getStringArray(R.array.name));

        gv.setAdapter(adapter);
    }
}