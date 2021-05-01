package com.example.restapi_test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements CallCompleted {

    Button btn_getCityID = null;
    Button btn_getWeatherByCityID = null;
    Button btn_getWeatherByCityName = null;
    EditText et_dataInput = null;
    ListView lv_WeatherReports = null;

    BackTask backTask = null;
    CallCompleted callCompleted = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_getCityID = findViewById(R.id.btn_getCityID);
        btn_getWeatherByCityID = findViewById(R.id.btn_getWeatherByCityID);
        btn_getWeatherByCityName = findViewById(R.id.btn_getWeatherByCityName);

        et_dataInput = findViewById(R.id.et_dataInput);
        lv_WeatherReports = findViewById(R.id.lv_WeatherReports);
        callCompleted = this;

        btn_getCityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Instantiate the RequestQueue.
                backTask = new BackTask(callCompleted);
                backTask.execute();
            }
        });


    }

    @Override
    public void onCallCompleted(String result) {

//        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
          et_dataInput.setText(result);
    }
}