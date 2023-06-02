package com.example.datamanagertruyencuoi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.datamanagertruyencuoi.Models.Topic;
import com.example.datamanagertruyencuoi.R;


import java.util.ArrayList;
import java.util.List;

public class SpinnerTopicAdapter extends ArrayAdapter<Topic> {

    Context context;
    ArrayList<Topic> items;

    public SpinnerTopicAdapter(Context context, int resource, List<Topic> objects) {
        super(context, resource, objects);
        this.context = context;
        this.items = new ArrayList<>();
        this.items.addAll(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item_selected, parent, false);
        TextView textView       = convertView.findViewById(R.id.spinnerItemSelected_textView_name);
        textView.setText(items.get(position).getName());
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item_topic, parent, false);
        TextView textView       = convertView.findViewById(R.id.spinnerItemTopic_textView);
        textView.setText(items.get(position).getName());
        return convertView;
    }
}
