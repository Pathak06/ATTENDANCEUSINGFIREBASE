package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button admin,student,faculty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        admin = (Button) findViewById(R.id.idadmin);
        student = (Button) findViewById(R.id.idstudent);
        faculty = (Button) findViewById(R.id.idfaculty);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, AdminLogin.class);
                startActivity(intent);
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, StudentSignup.class);
                startActivity(intent);
            }
        });
        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, FacultySignup.class);
                startActivity(intent);
            }
        });
    }
}
