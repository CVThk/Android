package com.example.testwebservice;

import android.os.AsyncTask;
import android.util.Log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class HttpGetRequest extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL("http://10.0.2.2:4567/get");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            InputStreamReader is;
            if(responseCode >= 200 && responseCode < 300){
                is = new InputStreamReader(httpURLConnection.getInputStream());
            }
            else {
                is = new InputStreamReader(httpURLConnection.getErrorStream());
            }
            BufferedReader bf = new BufferedReader(is);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
            ObjectMapper mapper = new ObjectMapper();
            //Student student = mapper.readValue(stringBuilder.toString(), Student.class);
            ArrayList<Student> arr = mapper.readValue(stringBuilder.toString(), new TypeReference<ArrayList<Student>>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            });
            Log.d("Status code:", String.valueOf(responseCode));
            Log.d("Header:", httpURLConnection.getResponseMessage());
            Log.d("Respon:", stringBuilder.toString());
            //Log.d("Student:", student.getName() + ", " + student.getAge());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
