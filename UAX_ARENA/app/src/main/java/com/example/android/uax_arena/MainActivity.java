package com.example.android.uax_arena;

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
    private Button register_button;
    private Button password_button;
    private Button forgot_password;
    private Intent intent;
    private DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        register_button = (Button) findViewById(R.id.registro);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }
        });

        password_button = (Button) findViewById(R.id.contr);
        password_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Password.class);
                startActivity(intent);
            }
        });

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        entry_button = (Button) findViewById(R.id.button);
        entry_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = email.getText().toString();
                String pass = password.getText().toString();
                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean check = DB.checkMailPassword(user, pass);
                    if (check == true) {
                        Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                        intent = new Intent(getApplicationContext(), Menu.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "LOGIN DENIED", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


        forgot_password = (Button) findViewById(R.id.contr);
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), Password.class);
                startActivity(intent);
            }
        });

    }

}