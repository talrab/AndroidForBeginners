package com.example.myapplication1;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DbActivity extends AppCompatActivity {

    DataBaseHelper myDb;
    EditText editName, editSurname, editMarks;
    Button addDataButton;
    Button viewAllButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        myDb = new DataBaseHelper(this);

        editName = (EditText)findViewById(R.id.editText_name);
        editSurname = (EditText)findViewById(R.id.editText_surname);
        editMarks = (EditText)findViewById(R.id.editText_marks);
        addDataButton = (Button)findViewById(R.id.button_addData);
        viewAllButton = (Button)findViewById(R.id.button_viewAll);

        addData();
        viewAll();
        
    }

    public void addData(){
        addDataButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editSurname.getText().toString(),
                                editMarks.getText().toString());
                        if (isInserted){
                            Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Data Not Inserted",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    public void viewAll(){
        viewAllButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0){
                            showMessage("Error", "No Data Found");
                            return;
                        }
                        else{
                            StringBuffer buffer = new StringBuffer();
                            while (res.moveToNext()){
                                buffer.append("Id :" + res.getString(0) + "\n");
                                buffer.append("Name :" + res.getString(1) + "\n");
                                buffer.append("Surname :" + res.getString(2) + "\n");
                                buffer.append("Marks :" + res.getString(3) + "\n\n");
                            }

                            showMessage("Data", buffer.toString());
                        }
                    }
                }
        );
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
        }
}
