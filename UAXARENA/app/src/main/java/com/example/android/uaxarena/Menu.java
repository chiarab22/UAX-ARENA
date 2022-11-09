package com.example.android.uaxarena;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Menu extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public  void presentation (View view){
        intent = new Intent(Menu.this, Presentation.class);
        startActivity(intent);
    }

    public  void playGame(View view){
        // jugar al juego

    }

    public void charactersGame(View view){
        intent  = new Intent(Menu.this, Characters.class);
        startActivity(intent);

    }

    public void exit(View view){
        intent = new Intent(Menu.this, MainActivity.class);
        startActivity(intent);

    }
}
