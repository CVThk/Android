package com.example.apptruyencuoi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apptruyencuoi.Models.Story;

import java.util.ArrayList;

public class StoryAdapter extends BaseAdapter {
    Context context;
    ArrayList<Story> items;
    String nameTopic;

    public StoryAdapter(Context context, ArrayList<Story> items, String nameTopic) {
        this.context = context;
        this.items = items;
        this.nameTopic = nameTopic;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return items.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Story story = items.get(i);
        View layout = LayoutInflater.from(context).inflate(R.layout.item_story, null, false);
        TextView textView                       = layout.findViewById(R.id.itemStory_textView_title);
        textView.setText(story.getTitle());
        RelativeLayout relativeLayout           = layout.findViewById(R.id.itemStory_realativeLayout);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, StoryDetailsActivity.class);
                intent.putExtra("nameTopic", nameTopic);
                intent.putExtra("titleStory", story.getTitle());
                intent.putExtra("contentStory", story.getContent());
                context.startActivity(intent);
            }
        });
        return layout;
    }
}
