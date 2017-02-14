package com.example.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InternalStorageActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);
    }

    public void read (View view){
        try {
            FileInputStream fileInputStream = openFileInput("myText.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            String lines;
            while ((lines = bufferedReader.readLine()) != null){
                stringBuffer.append(lines+"\n");
            }
            textView.setText(stringBuffer.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void write (View view){
        String myTextMessage = editText.getText().toString();
        try {
            FileOutputStream fileOutputStream = openFileOutput("myText.txt",MODE_PRIVATE); //MODE_PRIVATE means no one will be able to use this file. only my app
            fileOutputStream.write(myTextMessage.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(),"File Saved",Toast.LENGTH_LONG).show();
            editText.setText(""); //clearing the editText after writing
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
