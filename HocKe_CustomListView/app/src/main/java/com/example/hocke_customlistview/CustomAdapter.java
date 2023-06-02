package com.example.hocke_customlistview;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Fruit> arrayList;

    public CustomAdapter(Context context, ArrayList<Fruit> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li = LayoutInflater.from(context);
        View layout = li.inflate(R.layout.customview, null);
        Fruit item = arrayList.get(i);
        System.out.println(item.getLink());
        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(item.getLink(), "drawable",
                context.getPackageName());
        System.out.println(resourceId);
        ImageView img = layout.findViewById(R.id.img);
        img.setImageDrawable(resources.getDrawable(resourceId));
        TextView textView = layout.findViewById(R.id.text);
        textView.setText(item.getName());
        return layout;
    }
}
