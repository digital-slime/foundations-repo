package com.example.zeilinger.test;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private TextView mTextMessage;
    EditText PlaneText;
    EditText Key;
    TextView CypherText;


    //navigation blocks
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    Intent myintent1 = new Intent(Main3Activity.this,MainActivity.class);
                    startActivity(myintent1);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_points);
                    Intent myintent2 = new Intent(Main3Activity.this,Main2Activity.class);
                    startActivity(myintent2);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mTextMessage = findViewById(R.id.message);
        mTextMessage.setText("press button to put text through a Caesar cypher.");


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }

    public void Start_cypher(View view){
        PlaneText =(EditText) findViewById(R.id.planeTextField);
        Key =(EditText) findViewById(R.id.keyField);
        CypherText = (TextView) findViewById(R.id.cypherTextField);
        String plaintext = PlaneText.getText().toString();
        String key = Key.getText().toString();
        String cyphertext = CypherText.getText().toString();



        StringBuffer mod= new StringBuffer();
        for (int i=0; i <= plaintext.length() - 1; i++) {

            int offset = plaintext.length() % key.length();

        }





        StringBuffer result= new StringBuffer();

        for (int i=0; i <= plaintext.length() - 1; i++)
        {
            int s = 3;

            if (Character.isUpperCase(plaintext.charAt(i)))
            {
                char output = (char)(((int)plaintext.charAt(i) + s - 65) % 26 + 65);
                result.append(output);
            }
            else
            {
                char output = (char)(((int)plaintext.charAt(i) + s - 97) % 26 + 97);
                result.append(output);
            }
        }

        CypherText.setText(result);


        Toast.makeText(Main3Activity.this,
                (""), Toast.LENGTH_SHORT).show();





    }

}
