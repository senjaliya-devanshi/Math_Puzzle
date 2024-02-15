package com.example.math_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView cont,puzzle;
    ImageButton btnshare;


   public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;
    int lastlevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        preferences=getSharedPreferences("myPref",MODE_PRIVATE);
        editor= preferences.edit();

        lastlevel=preferences.getInt("lastLevel",-1);
        cont=findViewById(R.id.cont);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Continew_Second_Page.class);
                intent.putExtra("levelNo",(lastlevel+1));//1
                startActivity(intent);
            }
        });

        puzzle=findViewById(R.id.puzzle);
        puzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Puzzle_Second_Page.class);
                startActivity(intent);
            }
        });

        btnshare=findViewById(R.id.btnshare);
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareintent=new Intent(android.content.Intent.ACTION_SEND);
                shareintent.setType("text/plain");
                shareintent.putExtra(android.content.Intent.EXTRA_SUBJECT,"share link");
                String shareMessage="\nLet me recommend you this application\n\n";
               shareMessage=shareMessage+" https://play.google.com/store/apps/details?id=com.applabs.puzzle";
                shareintent.putExtra(Intent.EXTRA_TEXT,shareMessage);
                startActivity(Intent.createChooser(shareintent,"Text"));

            }
        });
    }
}