package com.example.math_puzzle;

//import static com.example.math_puzzle.All_ata.no2;

import static com.example.math_puzzle.MainActivity.preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Level_Adapter extends BaseAdapter {
    Puzzle_Second_Page puzzle_second_page;
    //    private ViewGroup parent;
    private int levelno;
    int pageCount;
    private boolean lastlevel;
    private boolean watchscreenon;
    private String levelStatus;


    public Level_Adapter(Puzzle_Second_Page puzzle_second_page, int pageCount) {
        this.puzzle_second_page = puzzle_second_page;
        this.pageCount = pageCount;
    }

    @Override
    public int getCount() {
        return 24;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(puzzle_second_page).inflate(R.layout.puzzle_second_item_page, viewGroup, false);
        TextView textView;
        ImageView tick, lock;
        RelativeLayout relativeLayout;
        textView = view.findViewById(R.id.textno);
        tick = view.findViewById(R.id.tick);
        lock = view.findViewById(R.id.lockno);
        relativeLayout = view.findViewById(R.id.relative);

        if (pageCount == 1) {
            position = position + 24;
        }
        if (pageCount == 2) {
            position = position + 48;
        }
        if (pageCount == 3) {
            position = position + 72;
            if (position >= 75) {
                lock.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
            }
//                    if (position == 72+position) {
//                        lock.setVisibility(View.INVISIBLE);
//                        textView.setText("" + (position + 73));
//                        textView.setVisibility(View.VISIBLE);
//                    }
//
//                    if (levelStatus.equals("win")) {
//                        lock.setVisibility(View.INVISIBLE);
//                        textView.setText("" + (position + 73));
//                        textView.setVisibility(View.VISIBLE);
//                        tick.setVisibility(View.VISIBLE);
//                    }
//
//                    if (levelStatus.equals("skip"))
//                    {
//                        lock.setVisibility(View.INVISIBLE);
//                        textView.setText("" + (position + 73));
//                        textView.setVisibility(View.VISIBLE);
//                    }



        }

        String levelStatus = preferences.getString("levelStatus" + position, "pending");
        levelno = preferences.getInt("lastLevel", -1);
        Log.d("UUU", "position=" + position + "=>" + preferences.getString("levelStatus" + position, "pending"));
        String page = preferences.getString("page", "page1");


        if (position == 0) {

            lock.setVisibility(View.INVISIBLE);
            textView.setText("" + (position + 1));
            textView.setVisibility(View.VISIBLE);
        }

        if (levelStatus.equals("win")) {

            Log.d("UUU", "onClick: levelno=" + levelno + "  position=" + position + "  lrvrl status=" + levelStatus);
            lock.setVisibility(View.INVISIBLE);
            textView.setText("" + (position + 1));
            textView.setVisibility(View.VISIBLE);
            tick.setVisibility(View.VISIBLE);

        }

        if (levelStatus.equals("skip") || levelStatus.equals("win") || position == (levelno + 1)) {
            lock.setVisibility(View.INVISIBLE);
            textView.setText("" + (position + 1));
            textView.setVisibility(View.VISIBLE);
        }

        int finalPosition = position;
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("UUU", "onClick: levelno=" + levelno);
                if (levelStatus.equals("win") || levelStatus.equals("skip") || finalPosition == (levelno + 1)) {
                    Intent intent = new Intent(puzzle_second_page, Continew_Second_Page.class);
                    intent.putExtra("levelNo", finalPosition);
                    puzzle_second_page.startActivity(intent);
                    puzzle_second_page.finish();

                }
            }
        });


        /*if(pageCount==1) {

            if (position == (position+1)) {
                lock.setVisibility(View.INVISIBLE);
                textView.setText("" + (position+1));
                textView.setVisibility(View.VISIBLE);
            }

            if (levelStatus.equals("win")) {
                lock.setVisibility(View.INVISIBLE);
                textView.setText("" + (position+1));
                textView.setVisibility(View.VISIBLE);
                tick.setVisibility(View.VISIBLE);
            }

            if (levelStatus.equals("skip")||(position+25)==(levelno+1)) {
                Log.d("TAG", "getView: Position = "+position+"Level no = "+levelno);
                lock.setVisibility(View.INVISIBLE);
                textView.setText("" + (25+position));
                textView.setVisibility(View.VISIBLE);

            }
        }
        if(pageCount==2) {
            Log.d("YYY", "getView: Page3");
            if (position == 49+position) {
                lock.setVisibility(View.INVISIBLE);
                textView.setText("" + (position + 49));
                textView.setVisibility(View.VISIBLE);
            }

            if (levelStatus.equals("win")) {
                lock.setVisibility(View.INVISIBLE);
                textView.setText("" + (position + 49));
                textView.setVisibility(View.VISIBLE);
                tick.setVisibility(View.VISIBLE);
            }

            if (levelStatus.equals("skip")) {
                lock.setVisibility(View.INVISIBLE);
                textView.setText("" + (position + 49));
                textView.setVisibility(View.VISIBLE);

            }
        }*/

        return view;
    }
}
