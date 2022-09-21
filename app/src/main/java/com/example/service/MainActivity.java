package com.example.service;

import static androidx.constraintlayout.widget.Constraints.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
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
            case R.id.btnBind:
                bindService(serviceIntent,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbind:
                unbindService(serviceConnection);
                break;
        }

    }

    CateringService cateringService;
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder binder) {
            CateringService.LocalBinder localBinder = (CateringService.LocalBinder) binder;
            cateringService = localBinder.getService();
            Log.i(TAG, "sum of 10,43 is: "+ cateringService.add(10,43));
            Log.i(TAG, "latest ads are: "+cateringService.getAds());

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

}

