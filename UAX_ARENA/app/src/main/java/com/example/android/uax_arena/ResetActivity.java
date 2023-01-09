package com.example.android.uax_arena;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetActivity extends AppCompatActivity {
    TextView email;
    EditText pass, repass;
    Button btnconfirm;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        email = (TextView) findViewById(R.id.email_extra);
        pass = (EditText) findViewById(R.id.new_password);
        repass = (EditText) findViewById(R.id.new_repassword);
        btnconfirm = (Button) findViewById(R.id.confirmar);
        DB  = new DBHelper(this);

        Intent intent = getIntent();
        email.setText(intent.getStringExtra("email"));

        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = email.getText().toString();
                String password = pass.getText().toString();
                String repassword = repass.getText().toString();

                if(password.equals(repassword)) {
                    Boolean checkPassUpdate = DB.updatepassword(mail, password);
                    if (checkPassUpdate == true) {
                        Intent intent = new Intent(ResetActivity.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(ResetActivity.this, "Password uptated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ResetActivity.this, "Password not updated", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ResetActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
