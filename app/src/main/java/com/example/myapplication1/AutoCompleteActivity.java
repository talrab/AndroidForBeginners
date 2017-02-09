package com.example.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteActivity extends AppCompatActivity {

    AutoCompleteTextView acTextView;
    String [] countries = {
            "Afganistan",
            "Albania",
            "Algeria",
            "Andorra",
            "Angola",
            "Argentina",
            "Armenia",
            "Australia",
            "Austria"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        acTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.select_dialog_item,countries);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.select_dialog_item,countries);

        acTextView.setThreshold(1);//waiting for 1 charecters to see the auto compete hints
        acTextView.setAdapter(adapter);
    }


}
