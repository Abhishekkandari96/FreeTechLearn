package com.example.freetechlearn;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JavaAdapter extends RecyclerView.Adapter<JavaViewHolder> {

    ArrayList<JavaData> arrayList;
    Context context;

    public JavaAdapter(ArrayList<JavaData> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public JavaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.video_per_row,parent,false);
        return new JavaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JavaViewHolder holder, int position) {
        JavaData current= arrayList.get(position);
        JavaViewHolder.webView.loadUrl(current.getLink());
        JavaViewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,VideoFullscreen.class);
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
