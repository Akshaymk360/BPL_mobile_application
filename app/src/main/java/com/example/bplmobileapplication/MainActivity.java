package com.example.bplmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b1,b2,completed_matches,view_live_score;
ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button5);
        im=findViewById(R.id.imageView2);
        b2=findViewById(R.id.button3);
        completed_matches=findViewById(R.id.button4);
        view_live_score=findViewById(R.id.button);
        view_live_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlivescoreactivity();
            }
        });
        completed_matches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivityscheduled_matches();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity4();
            }
        });
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity3();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity2();
            }
        });
    }

    public void openactivityscheduled_matches(){
        Intent intent4=new Intent(this,MainActivityCompletedMatches.class);
        startActivity(intent4);
    }
    public void openactivity3(){
        Intent intent1=new Intent(this,MainActivity3.class);
        startActivity(intent1);
    }
    public void openactivity2(){
        Intent intent2=new Intent(this,MainActivity2.class);
        startActivity(intent2);
    }
    public void openactivity4(){
        Intent intent3=new Intent(this,MainActivityScheduled_matches.class);
        startActivity(intent3);
    }
    public void openlivescoreactivity(){
        Intent intent3=new Intent(this,MainActivityLiveScore.class);
        startActivity(intent3);

    }
}