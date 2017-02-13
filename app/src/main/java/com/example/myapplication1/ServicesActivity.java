package com.example.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
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

}
