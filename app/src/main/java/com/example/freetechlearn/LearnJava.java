package com.example.freetechlearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class LearnJava extends AppCompatActivity {
    RecyclerView recyclerview;
    ArrayList<JavaData> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_java);
        recyclerview=findViewById(R.id.recycler_java);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setHasFixedSize(true);
        arrayList=new ArrayList<>();


        JavaData javaData1=new JavaData("https://www.youtube.com/watch?v=xk4_1vDrzzo");
        arrayList.add(javaData1);
        JavaData javaData2=new JavaData("https://www.youtube.com/watch?v=-TkoO8Z07hI");
        arrayList.add(javaData2);
        JavaData javaData3=new JavaData("https://www.youtube.com/watch?v=XKHEtdqhLK8");
        arrayList.add(javaData3);



          JavaAdapter javaAdapter=new JavaAdapter(arrayList,getApplicationContext());
          recyclerview.setAdapter(javaAdapter);


    }
}