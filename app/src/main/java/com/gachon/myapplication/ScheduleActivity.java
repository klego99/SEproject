package com.gachon.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleActivity extends AppCompatActivity {

    // Changes
    private long baseTime,pauseTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_schdule);
        TextView clock = findViewById(R.id.Clock);
        Button startBtn = findViewById(R.id.start_btn);
        Button stopBtn=findViewById(R.id.stop_btn);
        baseTime= SystemClock.elapsedRealtime();//time check
        clock.setText(getTime());
        startBtn.setOnClickListener(onClickListener);
        stopBtn.setOnClickListener(onClickListener);
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
            switch (view.getId()){
                case R.id.start_btn:
                    staButton();
                    break;
                case R.id.stop_btn:
                    stopButton();
                    break;
            }
        }
    };
    public void staButton(){

    }
    public void stopButton(){

    }
    public String getTime(){
        //time check
        long nowtime=SystemClock.elapsedRealtime();
        long overtime= nowtime-baseTime;
        long m =overtime/1000/60;
        long s= (overtime/1000)%60;
        long h=overtime/60;
        String recTime =String.format("%02d:%02:%02d",h,m,s);
        return recTime;
    }
}
