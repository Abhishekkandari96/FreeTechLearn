package com.example.freetechlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread=new Thread(){
            public void run(){
                try{

                    //delay
                    sleep(7000);
                }
                catch(Exception e){
                    //exception handle
                    e.printStackTrace();
                }
                finally{
                    Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);

                }
            }
        };thread.start();
    }
}