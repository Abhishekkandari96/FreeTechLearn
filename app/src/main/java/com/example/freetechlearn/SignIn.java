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
import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {
    private EditText editTextTextPassword;
    private EditText useremail;
    private EditText username;
    private Button signbutton;
    private EditText name;
    private EditText phone;
    private FirebaseAuth auth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username = findViewById(R.id.unique);
        useremail = findViewById(R.id.signin);
        editTextTextPassword = findViewById((R.id.editTextTextPassword));
        signbutton = findViewById(R.id.submit_button);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);

        auth=FirebaseAuth.getInstance();

        // clik listener on sign button
        signbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = useremail.getText().toString();
                String password1 = editTextTextPassword.getText().toString();
                String name1=name.getText().toString();
                String mobile=phone.getText().toString();
                String userU=username.getText().toString();


                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password1)||TextUtils.isEmpty(name1)||TextUtils.isEmpty(mobile)||TextUtils.isEmpty(userU)) {
                    Toast.makeText(SignIn.this, "fields are empty", Toast.LENGTH_SHORT).show();
                } else {

                    auth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(SignIn.this,new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                rootNode=FirebaseDatabase.getInstance();
                                reference=rootNode.getReference("users");
                                UserHelperClass helperClass=new UserHelperClass(email,name1,password1,mobile,userU);

                                reference.child(userU).setValue(helperClass);
                                Toast.makeText(SignIn.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                                Intent login=new Intent(SignIn.this,LogIn.class);
                                startActivity(login);
                            }
                            else{
                                Toast.makeText(SignIn.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });

    }


}