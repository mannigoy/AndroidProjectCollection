package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Close extends AppCompatActivity {

    Button balik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_close);

        balik = findViewById(R.id.balik);

        balik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent1 =new Intent(Close.this, ButtonExercise.class);
//                startActivity(intent1);
                finish();
            }

        });

    }
}