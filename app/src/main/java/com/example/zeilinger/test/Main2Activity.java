package com.example.zeilinger.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView character_point_text_output;
    private RadioGroup stat_select_group;
    private int point_total = 27;
    public int STRval = 1, DEXval = 1, CONval = 1, INTval = 1, WISval = 1, CHAval = 1;
    public int STR = 8, DEX = 8, CON= 8, INT= 8, WIS= 8 , CHA = 8;
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
        stat_select_group = (RadioGroup) findViewById(R.id.stat_select_group);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        update_text();
    }


    // buttons to increase or decrease score
    public void raise_clicked(View view){
        Toast.makeText(Main2Activity.this,
                Integer.toString(stat_select_group.getCheckedRadioButtonId()), Toast.LENGTH_SHORT).show();
        switch (stat_select_group.getCheckedRadioButtonId()) {
            case R.id.radioSTR:
                if ( point_total >= 1 && STRval <= 5 ){
                    STRval++;
                    point_total -= 1;
                STR = 8 + (STRval - 1);
            }
            else if ( point_total >= 2 && STRval <= 7 ){
                    STRval++;
                    point_total -= 2;
                    STR = 8 + (STRval - 1);
                }
                Toast.makeText(Main2Activity.this,
                        "you selected STR", Toast.LENGTH_SHORT).show();
                break;


            case R.id.radioDEX:
                if ( point_total >= 1 && DEXval <= 5 ){
                    DEXval++;
                    point_total -= 1;
                    DEX = 8 + (DEXval - 1);
                }
                else if ( point_total >= 2 && DEXval <= 7 ){
                    DEXval++;
                    point_total -= 2;
                    DEX = 8 + (DEXval - 1);
                }
                Toast.makeText(Main2Activity.this,
                        "you selected DEX", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioCON:
                if ( point_total >= 1 && CONval <= 5 ){
                    CONval++;
                    point_total -= 1;
                    CON = 8 + (CONval - 1);
                }
                else if ( point_total >= 2 && CONval <= 7 ){
                    CONval++;
                    point_total -= 2;
                    CON = 8 + (CONval - 1);
                }
                Toast.makeText(Main2Activity.this,
                        "you selected CON", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioINT:
                if ( point_total >= 1 && INTval <= 5 ){
                    INTval++;
                    point_total -= 1;
                    INT = 8 + (INTval - 1);
                }
                else if ( point_total >= 2 && INTval <= 7 ){
                    INTval++;
                    point_total -= 2;
                    INT = 8 + (INTval - 1);
                }
                Toast.makeText(Main2Activity.this,
                        "you selected INT", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioWIS:
                if ( point_total >= 1 && WISval <= 5 ){
                    WISval++;
                    point_total -= 1;
                    WIS = 8 + (WISval - 1);
                }
                else if ( point_total >= 2 && WISval <= 7 ){
                    WISval++;
                    point_total -= 2;
                    WIS = 8 + (WISval - 1);
                }
                Toast.makeText(Main2Activity.this,
                        "you selected WIS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioCHA:
                if ( point_total >= 1 && CHAval <= 5 ){
                    CHAval++;
                    point_total -= 1;
                    CHA = 8 + (CHAval - 1);
                }
                else if ( point_total >= 2 && CHAval <= 7 ){
                    CHAval++;
                    point_total -= 2;
                    CHA = 8 + (CHAval - 1);
                }
                Toast.makeText(Main2Activity.this,
                        "you selected CHA", Toast.LENGTH_SHORT).show();
                break;
        }
        update_text();

    }

    public void lower_clicked(View view){
        switch (stat_select_group.getCheckedRadioButtonId()) {
            case R.id.radioSTR:

                Toast.makeText(Main2Activity.this,
                        "you selected STR", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioDEX:
                Toast.makeText(Main2Activity.this,
                        "you selected DEX", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioCON:
                Toast.makeText(Main2Activity.this,
                        "you selected CON", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioINT:
                Toast.makeText(Main2Activity.this,
                        "you selected INT", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioWIS:
                Toast.makeText(Main2Activity.this,
                        "you selected WIS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioCHA:
                Toast.makeText(Main2Activity.this,
                        "you selected CHA", Toast.LENGTH_SHORT).show();
                break;
        }
        update_text();
    }

    public void clear_clicked(View view){
        if(random_rolled) {
            random_rolled = false;
        }
            STR = 8; DEX = 8; CON = 8; INT = 8; WIS = 8; CHA = 8;
            STRval = 1; DEXval = 1; CONval = 1; INTval = 1; WISval = 1; CHAval = 1;
            point_total = 27;
            update_text();
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


    // update in point buy situations
    public void update_text(){
        mTextMessage.setText(getString(R.string.point_buy_counter,Integer.toString(point_total)));
        character_point_text_output.setText(getString(R.string.point_buy_output,
                Integer.toString(STR),Integer.toString(DEX),Integer.toString(CON),
                Integer.toString(INT),Integer.toString(WIS),Integer.toString(CHA)));
    }

    public void update_raise_stats(int stat, int statval) {
        if (point_total >= 2 && statval <= 5) {
            statval++;
            point_total -= 1;
            stat = 8 + (statval - 1);
        } else if (point_total >= 4 && statval <= 7) {
            statval++;
            point_total -= 2;
            stat = 8 + (statval - 1);
        }
        update_text();
    }
}
