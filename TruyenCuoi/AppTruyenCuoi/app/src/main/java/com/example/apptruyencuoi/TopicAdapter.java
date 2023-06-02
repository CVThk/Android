package com.example.apptruyencuoi;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.apptruyencuoi.Models.Topic;

import java.util.ArrayList;

public class TopicAdapter extends BaseAdapter {
    Context context;
    ArrayList<Topic> items;

    public TopicAdapter(Context context, ArrayList<Topic> items) {
        this.context = context;
        this.items = items;
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
        Topic topic = items.get(i);
        View layout = LayoutInflater.from(context).inflate(R.layout.item_topic, null, false);
        ImageView imageView     = layout.findViewById(R.id.itemTopic_imageView);
        TextView textView       = layout.findViewById(R.id.itemTopic_textView);
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(topic.getImage(), 0, topic.getImage().length));
        textView.setText(topic.getName());
        ConstraintLayout constraintLayout = layout.findViewById(R.id.itemtopic_item);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, StoryListActivity.class);
                intent.putExtra("idTopic", topic.getId());
                intent.putExtra("nameTopic", topic.getName());
                context.startActivity(intent);
            }
        });
        return layout;
    }
}
