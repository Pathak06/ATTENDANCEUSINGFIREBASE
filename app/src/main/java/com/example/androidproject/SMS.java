package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMS extends AppCompatActivity {
    EditText phone;
    EditText message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_m_s);
        if (ContextCompat.checkSelfPermission(SMS.this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){

            if (ActivityCompat.shouldShowRequestPermissionRationale(SMS.this, Manifest.permission.SEND_SMS)){
                ActivityCompat.requestPermissions(SMS.this,new String[]{Manifest.permission.SEND_SMS},1);

            }else{
                ActivityCompat.requestPermissions(SMS.this,new String[]{Manifest.permission.SEND_SMS},1);
            }


        }
        else{
            //do nothing
        }
        send = (Button) findViewById(R.id.idsend);
        message = (EditText) findViewById(R.id.idmessage);
        phone = (EditText) findViewById(R.id.idphone);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ph = phone.getText().toString();
                String mes = message.getText().toString();
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(ph,null,mes,null,null);
                    Toast.makeText(SMS.this,"Sent!!",Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(SMS.this,"Failed to send!!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(SMS.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(SMS.this,"Permission Granted",Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(SMS.this,"No Permission Granted!!!",Toast.LENGTH_SHORT).show();
                }
                return;
        }

    }
    
}
