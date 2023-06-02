package com.example.buoi07;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DemoContentProvider  extends ContentProvider {
    private static final String AUTHORITY = DemoContentProvider.class.getCanonicalName();
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sUriMatcher.addURI(AUTHORITY, "demo", 100);
        sUriMatcher.addURI(AUTHORITY, "rex/*", 101);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        int uriType = sUriMatcher.match(uri);
        MatrixCursor cs;
        switch (uriType){
            case 100:
                cs = new MatrixCursor(new String[] {"id", "name"}, 1);
                cs.addRow(new Object[] {"1", "hello"});
                return cs;
            case 101:
                cs = new MatrixCursor(new String[] {"id", "name"}, 1);
                cs.addRow(new Object[] {"2", "Hi"});
                return cs;
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
