package com.example.zeilinger.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    EditText sidesPerDice;
    EditText numberOfDice;

    //navigation blocks
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_points);
                    Intent myintent2 = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(myintent2);

                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    Intent myintent3 = new Intent(MainActivity.this,Main3Activity.class);
                    startActivity(myintent3);
                    return true;
            }
            return false;
        }
    };

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }



    //activity logic blocks
    public void rolldice(View view) {
        sidesPerDice = (EditText)findViewById(R.id.sidesPerDice);
        numberOfDice = (EditText)findViewById(R.id.numberOfDice);
        if(sidesPerDice.getText().toString().isEmpty()||numberOfDice.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,
                    "input error", Toast.LENGTH_SHORT).show();
            return;
        }
        int sidesPerDice_int = Integer.parseInt(sidesPerDice.getText().toString());
        int numberOfDice_int = Integer.parseInt(numberOfDice.getText().toString());
        int total = 0;
        while(numberOfDice_int >= 1){
            total += call_rng(sidesPerDice_int);
            numberOfDice_int--;
        }

        Toast.makeText(MainActivity.this,
                Integer.toString(total), Toast.LENGTH_SHORT).show();

    }


    private int call_rng(int max_value){
        Random rand = new Random();
        int output = rand.nextInt(max_value) + 1;
        return output;
    }

}
