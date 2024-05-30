package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class menu_exercise extends AppCompatActivity {
    Button btnChanger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);
        btnChanger =findViewById(R.id.btnChanger);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.choice_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NotNull MenuItem item){
        if(item.getItemId() == R.id.mItemChange){
            Toast.makeText(this, "Edit Object item is clicked", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.mItemReset){
            Toast.makeText(this, "Edit Object item is clicked", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.mItemExit){
            finish();

        }
        return true;
    }





}