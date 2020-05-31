package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPass extends AppCompatActivity {

    EditText userEmail;
    Button passreset;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        userEmail = (EditText) findViewById(R.id.idforgotemail);
        passreset = (Button) findViewById(R.id.idsendpass);
        firebaseAuth = FirebaseAuth.getInstance();

        passreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.sendPasswordResetEmail(userEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(ForgotPass.this,"Password sent to your Email",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(ForgotPass.this,"Sorry!!! Email id of this name doesn't exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
