package com.example.freetechlearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Retrevedata extends AppCompatActivity {

    private Button show;
    private ListView list;
    private EditText numb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrevedata);
        show = findViewById(R.id.ret_button);
        list = findViewById(R.id.list);
        numb = findViewById(R.id.numb);
        String number=numb.getText().toString();

            show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ArrayList<String> alist = new ArrayList<>();
                    ArrayAdapter adapter = new ArrayAdapter<String>(Retrevedata.this, R.layout.retrevelist, alist);
                    list.setAdapter(adapter);
                    FirebaseDatabase.getInstance().getReference().child("users");
                    Query checkUser= FirebaseDatabase.getInstance().getReference().child("users").orderByChild("phone").equalTo(number);

                    checkUser.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                alist.clear();
                                for( DataSnapshot val:snapshot.getChildren()){

                                    alist.add( "Value is: " + val.toString());
                                }
                                adapter.notifyDataSetChanged();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            });


    }
}