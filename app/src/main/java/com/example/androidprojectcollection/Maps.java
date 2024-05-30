package com.example.androidprojectcollection;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Maps extends AppCompatActivity {
    private ImageButton imgbtnMoal,imgbtnLam,imgbtnPanag,imgbtnKawa,imgbtnCancalanog;

    private TextView Title;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        imgbtnMoal = findViewById(R.id.imgbtnMoal);
        imgbtnLam = findViewById(R.id.imgbtnLambug);
        imgbtnPanag= findViewById(R.id.imgbtnPanagsama);
        imgbtnKawa = findViewById(R.id.imgbtnKawasan);
        imgbtnCancalanog= findViewById(R.id.imgbtnKancalanog);
        Title = findViewById(R.id.Title);

        imgbtnMoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getWindow().setBackgroundDrawableResource(R.drawable.panagsamabg);

                imgbtnPanag.setAlpha((float) 0.3);
                imgbtnLam.setAlpha((float) 0.3);
                imgbtnKawa.setAlpha((float) 0.3);
                imgbtnCancalanog.setAlpha((float) 0.3);
                imgbtnMoal.setAlpha((float) 1.0);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:9.974244,123.371972"));
                startActivity(intent);

                String[] titles = getResources().getStringArray(R.array.titles);
                Title.setText(titles[0]);
            }
        });

        imgbtnLam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setBackgroundDrawableResource(R.drawable.lambugbg);

                imgbtnPanag.setAlpha((float) 0.3);
                imgbtnMoal.setAlpha((float) 0.3);
                imgbtnKawa.setAlpha((float) 0.3);
                imgbtnCancalanog.setAlpha((float) 0.3);
                imgbtnLam.setAlpha((float) 1.0);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:9.854108, 123.368255"));
                startActivity(intent);

                String[] titles = getResources().getStringArray(R.array.titles);
                Title.setText(titles[1]);
            }
        });

        imgbtnPanag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setBackgroundDrawableResource(R.drawable.panagsamabg);

                imgbtnMoal.setAlpha((float) 0.3);
                imgbtnLam.setAlpha((float) 0.3);
                imgbtnKawa.setAlpha((float) 0.3);
                imgbtnCancalanog.setAlpha((float) 0.3);
                imgbtnPanag.setAlpha((float) 1.0);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:9.946614, 123.368549"));
                startActivity(intent);

                String[] titles = getResources().getStringArray(R.array.titles);
                Title.setText(titles[2]);
            }
        });

        imgbtnKawa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setBackgroundDrawableResource(R.drawable.kawasanbg);

                imgbtnPanag.setAlpha((float) 0.3);
                imgbtnLam.setAlpha((float) 0.3);
                imgbtnMoal.setAlpha((float) 0.3);
                imgbtnCancalanog.setAlpha((float) 0.3);
                imgbtnKawa.setAlpha((float) 1.0);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:9.803716, 123.374356"));
                startActivity(intent);

                String[] titles = getResources().getStringArray(R.array.titles);
                Title.setText(titles[3]);
            }
        });

        imgbtnCancalanog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setBackgroundDrawableResource(R.drawable.kancalanogbg);

                imgbtnPanag.setAlpha((float) 0.3);
                imgbtnLam.setAlpha((float) 0.3);
                imgbtnKawa.setAlpha((float) 0.3);
                imgbtnCancalanog.setAlpha((float) 1.0);
                imgbtnMoal.setAlpha((float) 0.3);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:9.772716,123.380725"));
                startActivity(intent);

                String[] titles = getResources().getStringArray(R.array.titles);
                Title.setText(titles[4]);
            }
        });
    }
}