package com.example.freetechlearn;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freetechlearn.HtmlData;
import com.example.freetechlearn.HtmlViewHolder;
import com.example.freetechlearn.R;
import com.example.freetechlearn.VideoFullscreen;

import java.util.ArrayList;

public class HtmlAdapter  extends RecyclerView.Adapter<HtmlViewHolder> {
    ArrayList<HtmlData> arrayList;
    Context context;

    public HtmlAdapter(ArrayList<HtmlData> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public HtmlViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.video_per_rowhtml,parent,false);
        return new HtmlViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HtmlViewHolder holder, int position) {
        HtmlData current= arrayList.get(position);
        HtmlViewHolder.webView.loadUrl(current.getLink());
        HtmlViewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, VideoFullScreenHtml.class);
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
