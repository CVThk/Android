package com.example.buoi07;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyRealm extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("demo_realm.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }
    public static Realm getRealmInstance()
    {
        return Realm.getDefaultInstance();
    }
}
