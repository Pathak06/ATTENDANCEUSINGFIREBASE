package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentSignup extends AppCompatActivity {

    EditText name,email,phone,password,id;
    Button btnsignup;
    TextView txtsignin;
    DatabaseReference databaseReference;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_signup);

        name = (EditText) findViewById(R.id.idname);
        email = (EditText) findViewById(R.id.idemail);
        id = (EditText) findViewById(R.id.idstuid);
        password = (EditText) findViewById(R.id.idpass);
        phone = (EditText) findViewById(R.id.idphone);
        btnsignup = (Button) findViewById(R.id.btnsignup);
        txtsignin  = (TextView) findViewById(R.id.txtsignin);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Student");

        txtsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentSignup.this,StudentLogin.class);
                startActivity(intent);
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String stu_id = id.getText().toString();
                final String stu_name = name.getText().toString();
                final String stu_email = email.getText().toString();
                final String stu_pass = password.getText().toString();
                final String stu_phone = phone.getText().toString();


                if (TextUtils.isEmpty(stu_name)){
                    Toast.makeText(StudentSignup.this,"Please Enter a name",Toast.LENGTH_SHORT).show();
                }
                if (!stu_name.matches("[a-zA-Z ]+")){
                    Toast.makeText(StudentSignup.this,"Please Enter a valid name",Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(stu_id)){
                    Toast.makeText(StudentSignup.this,"Please Enter ID",Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(stu_email)){
                    Toast.makeText(StudentSignup.this,"Please Enter an Email",Toast.LENGTH_SHORT).show();
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(stu_email).matches()){
                    Toast.makeText(StudentSignup.this,"Please Enter a valid Email!!!",Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(stu_pass)){
                    Toast.makeText(StudentSignup.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
                }

                if (stu_pass.length()<6){
                    Toast.makeText(StudentSignup.this,"Please Enter a password of length greater than 6",Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(stu_phone)){
                    Toast.makeText(StudentSignup.this,"Please Enter Phone No.",Toast.LENGTH_SHORT).show();
                }
                if (!stu_phone.matches("[0-9]{10}+")){
                    Toast.makeText(StudentSignup.this,"Please Enter a valid Phone Number",Toast.LENGTH_SHORT).show();
                }

                firebaseAuth.createUserWithEmailAndPassword(stu_email,stu_pass).addOnCompleteListener(StudentSignup.this, new OnCompleteListener<AuthResult>() {


                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            User information = new User(stu_email,stu_id,stu_name,stu_pass,stu_phone);

                            FirebaseDatabase.getInstance().getReference("Student").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(information)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(StudentSignup.this,"Resistration Successful",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(StudentSignup.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    }
                });

            }
        });
    }
}

