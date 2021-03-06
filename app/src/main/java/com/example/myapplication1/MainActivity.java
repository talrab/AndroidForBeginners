package com.example.myapplication1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText password;
    Button pwd_button;
    CheckBox dog;
    CheckBox cat;
    CheckBox cow;
    Button checkBox_Button;

    RadioGroup radioG;
    RadioButton selectedRadioButton;
    Button radio_Button;

    TextView ratingText;
    RatingBar ratingBar;
    Button ratingButton;

    static Button alertButton;
    static Button secondActivityButton;
    static Button seekBarButton;
    static Button webViewButton;
    static Button gesturesButton;
    static Button fragmentsButton;
    static Button autoCompleteButton;
    static Button timePickerButton;
    static Button timeAndDatePickerDialogButton;
    static Button notifyMeButton;
    static Button servicesButton;
    static Button internalStorageButton;
    static Button dbButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
        ab.setLogo(R.mipmap.ic_launcher);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);


        addButtonClickListener();
        addListenerToCheckBox();
        addListenerToRatingBar();
        addRatingBarButtonClickListener();
        addAlertButtonClickListener();
        addSecondActivityButtonClickListener();
        addSeekBarButtonListener();
        addWebViewButtonListener();
        addWebGesturesButtonListener();
        addFragmentsButtonListener();
        addAutoCompleteButtonListener();
        addTimePickerButtonListener();
        addTimeAndDatePickerDialogButtonListener();
        addNotifyMeButtonListener();
        addServicesButtonListener();
        addInternalStorageButtonListener();
        addDbButtonListener();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.info_id:
                Toast.makeText(getApplicationContext(),"info icon is selected",Toast.LENGTH_LONG).show();
            case R.id.setting_id:
                Toast.makeText(getApplicationContext(),"settings icon is selected",Toast.LENGTH_LONG).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addListenerToCheckBox(){
        dog = (CheckBox)findViewById(R.id.dog);
        dog.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        //if(((CheckBox)v).isChecked()){
                        if(dog.isChecked()){
                            Toast.makeText(MainActivity.this,"Dog is Checked",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
        radioG = (RadioGroup)findViewById(R.id.radioGroup);
        radio_Button = (Button)findViewById(R.id.radio_button);
        radio_Button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int selected_id = radioG.getCheckedRadioButtonId();
                        selectedRadioButton = (RadioButton)findViewById(selected_id);
                        Toast.makeText(MainActivity.this,selectedRadioButton.getText(),Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void addListenerToRatingBar (){
        ratingText = (TextView)findViewById(R.id.textRating);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        ratingText.setText("Rating is: " + String.valueOf(rating));
                    }
                }
        );
    }

    public void addRatingBarButtonClickListener (){
        ratingButton = (Button)findViewById(R.id.rating_button);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        ratingButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,String.valueOf(ratingBar.getRating()),Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void addButtonClickListener (){
        password = (EditText)findViewById(R.id.passwordText);
        pwd_button = (Button)findViewById(R.id.pwd_button);
        pwd_button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,password.getText(),Toast.LENGTH_LONG).show();
                    }
                }
        );
        checkBox_Button = (Button)findViewById(R.id.checkBox_Button);
        dog = (CheckBox)findViewById(R.id.dog);
        cat = (CheckBox)findViewById(R.id.cat);
        cow = (CheckBox)findViewById(R.id.cow);
        checkBox_Button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        StringBuffer result = new StringBuffer();
                        result.append("Dog: ").append(dog.isChecked());
                        result.append("\nCat: ").append(cat.isChecked());
                        result.append("\nCow: ").append(cow.isChecked());
                        Toast.makeText(MainActivity.this,result.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void addAlertButtonClickListener(){
        alertButton = (Button)findViewById(R.id.alertButton);
        alertButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        a_builder.setMessage("Do you want to close ? ").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish(); //closing the app
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();//closes the alert
                            }
                        });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Alert !!!");
                        alert.show();
                    }

                }
        );
    }

    public void addSecondActivityButtonClickListener (){
        secondActivityButton = (Button)findViewById(R.id.openSecondActivity_button);
        secondActivityButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.myapplication1.SecondActivity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void addSeekBarButtonListener (){
        seekBarButton = (Button)findViewById(R.id.button_seekBar);
        seekBarButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.myapplication1.SeekBarActivity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void addWebViewButtonListener(){
        webViewButton = (Button)findViewById(R.id.button_webView);
        webViewButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.myapplication1.WebViewActivity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void addWebGesturesButtonListener(){
        gesturesButton = (Button)findViewById(R.id.button_gestures);
        gesturesButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.myapplication1.GesturesActivity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void addFragmentsButtonListener(){
        fragmentsButton = (Button)findViewById(R.id.button_fragments);
        fragmentsButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.myapplication1.FragmentsActivity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void addAutoCompleteButtonListener(){
        autoCompleteButton = (Button)findViewById(R.id.button_autoComplete);
        autoCompleteButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.myapplication1.AutoCompleteActivity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void addTimePickerButtonListener (){
        timePickerButton = (Button)findViewById(R.id.button_timePicker);
        timePickerButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.myapplication1.TimePickerActivity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void addTimeAndDatePickerDialogButtonListener(){
        timeAndDatePickerDialogButton = (Button)findViewById(R.id.button_timeAndDatePickerDialog);
        timeAndDatePickerDialogButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.myapplication1.TimeAndDatePickerDialogActivity");
                        startActivity(intent);
                    }
                }
        );
    }

    /*
    A pending intent is a token that you give to another application (e.g. notification manager, alarm manager or other 3rd party applications),
    which allows this other application to user the permissions of your application to execute a predefined piece of code.
     */
    public void addNotifyMeButtonListener(){
        notifyMeButton = (Button)findViewById(R.id.button_notify);
        notifyMeButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                        Notification noti = new Notification.Builder(MainActivity.this)
                                .setTicker("TickerTitle")
                                .setContentTitle("Content Title")
                                .setContentText("Content Text, my text... my text")
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .addAction(R.mipmap.ic_launcher,"Action 1",pIntent)
                                .addAction(R.mipmap.ic_launcher,"Action 2",pIntent)
                                .setContentIntent(pIntent).getNotification();

                        noti.flags = Notification.FLAG_AUTO_CANCEL;
                        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                        nm.notify(0,noti);
                    }
                }
        );
    }

    public void addServicesButtonListener(){
        servicesButton = (Button)findViewById(R.id.button_services);
        servicesButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.myapplication1.ServicesActivity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void addInternalStorageButtonListener(){
        internalStorageButton = (Button)findViewById(R.id.button_internalStorage);
        internalStorageButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.myapplication1.InternalStorageActivity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void addDbButtonListener(){
        dbButton = (Button)findViewById(R.id.button_db);
        dbButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.myapplication1.DbActivity");
                        startActivity(intent);
                    }
                }
        );
    }






}
