package com.example.restapi_test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class BackTask extends AsyncTask<String, Integer, String> {

    private final String TAG = "BackTask";
    private String _response ="";
    private CallCompleted callCompleted = null;

    public BackTask(CallCompleted _callCompleted) {
        this.callCompleted = _callCompleted;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            Translate translateRequest = new Translate();
            String response = translateRequest.Post("Goodbye my friend");
            _response = response;
        } catch (Exception e) {
            System.out.println(e);
        }
        

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Bitmap _image = BitmapFactory.decodeFile(s);
        this.callCompleted.onCallCompleted(_response);
    }

}
