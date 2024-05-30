package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonExercise extends AppCompatActivity {

    Button btnToast;
    Button disappear;


//    public ButtonExercise(RelativeLayout relativeLayout) {
//        this.relativeLayout = relativeLayout;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);

        btnToast = findViewById(R.id.btn_toast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonExercise.this, "Hala ka unsa ni", Toast.LENGTH_SHORT).show();
            }
        });

        Button changeButtonBg = (Button) findViewById(R.id.btn_changeButtonBg);
        int[] colors = {getResources().getColor(R.color.changeBgBlue), getResources().getColor(R.color.black), getResources().getColor(R.color.teal_200),
                getResources().getColor(R.color.changeBgBrown),getResources().getColor(R.color.changeBgGreen)};
        final int[] currentColorIndex = {0};

        changeButtonBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change background color to the next color in the array
                changeButtonBg.setBackgroundColor(colors[currentColorIndex[0]]);

                // Update currentColorIndex to point to the next color in the array
                currentColorIndex[0] = (currentColorIndex[0] + 1) % colors.length;
            }
        });


        Button changeBg = (Button) findViewById(R.id.btn_changeBg);
        final int[] currentAppColorIndex = {0};
        changeBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().getDecorView().setBackgroundColor(colors[currentAppColorIndex[0]]);
                // Update currentAppColorIndex to point to the next color in the array
                currentAppColorIndex[0] = (currentAppColorIndex[0] + 1) % colors.length;
            }
        });

        disappear=findViewById(R.id.btn_dissappear);
        disappear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disappear.setVisibility(View.INVISIBLE);
            }
        });

        Button sirado = (Button) findViewById(R.id.button_close);
        sirado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ButtonExercise.this,Close.class);
                startActivity(intent);
            }
        });
    }
}