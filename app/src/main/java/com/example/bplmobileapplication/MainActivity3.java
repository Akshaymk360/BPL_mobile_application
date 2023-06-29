package com.example.bplmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    ImageView im1;
    TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        im1=findViewById(R.id.imageView4);
        t1=findViewById(R.id.textView3);
        t2=findViewById(R.id.textView6);
        t3=findViewById(R.id.textView8);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl1("https://akshaymk360.github.io/BPL_Website/");
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl2("https://www.bietdvg.edu/department/UG/CS/home");
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl3("https://www.bietdvg.edu/major_events");
            }
        });
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity1();
            }
        });
    }
    public void openactivity1(){
        Intent intent1=new Intent(this,MainActivity.class);
        startActivity(intent1);
    }
    private void gotourl1(String s1){
        Uri uri1=Uri.parse(s1);
        startActivity( new Intent(Intent.ACTION_VIEW,uri1));
    }

    private void gotourl2(String s2){
        Uri uri2=Uri.parse(s2);
        startActivity( new Intent(Intent.ACTION_VIEW,uri2));
    }
    private void gotourl3(String s3){
        Uri uri3=Uri.parse(s3);
        startActivity( new Intent(Intent.ACTION_VIEW,uri3));
    }
}