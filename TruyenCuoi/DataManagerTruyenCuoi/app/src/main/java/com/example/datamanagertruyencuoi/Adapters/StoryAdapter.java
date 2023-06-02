package com.example.datamanagertruyencuoi.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.datamanagertruyencuoi.DBRealm;
import com.example.datamanagertruyencuoi.ListStoryActivity;
import com.example.datamanagertruyencuoi.Models.Story;
import com.example.datamanagertruyencuoi.R;
import com.example.datamanagertruyencuoi.UpdateStoryActivity;
import com.example.datamanagertruyencuoi.UpdateTopicActivity;

import java.util.ArrayList;

import io.realm.Realm;

public class StoryAdapter extends BaseAdapter {
    Context context;
    ArrayList<Story> items;

    public StoryAdapter(Context context, ArrayList<Story> items) {
        this.context = context;
        this.items = items;
    }
    private AppCompatActivity getActivity() {
        return (AppCompatActivity) context;
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
        TextView textViewId         = layout.findViewById(R.id.itemStory_textView_id);
        TextView textViewTitle      = layout.findViewById(R.id.itemStory_textView_title);
        ImageView imageViewEdit     = layout.findViewById(R.id.itemStory_imageView_edit);
        ImageView imageViewDelete   = layout.findViewById(R.id.itemStory_imageView_delete);
        textViewId.setText(story.getId() + "");
        textViewTitle.setText(story.getTitle());

        imageViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateStoryActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("idStory", story.getId());
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogYN(story);
            }
        });

        return layout;
    }

    private void openDialogYN(Story story) {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_alert_yes_no);

        Window window = dialog.getWindow();
        if(window == null) return;

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttribute = window.getAttributes();
        windowAttribute.gravity = Gravity.CENTER;
        window.setAttributes(windowAttribute);

        dialog.setCancelable(true);

        TextView textViewQuestion       = dialog.findViewById(R.id.dialogYN_textView_question);
        Button  btnAccept               = dialog.findViewById(R.id.dialogYN_button_accept);
        Button  btnCancle               = dialog.findViewById(R.id.dialogYN_button_cancle);
        textViewQuestion.setText("Bạn có chắc chắn muốn xoá truyện " + story.getTitle() + "?");
        dialog.show();

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Realm realm = DBRealm.getRealmInstance();
                realm.beginTransaction();
                Story storyDelete = realm.where(Story.class).equalTo("id", story.getId()).findFirst();
                storyDelete.deleteFromRealm();
                realm.commitTransaction();
                Toast.makeText(context, "Xoá thành công", Toast.LENGTH_LONG).show();
                dialog.cancel();
                Intent intent = new Intent(context, ListStoryActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
    }
}
