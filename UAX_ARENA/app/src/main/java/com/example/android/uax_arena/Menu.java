package com.example.android.uax_arena;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    private Intent intent;
    Button jugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        jugar = (Button) findViewById(R.id.jugar);

        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this, Juego.class);
                startActivity(intent);
            }
        });

    }

    public  void presentation (View view){
        intent = new Intent(Menu.this, Presentation.class);
        startActivity(intent);
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

