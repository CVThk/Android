package com.example.datamanagertruyencuoi;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.datamanagertruyencuoi.Models.Story;
import com.example.datamanagertruyencuoi.Models.Topic;

import java.util.ArrayList;

public class DataContentProvider extends ContentProvider {
    private static final String AUTHORITY = DataContentProvider.class.getCanonicalName();
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sUriMatcher.addURI(AUTHORITY, "topic", 111);
        sUriMatcher.addURI(AUTHORITY, "topics", 113);
        sUriMatcher.addURI(AUTHORITY, "stories", 115);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String idTopic, @Nullable String[] strings1, @Nullable String s1) {
        int uriType = sUriMatcher.match(uri);
        MatrixCursor cursor;
        Topic topic = null;
        switch (uriType) {
            case 111:
                if(idTopic.isEmpty())
                    return null;
                cursor = new MatrixCursor(new String[] {"id", "name", "image"});
                topic = DBRealm.getRealmInstance().where(Topic.class).equalTo("id", Integer.parseInt(idTopic)).findFirst();
                if(topic != null) {
                    cursor.addRow(new Object[] {topic.getId(), topic.getName(), topic.getImage()});
                }
                return cursor;
            case 113:
                cursor = new MatrixCursor(new String[] {"id", "name", "image"}, 1);
                ArrayList<Topic> topics = new ArrayList<>();
                topics.addAll(DBRealm.getRealmInstance().where(Topic.class).findAll());
                for(int i = 0; i < topics.size(); i++) {
                    topic = topics.get(i);
                    cursor.addRow(new Object[] {topic.getId(), topic.getName(), topic.getImage()});
                }
                return cursor;
            case 115:
                if(idTopic.isEmpty())
                    return null;
                cursor = new MatrixCursor(new String[] {"id", "title", "content"});
                ArrayList<Story> stories = new ArrayList<>();
                topic = DBRealm.getRealmInstance().where(Topic.class).equalTo("id", Integer.parseInt(idTopic)).findFirst();
                if(topic != null) {
                    stories.addAll(topic.getStories());
                }
                for (int i = 0; i < stories.size(); i++) {
                    Story story = stories.get(i);
                    cursor.addRow(new Object[] {story.getId(), story.getTitle(), story.getContent()});
                }
                return cursor;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
