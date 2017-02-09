package com.example.myapplication1;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {

    static Button switchButton;
    static ImageView image;
    int current_image_index;
    int[]images = {R.mipmap.romi,R.mipmap.noga,R.mipmap.ic_launcher};

    static ListView listView;
    static String[]NAMES = new String[]{"Romi","Noga","Tal","Efrat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        addSwitchButtonListener();
        listView();
    }

    public void addSwitchButtonListener(){
        switchButton = (Button)findViewById(R.id.buttonSwitch);
        image = (ImageView)findViewById(R.id.imageView);
        switchButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        current_image_index++;
                        current_image_index = current_image_index % images.length;
                        image.setImageResource(images[current_image_index]);
                    }
                }
        );

    }

    public void listView(){
        listView = (ListView)findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.name_list,NAMES);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String value = (String)listView.getItemAtPosition(position);
                        Toast.makeText(UserActivity.this,"Position: " + position + " value: " + value,Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
