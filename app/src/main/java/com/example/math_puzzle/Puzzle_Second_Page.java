package com.example.math_puzzle;

import static com.example.math_puzzle.All_Data.pageCount;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

public class Puzzle_Second_Page extends Activity implements View.OnClickListener {
    GridView gridView;
    ImageView back,next;
    Level_Adapter adapter;
    int cnt=0;
    private int i;
    private int levelno;

    RelativeLayout relativeLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_second_page);
        gridView=findViewById(R.id.grid_view);
        levelno=getIntent().getIntExtra("levelNo",0);

        if(pageCount==0)
        {
            adapter = new Level_Adapter(Puzzle_Second_Page.this,pageCount);
            gridView.setAdapter(adapter);
        }

        next=findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pageCount++;
                if (pageCount==1)
                {
                    adapter = new Level_Adapter(Puzzle_Second_Page.this, pageCount);
                    gridView.setAdapter(adapter);
                    back.setVisibility(View.VISIBLE);

                }
                if (pageCount==2)
                {
                    adapter=new Level_Adapter(Puzzle_Second_Page.this, pageCount);
                    gridView.setAdapter(adapter);

                }
                if (pageCount==3)
                {
                    adapter=new Level_Adapter(Puzzle_Second_Page.this, pageCount);
                    gridView.setAdapter(adapter);
                    next.setVisibility(View.INVISIBLE);
                }

            }
        });

        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pageCount--;
                if(pageCount==0)
                {
                    adapter=new Level_Adapter(Puzzle_Second_Page.this, pageCount);
                    gridView.setAdapter(adapter);
                    back.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.VISIBLE);
                }
                if (pageCount==1)
                {
                    adapter=new Level_Adapter(Puzzle_Second_Page.this, pageCount);
                    gridView.setAdapter(adapter);
                    next.setVisibility(View.VISIBLE);
                }
                if (pageCount==2)
                {
                    adapter=new Level_Adapter(Puzzle_Second_Page.this, pageCount);
                    gridView.setAdapter(adapter);
                    next.setVisibility(View.VISIBLE);

                }
                if (pageCount==3)
                {
                    adapter=new Level_Adapter(Puzzle_Second_Page.this,pageCount);
                    gridView.setAdapter(adapter);
                    next.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}

