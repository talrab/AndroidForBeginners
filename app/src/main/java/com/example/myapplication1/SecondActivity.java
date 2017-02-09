package com.example.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextClock clock1;
    TextClock clock2;
    static Button changeClockButton;

    static EditText username;
    static EditText password;
    static Button loginButton;
    static TextView attempts;
    int attemptsCounter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        addChangeClockButtonListener();
        addLoginButtonListener();
    }

    public void addChangeClockButtonListener() {
        changeClockButton = (Button)findViewById(R.id.changeClockButton);
        clock1 = (TextClock)findViewById(R.id.textClock1);
        clock2 = (TextClock)findViewById(R.id.textClock2);

        changeClockButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clock1.getVisibility() == View.INVISIBLE){
                            clock1.setVisibility(View.VISIBLE);
                            clock2.setVisibility(View.INVISIBLE);
                        }
                        else{
                            clock1.setVisibility(View.INVISIBLE);
                            clock2.setVisibility(View.VISIBLE);
                        }
                    }
                }
        );
    }

    public void addLoginButtonListener (){
        username = (EditText)findViewById(R.id.editTextUser);
        password = (EditText)findViewById(R.id.editTextPassowrd);
        loginButton = (Button)findViewById(R.id.button_login);
        attempts = (TextView)findViewById(R.id.textViewAttemptsCount);
        attempts.setText(Integer.toString(attemptsCounter));

        loginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(username.getText().toString().equals("user") &&
                                password.getText().toString().equals("password")){
                            Toast.makeText(SecondActivity.this,"User and Password is correct",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent("com.example.myapplication1.UserActivity");
                            startActivity(intent);
                            attemptsCounter = 5;
                        }
                        else{
                            Toast.makeText(SecondActivity.this,"User and Password is wrong!",Toast.LENGTH_LONG).show();
                            attemptsCounter--;
                            attempts.setText(Integer.toString(attemptsCounter));
                            if (attemptsCounter == 0){
                                loginButton.setEnabled(false);
                            }
                        }
                    }
                }
        );
    }


}
