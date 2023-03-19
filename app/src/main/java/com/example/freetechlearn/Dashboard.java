package com.example.freetechlearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dashboard extends AppCompatActivity {

    ImageView logout;
    ImageView editprofile;
    ImageView java;
    ImageView html;
    TextView name;

    ImageView help;
    ImageView project;


    String usernameFromDatbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        String username=getIntent().getStringExtra("Keyusername");
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    usernameFromDatbase = snapshot.child(username).child("name").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                usernameFromDatbase= "data is null";
            }
        });


        String screen="hello "+usernameFromDatbase;

        name=findViewById(R.id.profilepic);

        name.setText(screen);
        // for log out
        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Dashboard.this, "Thanks For Using", Toast.LENGTH_SHORT).show();
                Intent login=new Intent(Dashboard.this,LogIn.class);
                startActivity(login);
            }
        });
        // for edit
        editprofile=findViewById(R.id.editprofile);
        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edit=new Intent(Dashboard.this,Editprofile.class);
                edit.putExtra("Keyusername" ,username);
                startActivity(edit);
            }
        });
        // for java
        java=findViewById(R.id.java);
        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent java=new Intent(Dashboard.this,LearnJava.class);
                java.putExtra("Keyusername" ,username);
                startActivity(java);
            }
        });

        //for html
        html=findViewById(R.id.html);
        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent html=new Intent(Dashboard.this,LearnHtml.class);
                html.putExtra("Keyusername" ,username);
                startActivity(html);

            }
        });

        //for chatbot
        help=findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent help=new Intent(Dashboard.this,Help.class);
                help.putExtra("Keyusername" ,username);
                startActivity(help);
            }
        });

        //for project
        project=findViewById(R.id.project);
        project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent project=new Intent(Dashboard.this,LearnProjects.class);
                project.putExtra("Keyusername" ,username);
                startActivity(project);
            }
        });



    }
}