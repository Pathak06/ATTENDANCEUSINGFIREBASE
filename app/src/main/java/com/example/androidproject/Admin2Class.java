package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin2Class extends AppCompatActivity {

    Button s_database;
    Button f_database;
    Button sendsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2_class);

        s_database = (Button) findViewById(R.id.idstudentdatabase);
        f_database = (Button) findViewById(R.id.idfacultydatabase);
        sendsms = (Button) findViewById(R.id.idsms);

        s_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin2Class.this,Retrieve.class);
                startActivity(intent);
            }
        });

        f_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin2Class.this,Facultyretrieve.class);
                startActivity(intent);
            }
        });

        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin2Class.this,SMS.class);
                startActivity(intent);
            }
        });

    }
}
