package com.example.android.uax_arena;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Characters extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);

    }

    public void exit (View view){
        intent = new Intent(Characters.this, MainActivity.class);
        startActivity(intent);
    }

}

