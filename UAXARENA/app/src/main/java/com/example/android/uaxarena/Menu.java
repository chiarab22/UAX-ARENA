package com.example.android.uaxarena;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void menu (View view){

    }

    public  void playGame(View view){

    }

    public void charactersGame(View view){

    }

    public void out(View view){
        Intent intentO = new Intent(Menu.this, MainActivity.class);
        startActivity(intentO);

    }
}
