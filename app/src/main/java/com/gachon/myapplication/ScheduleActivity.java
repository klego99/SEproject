package com.gachon.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleActivity extends AppCompatActivity {

    // Changes
    private TextView clock;
    private Button startBtn;
    private Button resetBtn;
    TextView hourT;
    TextView minuteT;
    TextView secondT;
    TextView finishment;
    EditText hourE;
    EditText minuteE;
    EditText secondE;
    LinearLayout linearLayoutTV;
    LinearLayout linearLayoutET;
    int hour,minute, second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_schdule);
        startBtn = findViewById(R.id.start_btn);
        resetBtn = findViewById(R.id.reset_btn);
        hourT=findViewById(R.id.hour);
        minuteT=findViewById(R.id.minute);
        secondT=findViewById(R.id.second);
        hourE=findViewById(R.id.hourE);
        minuteE=findViewById(R.id.minuteE);
        secondE=findViewById(R.id.secondE);
        linearLayoutTV=findViewById(R.id.timerTV);
        linearLayoutET=findViewById(R.id.timerET);
        finishment=findViewById(R.id.finish);
        Timer timer= new Timer();
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutET.setVisibility(View.GONE);
                linearLayoutTV.setVisibility(View.VISIBLE);

               hourT.setText(hourE.getText().toString());
               minuteT.setText(minuteE.getText().toString());
               secondT.setText(secondE.getText().toString());

               hour=Integer.parseInt(hourE.getText().toString());
               minute=Integer.parseInt(minuteE.getText().toString());
               second=Integer.parseInt(secondE.getText().toString());

                TimerTask timerTask= new TimerTask() {
                    @Override
                    public void run() {
                        timerSetting(timer);
                    }
                };
                timer.schedule(timerTask,0,1000);
            }

        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
            }
        });
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
    public void timerSetting(Timer timer){

        if(second!=0){
            second--;
        }
        else if(minute !=0){
            second=60;
            second--;
            minute--;
        }else if(hour !=0){
            second= 60;
            minute=60;
            second--;
            minute--;
            hour--;
        }

        if(second<=9){
            handler.sendEmptyMessage(0);
        }else{
            handler2.sendEmptyMessage(0);
        }

        if(minute<=9){
            mhandler.sendEmptyMessage(0);
        }else{
            mhandler2.sendEmptyMessage(0);
        }

        if(hour<=9){
            hhandler.sendEmptyMessage(0);
        }else{
            hhandler2.sendEmptyMessage(0);
        }

        if(hour==0&&minute==0&&second==0){
            timer.cancel();
            Log.i("timer","finish");
            finishment.setText("종료되었습니다.");
        }
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg){
            secondT.setText("0"+second);
            handler.sendEmptyMessage(0);
        }
    };
    Handler handler2 = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg){
            secondT.setText(Integer.toString(second));
            handler.sendEmptyMessage(0);
        }
    };
    Handler mhandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg){
            minuteT.setText("0"+minute);
            handler.sendEmptyMessage(0);
        }
    };
    Handler mhandler2 = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg){
            minuteT.setText(Integer.toString(minute));
            handler.sendEmptyMessage(0);
        }
    };
    Handler hhandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg){
            hourT.setText("0"+hour);
            handler.sendEmptyMessage(0);
        }
    };
    Handler hhandler2 = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg){
            hourT.setText(Integer.toString(hour));
            handler.sendEmptyMessage(0);
        }
    };

}

