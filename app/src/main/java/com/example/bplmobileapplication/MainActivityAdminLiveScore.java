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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityAdminLiveScore extends AppCompatActivity {
EditText team1score,team1name,team2name,toss,team2score,anyotherupdates,overs;
TextView team1s;
Button update;
ImageView home;
    DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("live_score");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin_live_score);
        team1score=findViewById(R.id.editTextTextPersonName2);
        team1name=findViewById(R.id.editTextTextPersonName3);
        team2name=findViewById(R.id.editTextTextPersonName4);
        toss=findViewById(R.id.editTextTextPersonName5);
        overs=findViewById(R.id.editTextTextPersonName8);
        home=findViewById(R.id.imageView8);
        team2score=findViewById(R.id.editTextTextPersonName7);
        anyotherupdates=findViewById(R.id.editTextTextPersonName6);
        update=findViewById(R.id.button7);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmainactivity();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t1s=team1score.getText().toString();
                if(!(t1s.equals(""))) {
                    reference1.child("t1").setValue(t1s);
                }
                String t1n=team1name.getText().toString();
                if(!(t1n.equals(""))) {
                    reference1.child("team1name").setValue(t1n);
                }
                String t2n=team2name.getText().toString();
                if(!(t2n.equals(""))) {
                    reference1.child("versus1name").setValue(t2n);
                }
                String tos=toss.getText().toString();
                if(!(tos.equals(""))) {
                    reference1.child("toss").setValue(tos);
                }
                String t2s=team2score.getText().toString();
                if(!(t2s.equals(""))) {
                    reference1.child("v1").setValue(t2s);
                }
                String over=overs.getText().toString();
                if(!(over.equals(""))) {
                    reference1.child("ov").setValue(over);
                }
                String anyotherup1=anyotherupdates.getText().toString();
                if(!(anyotherup1.equals(""))) {
                    reference1.child("updates").setValue(anyotherup1);
                }
                Toast.makeText(MainActivityAdminLiveScore.this, "successfully updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void openmainactivity(){
        Intent intent1=new Intent(this,MainActivity.class);
        startActivity(intent1);
    }
}