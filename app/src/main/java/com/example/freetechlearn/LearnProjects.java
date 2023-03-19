package com.example.freetechlearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class LearnProjects extends AppCompatActivity {

    RecyclerView recyclerview;
    ArrayList<ProjectData> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_projects);

        recyclerview=findViewById(R.id.recycler_project);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setHasFixedSize(true);// doubt
        arrayList=new ArrayList<>();

        ProjectData projectData1=new ProjectData("https://www.youtube.com/watch?v=FHTbsZEJspU");
        arrayList.add(projectData1);
        ProjectData projectData2=new ProjectData("https://www.youtube.com/watch?v=2FeymQoKvrk");
        arrayList.add(projectData2);
        ProjectData projectData3=new ProjectData("https://www.youtube.com/watch?v=BDCT6TYLYdI");
        arrayList.add(projectData3);
        ProjectData projectData4=new ProjectData("https://www.youtube.com/watch?v=ugCN_gynFYw");
        arrayList.add(projectData4);

        ProjectAdapter  projectAdapter=new ProjectAdapter (arrayList,getApplicationContext());
        recyclerview.setAdapter(projectAdapter);
    }
}