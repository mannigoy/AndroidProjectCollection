package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1;

    Button btn3;
    Button btn4;
    Button passing,maps,match_3,menu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.layoutbutton);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, InstagramPage.class);
                startActivity(intent1);
            }
        });



        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, ButtonExercise.class);
                startActivity(intent3);
            }
        });

        btn4=(Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, Calculator.class);
                startActivity(intent3);
            }
        });
        passing=(Button) findViewById(R.id.btn_passing);
        passing.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity.this, Passing_Intents_Exercise.class);
                startActivity(intent4);
            }
        });
        maps=(Button) findViewById(R.id.btnMenu);
        maps.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, Maps.class);
                startActivity(intent3);
            }
        });

        match_3=(Button) findViewById(R.id.match3btn);
        match_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent5 = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent5);
            }
        });
        menu=(Button) findViewById(R.id.buttonMenuMenu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent5 = new Intent(MainActivity.this,menu_exercise.class);
                startActivity(intent5);
            }
        });
    }
}