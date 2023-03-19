package com.example.freetechlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openRegister(View view){
        Toast.makeText(this, "Register", Toast.LENGTH_SHORT).show();
        Intent registerwindow=new Intent(this,SignIn.class) ;
        startActivity(registerwindow);
    }
    public void openLogIn(View view){
        Toast.makeText(this, "LogIn", Toast.LENGTH_SHORT).show();
        Intent loginwindow=new Intent(this,LogIn.class) ;
        startActivity(loginwindow);
    }
}