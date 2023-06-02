package com.example.datamanagertruyencuoi;

import android.app.Application;

import com.example.datamanagertruyencuoi.Models.Story;
import com.example.datamanagertruyencuoi.Models.Topic;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class DBRealm extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("TruyenCuoi.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }
    public static Realm getRealmInstance()
    {
        return Realm.getDefaultInstance();
    }
    public static int getIDTopic() {
        int idNew;
        Realm realm = getRealmInstance();
        Number idCur = realm.where(Topic.class).max("id");
        if(idCur == null) {
            idNew = 1;
        }
        else {
            idNew = idCur.intValue() + 1;
        }
        return idNew;
    }
    public static boolean checkTopic(String name) {
        RealmResults<Topic> topics = getRealmInstance().where(Topic.class).equalTo("name", name).findAll();
        return topics.size() == 0;
    }
    public static int getIDStory() {
        int idNew;
        Realm realm = getRealmInstance();
        Number idCur = realm.where(Story.class).max("id");
        if(idCur == null) {
            idNew = 1;
        }
        else {
            idNew = idCur.intValue() + 1;
        }
        return idNew;
    }
    public static boolean checkStory(String title) {
        RealmResults<Story> stories = getRealmInstance().where(Story.class).equalTo("title", title).findAll();
        return stories.size() == 0;
    }
}
