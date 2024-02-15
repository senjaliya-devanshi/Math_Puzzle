package com.example.math_puzzle;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Activity_win extends AppCompatActivity {


    TextView textLevelWin;
    Button btnContinue,btnMain;
    ImageView shareimg;
    int levelNo;
    public static int[] images={R.drawable.share1,R.drawable.share2,R.drawable.share3,R.drawable.share4,
            R.drawable.share5,R.drawable.share6,R.drawable.share7,R.drawable.share8,R.drawable.share9,
            R.drawable.share10,R.drawable.share11,R.drawable.share12,R.drawable.share13,
            R.drawable.share14, R.drawable.share15,R.drawable.share16,R.drawable.share17,R.drawable.share18,
            R.drawable.share19,R.drawable.share20 ,R.drawable.share21,R.drawable.share22,R.drawable.share23,
            R.drawable.share24,R.drawable.share25,R.drawable.share26,R.drawable.share27,R.drawable.share28,
            R.drawable.share29,R.drawable.share30,R.drawable.share31,R.drawable.share32,R.drawable.share33,
            R.drawable.share34,R.drawable.share35,R.drawable.share36,R.drawable.share37,R.drawable.share38,
            R.drawable.share39,R.drawable.share40,R.drawable.share41,R.drawable.share42,R.drawable.share43,
            R.drawable.share44,R.drawable.share45,R.drawable.share46,R.drawable.share47,R.drawable.share48,
            R.drawable.share49, R.drawable.share50,R.drawable.share51,R.drawable.share52,R.drawable.share53,
            R.drawable.share54,R.drawable.share55,R.drawable.share56,R.drawable.share57,R.drawable.share58,
            R.drawable.share59,R.drawable.share60,R.drawable.share61,R.drawable.share62,R.drawable.share63,
            R.drawable.share64,R.drawable.share65,R.drawable.share66,R.drawable.share67,R.drawable.share68,
            R.drawable.share69,R.drawable.share70,R.drawable.share71,R.drawable.share72,R.drawable.share73,
            R.drawable.share74,R.drawable.share75
    };



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        textLevelWin=findViewById(R.id.textLevelWin);
        btnContinue=findViewById(R.id.btnWinContinuew);
        btnMain=findViewById(R.id.btnWinMain);


        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_win.this, Continew_Second_Page.class);
                intent.putExtra("levelNo",(levelNo+1));
                startActivity(intent);
                finish();
            }
        });

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_win.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        shareimg=findViewById(R.id.sharewin);
        shareimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bitmap b = BitmapFactory.decodeResource(getResources(), images[levelNo]);
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("image/jpeg");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                b.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String path = MediaStore.Images.Media.insertImage(getContentResolver(), b, "Title", null);
                Uri imageUri =  Uri.parse(path);
                share.putExtra(Intent.EXTRA_STREAM, imageUri);
                startActivity(Intent.createChooser(share, "Select"));
            }
        });

        levelNo=getIntent().getIntExtra("levelNo",0);
        textLevelWin.setText("Puzzle "+(levelNo+1)+" Completed");
    }

    private static Object getText()
    {
        return null;
    }

//    private class Media {
//        public static String EXTERNAL_CONTENT_URI;
//    }
}
