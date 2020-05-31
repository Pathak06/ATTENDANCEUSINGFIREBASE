package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.Inet4Address;
import java.util.ArrayList;

public class Retrieve extends AppCompatActivity {

    ListView listView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        listView = (ListView) findViewById(R.id.listView);



        user = new User();
        final ArrayList<String> list;
        final ArrayAdapter<String> adapter;


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Student");

        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,R.layout.activity_attendanceactivity,R.id.userInfo,list);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){

                    user = ds.getValue(User.class);
                    list.add(user.getId().toString() + " " + user.getName().toString());

                }
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        if (position==0){
                            Intent intent = new Intent(view.getContext(),studentattendance.class);
                            startActivity(intent);
                        }
                        if (position==1){
                            Intent intent = new Intent(view.getContext(),studentattendance.class);
                            startActivity(intent);
                        }
                        if (position==2){
                            Intent intent = new Intent(view.getContext(),studentattendance.class);
                            startActivity(intent);
                        }
                        if (position==3){
                            Intent intent = new Intent(view.getContext(),studentattendance.class);
                            startActivity(intent);
                        }
                        if (position==4){
                            Intent intent = new Intent(view.getContext(),studentattendance.class);
                            startActivity(intent);
                        }
                        if (position==5){
                            Intent intent = new Intent(view.getContext(),studentattendance.class);
                            startActivity(intent);
                        }
                        if (position==6){
                            Intent intent = new Intent(view.getContext(),studentattendance.class);
                            startActivity(intent);
                        }
                        if (position==7){
                            Intent intent = new Intent(view.getContext(),studentattendance.class);
                            startActivity(intent);
                        }
                        if (position==8){
                            Intent intent = new Intent(view.getContext(),studentattendance.class);
                            startActivity(intent);
                        }
                        if (position==9){
                            Intent intent = new Intent(view.getContext(),studentattendance.class);
                            startActivity(intent);
                        }
                        if (position==10){
                            Intent intent = new Intent(view.getContext(),studentattendance.class);
                            startActivity(intent);
                        }

                    }
                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
