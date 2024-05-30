package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Passing_Intents_Exercise extends AppCompatActivity {
        EditText firstName,lastName, Bday, Number, email, address, city, postal,id, emergency;
        RadioButton rmale,rfmale,rothers;
        Button btnclear,btnsubmit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);
        firstName=findViewById(R.id.txtFirstName);
        lastName=findViewById(R.id.txtLastname);
        Bday=findViewById(R.id.txtPI2Bday);
        Number=findViewById(R.id.txtNumber);
        email=findViewById(R.id.txtEmail);
        address=findViewById(R.id.txtAddress);
        city=findViewById(R.id.txtCity);
        postal=findViewById(R.id.txtPostal);
        id=findViewById(R.id.txtID);
        emergency=findViewById(R.id.txtENumber);
        rmale=findViewById(R.id.radMale);
        rfmale=findViewById(R.id.radFemale);
        rothers=findViewById(R.id.radOthers);
        btnclear=findViewById(R.id.btnClearIntent);
        btnsubmit=findViewById(R.id.btnSub);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fName = firstName.getText().toString();
                String lName = lastName.getText().toString();
                String gender;
                if(rmale.isChecked())
                    gender ="Male";
                 else if (rfmale.isChecked())
                    gender ="Female";
                 else if (rothers.isChecked())
                     gender= "Others";
        else
                gender = "Unknown";
                String bDate = Bday.getText().toString();
                String pNumber = Number.getText().toString();
                String Email = email.getText().toString();
                String Address =address.getText().toString();
                String City = city.getText().toString();
                String Postal = postal.getText().toString();
                String Id = id.getText().toString();
                String Emergency =emergency.getText().toString();
                Intent intent = new Intent( Passing_Intents_Exercise. this, Passing_Intents_Exercise2.class);
                intent.putExtra(  "fname_key", fName);
                intent.putExtra(  "Iname_key", lName);
                intent.putExtra(  "gender_key", gender);
                intent.putExtra(  "pnum_key", pNumber);

                intent.putExtra( "bdate_key", bDate);
                intent.putExtra( "eadd_key",Email);

                intent.putExtra(  "pi2address_key", Address);
                intent.putExtra(  "pi2city_key", City);
                intent.putExtra(  "pi2postal_key", Postal);
                intent.putExtra(  "pi2id_key", Id);

                intent.putExtra( "pi2emergency_key", Emergency);

//                String pi2address = intent.getStringExtra("pi2address_key");
//                String pi2city = intent.getStringExtra(  "pi2city_key");
//                String pi2postal = intent.getStringExtra( "pi2postal_key");
//                String pi2id = intent.getStringExtra(  "pi2id_key");
//                String pi2emergency= intent.getStringExtra( "pi2emergency_key");



                startActivity(intent);



            }

        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName.setText(" ");
                lastName.setText(" ");
                Bday.setText(" ");
                Number.setText(" ");
                email.setText(" ");
                address.setText(" ");
                city.setText(" ");
                postal.setText(" ");
                id.setText(" ");
                emergency.setText(" ");
            }
        });
    }

}