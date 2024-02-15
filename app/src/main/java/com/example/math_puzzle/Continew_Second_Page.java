package com.example.math_puzzle;

import static com.example.math_puzzle.MainActivity.editor;
import static com.example.math_puzzle.MainActivity.preferences;
import static com.example.math_puzzle.R.drawable.*;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Continew_Second_Page extends AppCompatActivity implements View.OnClickListener {

    TextView AnsTxt, SubmitButton, levelText;
    ImageView delete, skip, hint, levelImg;

    Runnable runnable;
    int levelNo;
    String temp;
    int lastlevel;


    TextView[] b = new TextView[10];
    int imgArr[] = {
            p1, p2,
            p3, p4,
            p5, p6,
            p7, p8,
            p9, p10,
            p11, p12,
            p13, p14,
            p15, p16,
            p17, p18,
            p19, p20,
            p21, p22,
            p23, p24,
            p25, p26,
            p27, p28,
            p29, p30,
            p31, p32,
            p33, p34,
            p35, p36,
            p37, p38,
            p39, p40,
            p41, p42,
            p43, p44,
            p45, p46,
            p47, p48,
            p49, p50,
            p51, p52,
            p53, p54,
            p55, p56,
            p57, p58,
            p59, p60,
            p61, p62,
            p63, p64,
            p65, p66,
            p67, p68,
            p69, p70,
            p71, p72,
            p73, p74,
            p75};
    String ansArray[] = {"10", "25", "6", "14", "128", "7", "50", "1025", "100", "3", "212", "3011", "14", "16", "1", "2", "44", "45", "625", "1","210","220","230","240","250","260","270","280","290","300"};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continew_second_page);

        AnsTxt = findViewById(R.id.ans_text);
        levelImg = findViewById(R.id.img);
        levelText = findViewById(R.id.level_text);
        if (getIntent().getExtras() != null)
        {
            levelNo = getIntent().getIntExtra("levelNo", 0);//1
            Log.d("TTT", "onCreate: level no" + levelNo);
        }
        lastlevel = preferences.getInt("lastLevel", 0);
        Log.d("UUU", "onCreate: LastLevel=" + lastlevel);
        levelImg.setImageResource(imgArr[levelNo]);
        levelText.setText("Level: " + (levelNo + 1));
        delete = findViewById(R.id.del);
        delete.setOnClickListener(this);


        hint=findViewById(R.id.hint);
        hint.setOnClickListener(this);

        skip = findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Dialog dialog = new Dialog(Continew_Second_Page.this);
                dialog.setContentView(R.layout.skip_dialog);
                TextView msg = dialog.findViewById(R.id.textSkip);
                Button okBtn = dialog.findViewById(R.id.btnOk);
                Button cancelBtn = dialog.findViewById(R.id.btnCancel);

                //okBtn.setEnabled(false);

                CountDownTimer timer = new CountDownTimer(0, 1000) {
                    @Override
                    public void onTick(long l) {
                        msg.setText("Time: " + (l / 1000) + "renains to unlock the next level");
                    }

                    @Override
                    public void onFinish() {

                        okBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {


                                Intent intent = new Intent(Continew_Second_Page.this, Continew_Second_Page.class);
                                if (levelNo > lastlevel) // 5>=4
                                {
                                    intent.putExtra("levelNo", (levelNo + 1));
                                    editor.putInt("lastLevel", levelNo);
                                    editor.putString("levelStatus" + levelNo, "skip");
                                    editor.commit();
                                } else {
                                    intent.putExtra("levelNo", (levelNo + 1));
                                }

                                startActivity(intent);
                                finish();
                            }
                        });


                    }
                }.start();
              //  MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Continew_Second_Page.this);
//                builder.setTitle("Skip");
//
//
//                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//
//
//                    }
//
//                });
//
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        builder.setCancelable(true);
//                    }
//                });
//                builder.show();

                dialog.show();
            }
        });


        SubmitButton = findViewById(R.id.submit);
        SubmitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if (AnsTxt.getText().toString().equals(ansArray[levelNo])) {
                    Intent intent = new Intent(Continew_Second_Page.this, Activity_win.class);
                    Log.d("BBB", "onClick: lastLevel=" + lastlevel + " LevelNo=" + levelNo);
                    if (lastlevel <= levelNo) //15<14
                    {
                        intent.putExtra("levelNo", levelNo);
                        editor.putInt("lastLevel", levelNo);
                        editor.putString("levelStatus" + levelNo, "win");
                        editor.commit();
                    } else {
                        intent.putExtra("levelNo", levelNo);//14
                        editor.putString("levelStatus" + levelNo, "win");
                        editor.commit();
                    }
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Continew_Second_Page.this, "Wrong Answer..!", Toast.LENGTH_LONG).show();
                }
            }
        });

        for (int i = 0; i < b.length; i++) {
            int id = getResources().getIdentifier("b" + i, "id", getPackageName());
            b[i] = findViewById(id);
            b[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {
        try {

            if (view.getId() == b[1].getId()) {
                temp = AnsTxt.getText().toString();
                AnsTxt.setText("" + temp + "1");
            }
            if (view.getId() == b[2].getId()) {
                temp = AnsTxt.getText().toString();
                AnsTxt.setText("" + temp + "2");
            }
            if (view.getId() == b[3].getId()) {
                temp = AnsTxt.getText().toString();
                AnsTxt.setText("" + temp + "3");
            }
            if (view.getId() == b[4].getId()) {
                temp = AnsTxt.getText().toString();
                AnsTxt.setText("" + temp + "4");
            }
            if (view.getId() == b[5].getId()) {
                temp = AnsTxt.getText().toString();
                AnsTxt.setText("" + temp + "5");
            }
            if (view.getId() == b[6].getId()) {
                temp = AnsTxt.getText().toString();
                AnsTxt.setText("" + temp + "6");
            }
            if (view.getId() == b[7].getId()) {
                temp = AnsTxt.getText().toString();
                AnsTxt.setText("" + temp + "7");
            }
            if (view.getId() == b[8].getId()) {
                temp = AnsTxt.getText().toString();
                AnsTxt.setText("" + temp + "8");
            }
            if (view.getId() == b[9].getId()) {
                temp = AnsTxt.getText().toString();
                AnsTxt.setText("" + temp + "9");
            }
            if (view.getId() == b[0].getId()) {
                temp = AnsTxt.getText().toString();
                AnsTxt.setText("" + temp + "0");
            }
            if (view.getId() == delete.getId()) {
                temp = temp.substring(0, AnsTxt.getText().toString().length() - 1);
                AnsTxt.setText("" + temp);
            }
        } catch (Exception e) {
            Toast.makeText(this, "Wrong!!!", Toast.LENGTH_SHORT).show();
        }
    }
}