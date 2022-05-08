package com.gachon.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Schedule2Activity extends AppCompatActivity {

    // Changes
    private long baseTime,pauseTime;
    public static final int INIT=0;
    public static final int RUN=1;
    public static final int PAUSE=2;
    public static int status=INIT;
    private TextView clock;
    private Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_schdule);
        clock = findViewById(R.id.Clock);
        startBtn = findViewById(R.id.start_btn);
        baseTime= SystemClock.elapsedRealtime();//time check
        startBtn.setOnClickListener(onClickListener);
        //image button
        ImageButton Block = findViewById(R.id.Block);
        Block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, 101);
                overridePendingTransition(0, 0);
            }
        });
        ImageButton Friends = findViewById(R.id.Friends);
        Block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FriendActivity.class);
                startActivityForResult(intent, 101);
                overridePendingTransition(0, 0);
            }
        });
        ImageButton Graph = findViewById(R.id.Graph);
        Graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GraphActivity.class);
                startActivityForResult(intent, 101);
                overridePendingTransition(0, 0);
            }
        });
        //text for button
        TextView txtGraph = findViewById(R.id.textGraph);
        txtGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GraphActivity.class);
                startActivityForResult(intent, 101);
                overridePendingTransition(0, 0);
            }
        });
        TextView txtOption = findViewById(R.id.textFriends);
        txtOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FriendActivity.class);
                startActivityForResult(intent, 101);
                overridePendingTransition(0, 0);
            }
        });
        TextView txtBlock = findViewById(R.id.textBlock);
        txtBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, 101);
                overridePendingTransition(0, 0);
            }
        });
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            staButton();
        }
    };
    public void staButton(){
        switch (status){
            case INIT:
                baseTime =SystemClock.elapsedRealtime();
                handler.sendEmptyMessage(0);
                pauseTime=SystemClock.elapsedRealtime();
                startBtn.setText("멈춤2");
                status=RUN;
                break;
            case RUN:
                handler.removeMessages(0);
                startBtn.setText("시작");
                pauseTime = SystemClock.elapsedRealtime();
                clock.setText("00:00:00");
                status=INIT;
                break;

        }
    }
    public String getTime(){
        //time check
        long nowtime=SystemClock.elapsedRealtime();
        long overtime= nowtime-baseTime;
        SimpleDateFormat format= new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String recTime =format.format(overtime);
        return recTime;
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg){
            clock.setText(getTime());
            handler.sendEmptyMessage(0);
        }
    };
}
