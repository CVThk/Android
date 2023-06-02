package com.example.buoi07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class RealmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);

        Realm r = MyRealm.getRealmInstance();
        r.beginTransaction();
        int primaryKeyValue = 2;
        SinhVienModel svDB = r.createObject(SinhVienModel.class, primaryKeyValue);
        svDB.setName("Nguyen Van A");
        r.commitTransaction();

        // Read không cần beginTransaction
        RealmResults<SinhVienModel> results = r.where(SinhVienModel.class).findAll();
        for (SinhVienModel sv : results) {
            Log.d("Value: ", sv.getId() + ", " + sv.getName());
        }
    }
}