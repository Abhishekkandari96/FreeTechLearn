package com.example.freetechlearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class LearnHtml extends AppCompatActivity {
    RecyclerView recyclerview;
    ArrayList<HtmlData> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_html);

        recyclerview=findViewById(R.id.recycler_html);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setHasFixedSize(true);
        arrayList=new ArrayList<>();


        HtmlData htmlData1=new HtmlData("https://www.youtube.com/watch?v=FqmB-Zj2-PA");
        arrayList.add(htmlData1);
        HtmlData htmlData2=new HtmlData("https://www.youtube.com/watch?v=G3e-cpL7ofc");
        arrayList.add(htmlData2);
        HtmlData htmlData3=new HtmlData("https://www.youtube.com/watch?v=8dWL3wF_OMw");
        arrayList.add(htmlData3);



        HtmlAdapter  htmlAdapter=new HtmlAdapter (arrayList,getApplicationContext());
        recyclerview.setAdapter(htmlAdapter);

    }
}