package com.example.myapplication1;

import android.gesture.GestureOverlayView;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.MotionEvent;
import android.gesture.Gesture;
import android.widget.TextView;
import static android.view.GestureDetector.*;

public class GesturesActivity extends AppCompatActivity implements OnGestureListener, OnDoubleTapListener{

    static TextView textView;
    GestureDetectorCompat gestureDetect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);

        textView = (TextView)findViewById(R.id.textView);
        gestureDetect = new GestureDetectorCompat(this,(OnGestureListener)this);
        gestureDetect.setOnDoubleTapListener(this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetect.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        textView.setText("onSingleTapConfirmed\n\n" + e.toString());
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        textView.setText("onDoubleTap\n\n" + e.toString());
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        textView.setText("onDoubleTapEvent\n\n" + e.toString());
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        textView.setText("onDown\n\n" + e.toString());
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        textView.setText("onShowPress\n\n" + e.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        textView.setText("onSingleTapUp\n\n" + e.toString());
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        textView.setText("onScroll\n\n" + e1.toString() + e2.toString());
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        textView.setText("onLongPress\n\n" + e.toString());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        textView.setText("onFling\n\n" + e1.toString() + e2.toString());
        return false;
    }
}
