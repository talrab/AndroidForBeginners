package com.example.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimePickerActivity extends AppCompatActivity {

    TimePicker timePicker;
    Button showTimeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        showTime();
    }

    public void showTime (){
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        showTimeButton = (Button)findViewById(R.id.button_showTime);
        showTimeButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getBaseContext(),timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute(),Toast.LENGTH_LONG).show();
                        //Toast.makeText(TimePickerActivity.this,timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute(),Toast.LENGTH_LONG).show();    //both options are working
                    }
                }
        );


    }
}
