package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Passing_Intents_Exercise2 extends AppCompatActivity {
    TextView tFname,tGender,tLname,tBdate,tEmail,tPnum,taddress, tcity, tpostal,id, temergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);
        tFname = findViewById(R.id.txtPI2Fname);
        tGender=findViewById(R.id.txtPI2Gender);
        tLname = findViewById(R.id.txtPI2Lname);
        tBdate = findViewById(R.id.txtPI2Bday);
        tEmail = findViewById(R.id.txtPI2Email);
        tPnum = findViewById(R.id.txtPINumber);
        taddress= findViewById(R.id.txtPI2Address);
        tcity=findViewById(R.id.txtPI2City);
        tpostal=findViewById(R.id.txtPI2Postal);
        id=findViewById(R.id.txtPI2ID);
        temergency=findViewById(R.id.txtPI2ENumber);

        Intent intent = getIntent();
        String fname = intent.getStringExtra("fname_key");
        String gender = intent.getStringExtra(  "gender_key");
        String pnum = intent.getStringExtra( "pnum_key");
        String lname = intent.getStringExtra(  "Iname_key");
        String bdate = intent.getStringExtra( "bdate_key");
        String email = intent.getStringExtra(  "eadd_key");
        String pi2address = intent.getStringExtra("pi2address_key");
        String pi2city = intent.getStringExtra(  "pi2city_key");
        String pi2postal = intent.getStringExtra( "pi2postal_key");
        String pi2id = intent.getStringExtra(  "pi2id_key");
        String pi2emergency= intent.getStringExtra( "pi2emergency_key");


        tFname.setText(fname);
        tLname.setText(lname);
        tGender.setText(gender);
        tBdate.setText(bdate);
        tPnum.setText(pnum);
        tEmail.setText(email);
        taddress.setText(pi2address);
        tcity.setText(pi2city);
        tpostal.setText(pi2postal);
        id.setText(pi2id);
        temergency.setText(pi2emergency);


    }
}