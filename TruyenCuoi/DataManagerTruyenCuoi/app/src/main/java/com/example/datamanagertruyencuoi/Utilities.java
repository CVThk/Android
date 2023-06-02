package com.example.datamanagertruyencuoi;

import android.graphics.Bitmap;
import android.media.Image;

import java.io.ByteArrayOutputStream;

public class Utilities {

    public static byte[] convertImageToBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
}
