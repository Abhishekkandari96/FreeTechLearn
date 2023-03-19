package com.example.freetechlearn;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectViewHolder> {

    ArrayList<ProjectData> arrayList;
    Context context;

    public ProjectAdapter(ArrayList<ProjectData> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.video_per_rowproject,parent,false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        ProjectData current= arrayList.get(position);
        ProjectViewHolder.webView.loadUrl(current.getLink());
        ProjectViewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, VideoFullScreenProject.class);
                i.putExtra("link",current.getLink());
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
