package com.example.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.SeekableByteChannel;

public class SeekBarActivity extends AppCompatActivity {

    static SeekBar seekBar;
    static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        seekBar();
    }

    public void seekBar(){
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        textView = (TextView)findViewById(R.id.textViewSeekBar);
        textView.setText("Covered: " + seekBar.getProgress() + " / " + seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    int progressValue;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progressValue = progress;
                        textView.setText("Covered: " + progress + " / " + seekBar.getMax());
                        Toast.makeText(SeekBarActivity.this,"SeekBar in progress",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(SeekBarActivity.this,"SeekBar in startTracking",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        //textView.setText("Covered: " + progressValue + " / " + seekBar.getMax());
                        Toast.makeText(SeekBarActivity.this,"SeekBar in stopTracking",Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
