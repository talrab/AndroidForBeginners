package com.example.myapplication1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
    }

    public void changeFragments (View view){
        Fragment fragment;
        if (view == findViewById(R.id.button_fragment1)){
            fragment = new Fragment1();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place,fragment);
            ft.commit();
        }
        if (view == findViewById(R.id.button_fragment2)){
            fragment = new Fragment2();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place,fragment);
            ft.commit();
        }

    }
}
