package com.example.zeilinger.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView character_point_text_output;
    private int point_total;
    private int STR, DEX, CON, INT, WIS, CHA;
    private boolean random_rolled = false;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    Intent myintent = new Intent(Main2Activity.this,MainActivity.class);
                    startActivity(myintent);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_points);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    //refresh instance
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        point_total = 27;

        mTextMessage = (TextView) findViewById(R.id.message);
        character_point_text_output = (TextView) findViewById(R.id.character_point_text);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mTextMessage.setText(getString(R.string.point_buy_counter,"27"));
        character_point_text_output.setText(getString(R.string.point_buy_output,
                Integer.toString(STR),Integer.toString(DEX),Integer.toString(CON),
                Integer.toString(INT),Integer.toString(WIS),Integer.toString(CHA)));
    }


    // buttons to increase or decrease score
    public void raise_clicked(View view){

    }

    public void clear_clicked(View view){
        if(random_rolled){
            random_rolled = false;
            mTextMessage.setText(getString(R.string.point_buy_counter,"27"));
            character_point_text_output.setText(getString(R.string.point_buy_output,
                    Integer.toString(STR),Integer.toString(DEX),Integer.toString(CON),
                    Integer.toString(INT),Integer.toString(WIS),Integer.toString(CHA)));
        }



    }

    public void lower_clicked(View view){

    }



    // roll for stats button
    public void rollstats(View view) {
        mTextMessage.setText("point buy not used, press x to clear");
        character_point_text_output.setText(getString(R.string.point_buy_output,
                roll_stat(),roll_stat(),roll_stat(),
                roll_stat(),roll_stat(),roll_stat()));
        random_rolled = true;
    }

    // simulate rolling 4 six sided dice, then remove the lowest roll
    public String roll_stat() {
        Random rand = new Random();
        int[] rolls = new int[4];
        int total = 0;
        int droped_roll = 6;

        for(int i = 0; i<= 3; i++){
            rolls[i] = rand.nextInt(6) + 1;;
        }

        for(int i = 0; i<= 3; i++){
            droped_roll = Math.min(droped_roll, rolls[i]);
            total += rolls[i];
        }

        return Integer.toString(total - droped_roll);
    }

}
