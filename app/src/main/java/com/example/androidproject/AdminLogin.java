package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidproject.R;

public class AdminLogin extends AppCompatActivity {
    EditText email;
    EditText pass;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        email = (EditText) findViewById(R.id.idemail);
        pass = (EditText) findViewById(R.id.idpass);
        btn = (Button) findViewById(R.id.btnsignin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(email.getText().toString(),pass.getText().toString());

            }
        });


    }

    private void validate(String email,String pass){
        if (email.equals("Admin") && pass.equals("12345")){
            Intent intent = new Intent(AdminLogin.this,Admin2Class.class);
            startActivity(intent);
        }
    }
}
