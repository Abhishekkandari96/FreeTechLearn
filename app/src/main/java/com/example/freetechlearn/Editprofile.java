package com.example.freetechlearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class Editprofile extends AppCompatActivity {

    EditText nameIp;
    EditText usernameIp;
    EditText phoneNo;
    Button retreve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        retreve=findViewById(R.id.retreve);
        nameIp=findViewById(R.id.name_edittext);
        usernameIp=findViewById(R.id.username_edittext);
        phoneNo=findViewById(R.id.phone_edittext);

        retreve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewdata=new Intent(Editprofile.this,Retrevedata.class) ;
                startActivity(viewdata);
            }
        });

    }
}