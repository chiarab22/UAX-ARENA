package com.example.android.uax_arena;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    DBHelper dbHelper;
    EditText email, password;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signup = (Button) findViewById(R.id.signup);
        dbHelper = new DBHelper(this);
        String user = email.getText().toString();
        String pass = password.getText().toString();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(Registration.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuser = dbHelper.checkEmail(user);
                    if (checkuser == false) {
                        Boolean insert = dbHelper.insertData(user, pass);
                        if (insert == true) {
                            Toast.makeText(Registration.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Registration.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Registration.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}





