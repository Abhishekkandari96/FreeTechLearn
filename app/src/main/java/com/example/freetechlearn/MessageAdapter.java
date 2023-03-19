package com.example.freetechlearn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder>{

    List<Message> messageList;
    public MessageAdapter(List<Message> messageList) {
        this.messageList=messageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chatView= LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,null);
        MyViewHolder myViewHolder=new MyViewHolder(chatView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Message message=messageList.get(position);
        if(message.getSentBy().equals(Message.SENT_BY_ME)){
            holder.botside.setVisibility(View.GONE);
            holder.userside.setVisibility(View.VISIBLE);
            holder.userreply.setText(message.getMessage());
        }else{
            holder.botside.setVisibility(View.VISIBLE);
            holder.userside.setVisibility(View.GONE);
            holder.botreply.setText(message.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
 LinearLayout botside;
 LinearLayout userside;
 TextView  botreply;
 TextView userreply;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            botside=itemView.findViewById(R.id.botside);
            userside=itemView.findViewById(R.id.userside);
            botreply=itemView.findViewById(R.id.botreply);
            userreply=itemView.findViewById(R.id.userreply);


        }
    }
}
