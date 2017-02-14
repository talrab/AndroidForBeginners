package com.example.myapplication1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        //this is for the bound service
        Intent intent = new Intent(this,MyBoundService.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);

    }

    public void myStartService (View view){
        Intent intent = new Intent(this,TheService.class);
        startService(intent);
    }
    public void myStopService (View view){
        Intent intent = new Intent(this,TheService.class);
        stopService(intent);
    }

    public void myStartIntentService (View view){
        Intent intent = new Intent(this,TheIntentService.class);
        startService(intent);
    }
    public void myStopIntentService (View view){
        Intent intent = new Intent(this,TheIntentService.class);
        stopService(intent);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////

    MyBoundService myBoundService;
    boolean isBound = false;

    public void getRandomNumber (View view){
        TextView textViewRandomNumber = (TextView)findViewById(R.id.textView_randomNumber);
        textViewRandomNumber.setText(Integer.toString(myBoundService.getRandom()));
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBoundService.LocalBinder binder = (MyBoundService.LocalBinder) service;
            myBoundService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

}
