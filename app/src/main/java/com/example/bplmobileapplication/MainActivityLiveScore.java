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

public class MainActivityLiveScore extends AppCompatActivity {
    DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("live_score");
    TextView team1score,team2score,team1name,versus1name,toss,anyotherupdates,overs;
    ImageView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_live_score);
        team1score=findViewById(R.id.textView51);
        team2score=findViewById(R.id.textView52);
        team1name=findViewById(R.id.textView38);
        versus1name=findViewById(R.id.textView48);
        toss=findViewById(R.id.textView49);
        overs=findViewById(R.id.textView64);
        anyotherupdates=findViewById(R.id.textView55);
        home=findViewById(R.id.imageView7);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmainactivity();
            }
        });
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String team1s=snapshot.child("t1").getValue().toString();
                team1score.setText(team1s);
                String team2s=snapshot.child("v1").getValue().toString();
                team2score.setText(team2s);
                String team1n=snapshot.child("team1name").getValue().toString();
                team1name.setText(team1n);
                String team2n=snapshot.child("versus1name").getValue().toString();
                versus1name.setText(team2n);
                String Toss=snapshot.child("toss").getValue().toString();
                toss.setText(Toss);
                String anyotherup=snapshot.child("updates").getValue().toString();
                anyotherupdates.setText(anyotherup);
                String over=snapshot.child("ov").getValue().toString();
                overs.setText(over);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

    }
    public void openmainactivity(){
        Intent intent1=new Intent(this,MainActivity.class);
        startActivity(intent1);
    }
}