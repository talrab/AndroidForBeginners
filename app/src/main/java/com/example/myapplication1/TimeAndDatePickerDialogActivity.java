package com.example.myapplication1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimeAndDatePickerDialogActivity extends AppCompatActivity {

    Button showTimePickerDialogButton;
    static final int DIALOG_ID = 0;
    int hour_x;
    int minute_x;

    Button ShowDatePickerDialog;
    static final int D_DIALOG_ID = 1;
    int year_x;
    int month_x;
    int day_x;



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_and_date_picker_dialog);

        showTimePickerDialog();

        final Calendar cal = Calendar.getInstance(); //the below variables are initialized with the current date so the dialog will be opened with the current date presented
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        showDatePickerDialog();
    }

    public void showTimePickerDialog(){
        showTimePickerDialogButton = (Button)findViewById(R.id.button_showTimePickerDialog);
        showTimePickerDialogButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }


    @Override
    protected Dialog onCreateDialog (int id){
        if (id == DIALOG_ID){
            return new TimePickerDialog(TimeAndDatePickerDialogActivity.this, kTimePickerDialogListener, hour_x, minute_x, false);
        }
        else if (id == D_DIALOG_ID){
            return new DatePickerDialog(TimeAndDatePickerDialogActivity.this,dPickerListener,year_x,month_x,day_x);
        }
        return null;
    }


    protected TimePickerDialog.OnTimeSetListener kTimePickerDialogListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hour_x = hourOfDay;
            minute_x = minute;
            Toast.makeText(TimeAndDatePickerDialogActivity.this, hour_x + ":" + minute_x, Toast.LENGTH_LONG).show();
        }
    };


    public void showDatePickerDialog(){
        ShowDatePickerDialog = (Button)findViewById(R.id.button_showDatePickerDialog);
        ShowDatePickerDialog.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(D_DIALOG_ID);
                    }
                }
        );
    }


    private DatePickerDialog.OnDateSetListener dPickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x = year;
            month_x = month+1;
            day_x = dayOfMonth;
            Toast.makeText(TimeAndDatePickerDialogActivity.this,day_x + "/" + month_x + "/" + year_x,Toast.LENGTH_LONG).show();

        }
    };



}
