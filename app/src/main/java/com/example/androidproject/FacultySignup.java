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

public class FacultySignup extends AppCompatActivity {

    EditText name,email,phone,password,id;
    Button btnsignup;
    TextView txtsignin;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_signup);

        name = (EditText) findViewById(R.id.idname);
        email = (EditText) findViewById(R.id.idemail);
        id = (EditText) findViewById(R.id.idfacid);
        password = (EditText) findViewById(R.id.idpass);
        phone = (EditText) findViewById(R.id.idphone);
        btnsignup = (Button) findViewById(R.id.btnsignup);
        txtsignin  = (TextView) findViewById(R.id.txtsignin);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Faculty");

        txtsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacultySignup.this,FacultyLogin.class);
                startActivity(intent);
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fac_id = id.getText().toString();
                final String fac_name = name.getText().toString();
                final String fac_email = email.getText().toString();
                 final String fac_pass = password.getText().toString();
                 final String fac_phone = phone.getText().toString();


                 if (TextUtils.isEmpty(fac_id)){
                     Toast.makeText(FacultySignup.this,"Please Enter an id",Toast.LENGTH_SHORT).show();
                 }
                if (TextUtils.isEmpty(fac_name)){
                    Toast.makeText(FacultySignup.this,"Please Enter a name",Toast.LENGTH_SHORT).show();
                }
                if (!fac_name.matches("[a-zA-Z ]+")){
                    Toast.makeText(FacultySignup.this,"Please Enter a valid name",Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(fac_email)){
                    Toast.makeText(FacultySignup.this,"Please Enter an Email",Toast.LENGTH_SHORT).show();
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(fac_email).matches()){
                    Toast.makeText(FacultySignup.this,"Please Enter a valid Email!!!",Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(fac_pass)){
                    Toast.makeText(FacultySignup.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
                }

                if (fac_pass.length()<6){
                    Toast.makeText(FacultySignup.this,"Please Enter a password of length greater than 6",Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(fac_phone)){
                    Toast.makeText(FacultySignup.this,"Please Enter Phone No.",Toast.LENGTH_SHORT).show();
                }
                if (!fac_phone.matches("[0-9]{10}+")){
                    Toast.makeText(FacultySignup.this,"Please Enter a valid Phone Number",Toast.LENGTH_SHORT).show();
                }

                firebaseAuth.createUserWithEmailAndPassword(fac_email,fac_pass).addOnCompleteListener(FacultySignup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            FacultyUser information = new FacultyUser(fac_email,fac_id,fac_name,fac_pass,fac_phone);

                            FirebaseDatabase.getInstance().getReference("Faculty").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(information)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(FacultySignup.this,"Resistration Successful",Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(FacultySignup.this, Retrieve.class);
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
