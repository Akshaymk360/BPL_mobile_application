package com.example.bplmobileapplication;

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

public class MainActivityScheduled_matches extends AppCompatActivity {
TextView tvteam11,tvteam21,tvtime1;
    TextView tvteam12,tvteam22,tvtime2;
    TextView tvteam13,tvteam23,tvtime3;
    ImageView home;
    DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("team1_matches");
    DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference().child("team2_mathes");
    DatabaseReference reference3 = FirebaseDatabase.getInstance().getReference().child("timings");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_scheduled_matches);
        tvteam11=findViewById(R.id.textView9);
        tvteam12=findViewById(R.id.textView13);
        tvteam13=findViewById(R.id.textView17);
        tvteam21=findViewById(R.id.textView11);
        home=findViewById(R.id.imageView5);
        tvteam22=findViewById(R.id.textView15);
        tvteam23=findViewById(R.id.textView19);
        tvtime1=findViewById(R.id.textView12);
        tvtime2=findViewById(R.id.textView16);
        tvtime3=findViewById(R.id.textView20);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivitymain();
            }
        });
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String t1=snapshot.child("t1").getValue().toString();
                String t2=snapshot.child("t2").getValue().toString();
                String t3=snapshot.child("t3").getValue().toString();
                tvteam11.setText(t1);
                tvteam12.setText(t2);
                tvteam13.setText(t3);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MainActivityScheduled_matches.this, "Please check your internet connection and try again", Toast.LENGTH_SHORT).show();

            }
        });
        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String v1=snapshot.child("v1").getValue().toString();
                String v2=snapshot.child("v2").getValue().toString();
                String v3=snapshot.child("v3").getValue().toString();
                tvteam21.setText(v1);
                tvteam22.setText(v2);
                tvteam23.setText(v3);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MainActivityScheduled_matches.this, "Please check your internet connection and try again", Toast.LENGTH_SHORT).show();

            }
        });
        reference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String time1=snapshot.child("time1").getValue().toString();
                String time2=snapshot.child("time2").getValue().toString();
                String time3=snapshot.child("time3").getValue().toString();
                tvtime1.setText(time1);
                tvtime2.setText(time2);
                tvtime3.setText(time3);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MainActivityScheduled_matches.this, "Please check your internet connection and try again", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void openactivitymain(){
        Intent intent1=new Intent(this,MainActivity.class);
        startActivity(intent1);
    }
}