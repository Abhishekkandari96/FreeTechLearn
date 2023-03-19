package com.example.freetechlearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {
   private EditText loginusername;
   private EditText logpassword;
   private Button logbutton;
   private EditText keyuser;
   private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
          loginusername=findViewById(R.id.loginUsername);
          logpassword=findViewById(R.id.logpassword);;
         logbutton=findViewById(R.id.logbutton);;
         keyuser=findViewById(R.id.unique);;
          auth=FirebaseAuth.getInstance();

        logbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=loginusername.getText().toString();
                String pass=logpassword.getText().toString();
                String key=keyuser.getText().toString();
                if(TextUtils.isEmpty(email)||TextUtils.isEmpty(pass)){
                    Toast.makeText(LogIn.this, "One or both of the above is empty", Toast.LENGTH_SHORT).show();
                }else{
                    login(email,pass,key);
                }
            }
        });

    }
    private void login(String email,String password,String key){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
//                    Toast.makeText(LogIn.this, "Success", Toast.LENGTH_SHORT).show();

                    Intent dashboard=new Intent(LogIn.this,Dashboard.class);
                    dashboard.putExtra("Keyusername" ,key);
                    startActivity(dashboard);

                }else{
                    Toast.makeText(LogIn.this, "Unsuccessfull", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}