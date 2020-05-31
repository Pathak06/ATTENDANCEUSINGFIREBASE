package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;


public class StudentLogin extends AppCompatActivity {

    EditText email,password;
    Button btnsignin;
    TextView txtsignup,forgotpwd;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        email = (EditText) findViewById(R.id.idemail);
        password = (EditText) findViewById(R.id.idpass);
        btnsignin = (Button) findViewById(R.id.btnsignin);
        txtsignup = (TextView) findViewById(R.id.txtsignup);
        forgotpwd = (TextView) findViewById(R.id.idforgot);

        firebaseAuth = FirebaseAuth.getInstance();


        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StudentLogin.this, StudentSignup.class);
                startActivity(i);
                finish();
            }
        });


        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent = new Intent(StudentLogin.this,Main2Activity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(StudentLogin.this,"Sorry!!! Login is not successful!!!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        forgotpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentLogin.this,ForgotPass.class);
                startActivity(intent);
            }
        });
    }

}
