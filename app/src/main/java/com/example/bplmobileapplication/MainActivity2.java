package com.example.bplmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {
ImageView im;
Button b1;
EditText username,password;
TextView msg;
DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("admin_login");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        im=findViewById(R.id.imageView3);
        b1=findViewById(R.id.button2);
        msg=findViewById(R.id.textView21);
        username=findViewById(R.id.editTextTextPersonName);
        password=findViewById(R.id.editTextTextPassword);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivitymain();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        String username1=snapshot.child("username").getValue().toString();
                        String password1=snapshot.child("password").getValue().toString();
                        if(username.getText().toString().equals(username1) &&password.getText().toString().equals(password1) ){
                            Toast.makeText(MainActivity2.this, "login successful", Toast.LENGTH_SHORT).show();
                            msg.setText("");
                            openactivity4();
                        }
                        else{
                            msg.setText("Invalid credentials");
                            Toast.makeText(MainActivity2.this, "login failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        Toast.makeText(MainActivity2.this, "Please check your internet connection and try again ", Toast.LENGTH_SHORT).show();
                        openactivitymain();

                    }
                });

            }
        });
    }
    public void openactivity4(){
        Intent intent1=new Intent(this,MainActivityAdmin.class);
        startActivity(intent1);
    }
    public void openactivitymain(){
        Intent intent2=new Intent(this,MainActivity.class);
        startActivity(intent2);
    }
}