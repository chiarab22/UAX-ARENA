package com.example.android.uax_arena;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Presentation extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

    }
    public void exit (View view){
        intent = new Intent(Presentation.this, MainActivity.class);
        startActivity(intent);
    }


    public void menu (View view){
        intent = new Intent(Presentation.this, Menu.class);
        startActivity(intent);

    }
}
