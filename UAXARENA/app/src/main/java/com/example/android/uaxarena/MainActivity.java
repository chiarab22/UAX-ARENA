package com.example.android.uaxarena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button entry_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         email = (EditText) findViewById(R.id.email);
         password = (EditText) findViewById(R.id.password);

         entry_button = (Button) findViewById(R.id.button);
         entry_button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(email.getText().toString().equals("example@example.com") && password.getText().toString().equals("example")){
                     Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                     Intent intent= new Intent(MainActivity.this, Menu.class);
                     startActivity(intent);
                }else{
                     Toast.makeText(MainActivity.this, "Login denied", Toast.LENGTH_LONG).show();
                }
             }
         });
    }

}