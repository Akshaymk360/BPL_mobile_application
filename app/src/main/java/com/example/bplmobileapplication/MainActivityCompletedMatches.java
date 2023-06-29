package com.example.bplmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivityCompletedMatches extends AppCompatActivity {
TextView slno1,slno2,slno3,team11,team12,team13,team21,team22,team23,result1,result2,result3;
ImageView home;
    DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("completed_sl1");
    DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference().child("completed_team1");
    DatabaseReference reference3 = FirebaseDatabase.getInstance().getReference().child("completed_team2");
    DatabaseReference reference4 = FirebaseDatabase.getInstance().getReference().child("result");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_completed_matches);
        slno1=findViewById(R.id.textView31);
        slno2=findViewById(R.id.textView36);
        slno3=findViewById(R.id.textView42);
        team11=findViewById(R.id.textView32);
        team12=findViewById(R.id.textView37);
        team13=findViewById(R.id.textView43);
        team21=findViewById(R.id.textView34);
        team22=findViewById(R.id.textView40);
        team23=findViewById(R.id.textView45);
        result1=findViewById(R.id.textView35);
        result2=findViewById(R.id.textView41);
        result3=findViewById(R.id.textView46);
        home=findViewById(R.id.imageView6);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivitymain();
            }
        });
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String sl1=snapshot.child("1").getValue().toString();
                String sl2=snapshot.child("2").getValue().toString();
                String sl3=snapshot.child("3").getValue().toString();
                slno1.setText(sl1);
                slno2.setText(sl2);
                slno3.setText(sl3);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String t1=snapshot.child("t1").getValue().toString();
                String t2=snapshot.child("t2").getValue().toString();
                String t3=snapshot.child("t3").getValue().toString();
                team11.setText(t1);
                team12.setText(t2);
                team13.setText(t3);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        reference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String v1=snapshot.child("v1").getValue().toString();
                String v2=snapshot.child("v2").getValue().toString();
                String v3=snapshot.child("v3").getValue().toString();
                team21.setText(v1);
                team22.setText(v2);
                team23.setText(v3);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        reference4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String r1=snapshot.child("r1").getValue().toString();
                String r2=snapshot.child("r2").getValue().toString();
                String r3=snapshot.child("r3").getValue().toString();
                result1.setText(r1);
                result2.setText(r2);
                result3.setText(r3);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

    }
    public void openactivitymain(){
        Intent intent1=new Intent(this,MainActivity.class);
        startActivity(intent1);
    }
}