package com.example.bplmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityAdmin extends AppCompatActivity {
Button logout,update_livescore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        logout=findViewById(R.id.button6);
        update_livescore=findViewById(R.id.button8);
        update_livescore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openadminlivescore();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmainactivity();
            }
        });

    }
    public void openmainactivity(){
        Intent intent1=new Intent(this,MainActivity.class);
        startActivity(intent1);
    }
    public void openadminlivescore(){
        Intent intent2=new Intent(this,MainActivityAdminLiveScore.class);
        startActivity(intent2);
    }
}