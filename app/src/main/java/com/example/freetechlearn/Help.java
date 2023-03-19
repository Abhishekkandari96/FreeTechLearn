package com.example.freetechlearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Help extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView welcomeText;
    EditText messageEditText;
    ImageButton sendbutton;
    List<Message> messageList;

    MessageAdapter messageAdapter;
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        messageList=new ArrayList<>();

        recyclerView=findViewById(R.id.Recycler_helpbot);

        welcomeText=findViewById(R.id.welcome_text);

        messageEditText=findViewById(R.id.messege);

        sendbutton=findViewById(R.id.sendbutton);

        //setup recycler view
        messageAdapter=new MessageAdapter(messageList);
        recyclerView.setAdapter(messageAdapter);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setStackFromEnd(true);
        recyclerView.setLayoutManager(llm);

        //using lambda
        sendbutton.setOnClickListener((v)->{

            String question=messageEditText.getText().toString().trim();
            addToChat(question,Message.SENT_BY_ME);
            messageEditText.setText("");
            callAPI(question);
            welcomeText.setVisibility(View.GONE);

        });

 }
    void addToChat(String message, String sentBy){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageList.add(new Message(message,sentBy));
                messageAdapter.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(messageAdapter.getItemCount());
            }
        });

    }
    void addRespose(String response){
        messageList.remove(messageList.size()-1);  ///////changed
        addToChat(response,Message.SENT_BY_BOT);
    }
    void callAPI(String question){
        //okhttp
        messageList.add(new Message("Typing....",Message.SENT_BY_BOT));
        JSONObject jsonBody=new JSONObject();
        try {
            jsonBody.put("model","text-davinci-003");
            jsonBody.put("prompt",question);
            jsonBody.put("max_tokens",4000);
            jsonBody.put("temperature",0);
        } catch (JSONException e) {
            e.printStackTrace();                                                //can be
        }
        RequestBody body=RequestBody.create(jsonBody.toString(),JSON);
        Request request=new Request.Builder()
        .url("https://api.openai.com/v1/completions")
                .header("Authorization","Bearer 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")
                .post(body)
                .build();
        //
        Call call =client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                addRespose("Failed to load response due to "+e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    try(ResponseBody responseBody=response.body()) {
                        if(response.isSuccessful()){
                    JSONObject jsonObject= null;
                    try {
                        jsonObject = new JSONObject(response.body().string());
                        JSONArray jsonArray=jsonObject.getJSONArray("choices");
                        String result=jsonArray.getJSONObject(0).getString("text");
                        addRespose(result.trim());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }else{
                    addRespose("Failed to Load due to "+response.body().string());
                }
                    }
            }
        });


        //


//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                addRespose("Failed to load response due to "+e.getMessage());
//            }
//
//            @Override
//            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                if(response.isSuccessful()){          // if(response.isSuccessful())
//                    JSONObject jsonObject= null;
//                    try {
//                        jsonObject = new JSONObject(response.body().toString());
//                        JSONArray jsonArray=jsonObject.getJSONArray("choices");
//                        String result=jsonArray.getJSONObject(0).getString("text");
//                        addRespose(result.trim());
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//
//                }else{
//                    addRespose("Failed to Load due to "+response.body().string());
//                }
//            }
//        });

    }
}