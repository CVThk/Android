package com.example.datamanagertruyencuoi.Adapters;

import static android.app.Activity.RESULT_OK;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datamanagertruyencuoi.DBRealm;
import com.example.datamanagertruyencuoi.ListStoryActivity;
import com.example.datamanagertruyencuoi.ListTopicActivity;
import com.example.datamanagertruyencuoi.Models.Story;
import com.example.datamanagertruyencuoi.Models.Topic;
import com.example.datamanagertruyencuoi.R;
import com.example.datamanagertruyencuoi.UpdateTopicActivity;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;

public class TopicAdapter extends BaseAdapter {
    Context context;
    ArrayList<Topic> items;

    private AppCompatActivity getActivity() {
        return (AppCompatActivity) context;
    }

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
        View layout = LayoutInflater.from(context).inflate(R.layout.item_topic, null, false);
        Topic topic = items.get(i);
        int idTopic = topic.getId();
        TextView textViewId         = layout.findViewById(R.id.itemTopic_textView_id);
        TextView textViewName       = layout.findViewById(R.id.itemTopic_textView_name);
        ImageView imageViewEdit     = layout.findViewById(R.id.itemTopic_imageView_edit);
        ImageView imageViewDelete   = layout.findViewById(R.id.itemTopic_imageView_delete);

        textViewId.setText(topic.getId() + "");
        textViewName.setText(topic.getName());

        imageViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Length Story in topic: ", topic.getStories().size() + "");
                Intent intent = new Intent(context, UpdateTopicActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("idTopic", idTopic);
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
        imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogYN(topic);
            }
        });
        return layout;
    }

    private void openDialogYN(Topic topic) {
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
        textViewQuestion.setText("Bạn có chắc chắn muốn xoá truyện " + topic.getName() + "?");
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
                Topic topicDelete = realm.where(Topic.class).equalTo("id", topic.getId()).findFirst();
                RealmList<Story> stories = topicDelete.getStories();
                for(int i = 0; i < stories.size(); i++) {
                    Story story = stories.get(i);
                    realm.beginTransaction();
                    Story storyDetele = realm.where(Story.class).equalTo("id", story.getId()).findFirst();
                    storyDetele.deleteFromRealm();
                    realm.commitTransaction();
                }
                realm.beginTransaction();
                topicDelete.deleteFromRealm();
                realm.commitTransaction();
                Toast.makeText(context, "Xoá thành công", Toast.LENGTH_LONG).show();
                dialog.cancel();
                Intent intent = new Intent(context, ListTopicActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
    }
}
