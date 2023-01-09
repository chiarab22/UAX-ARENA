package com.example.android.uax_arena;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class Password  extends AppCompatActivity {

   private EditText email;
   private Button reset;
   private DBHelper DB;
   Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = (EditText) findViewById(R.id.mail_reset);
        reset = (Button) findViewById(R.id.reset);
        DB = new DBHelper(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                Boolean checkuser = DB.checkEmail(mail);

                if(checkuser){
                    intent = new Intent(Password.this, ResetActivity.class);
                    intent.putExtra("email",mail);
                    startActivity(intent);
                }else{
                    Toast.makeText(Password.this, "Mail does not exists", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
