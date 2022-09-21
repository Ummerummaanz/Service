package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void serviceHandler(View view) {
        Intent serviceIntent = new Intent(this, CateringService.class);
        switch (view.getId()) {
            case R.id.btnStart:
                serviceIntent.putExtra("mkey", "mymusic");
                startService(serviceIntent);
                break;
            case R.id.btnStop:
                stopService(serviceIntent);
                break;
        }

    }

}

