---
description: Aquí veremos la lógica de la aplicación Android y sus partes más señaladas
---

# Cómo lo hemos construido

Para empezar tuvimos que seguir las diferentes pantallas que necesitábamos implementar y componerlas con las cajas o contenedores pertinentes para ser lo más fieles a lo que nuestro cliente quiere.

A parte de satisfacer el cliente la aplicación está dispuesta para ser fiel a su operatividad principal y cumplir los requisitos propuestos.

Ahora veremos una breve explicación de las pantallas, en las cuáles tenemos las funciones de la aplicación.

* Log In&#x20;
* Registro
* Contraseña Olvidada
* Inicio
* Personajes
* Jugar

A cada una de las pantallas se le ha dado la posibilidad de ir a la anterior y en el pantallas de juego cuando nuestro usuario no le interese jugar más podrá hacer una desconexión de su cuenta gracias al botón de Log Out.

Antes de empezar a desarrollar las distintas actividades, hemos partido de un diseño básico desarrollado en Figma, como el que hemos visto precedentemente.&#x20;

## ACTIVITIES

### main\_activity

Esta activity representa la activity principal en donde el usuario puede loguearse, modificar contraseña y crear un nuevo usuario. Todas esas acciones llevan a su correspondiente activity. Esta activity está asociada a una clase Java que se llama MainActivity en donde explicamos la lógica.

```java
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
    private Intent intent;
    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB = new DBHelper(this);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

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

        entry_button = (Button) findViewById(R.id.button);
        entry_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mail = email.getText().toString();
                String pass = password.getText().toString();

                if (email.equals("") || pass.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkMailPassword(mail, pass);
                    if (checkuserpass == true) {
                        Toast.makeText(MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Menu.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}
```

Esta es la aparencia de la actividad principal:

<figure><img src=".gitbook/assets/lol1.png" alt=""><figcaption><p>activity_main.xml</p></figcaption></figure>

### activity\_registration

Esta actividad representa la creación de una nueva cuenta de usuario, utilizando una base en local (DBHelper, SQLiteDatabase). Esta activity está asociada a una clase Java llamada Registration.&#x20;

```java
package com.example.android.uax_arena;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText email, password, repassword;
    Button registrar;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        registrar = (Button) findViewById(R.id.registrar);
        DB = new DBHelper(this);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = email.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(Registration.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkEmail(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(Registration.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Registration.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Registration.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Registration.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                } }
        });
    }
}





```

Esta es la aparencia de la actividad:

<figure><img src=".gitbook/assets/lol2.png" alt=""><figcaption><p>registration_activity.xml</p></figcaption></figure>

Tanto como el login, registro de usuario y el cambio de contraseña hemos utilizado una base de datos.&#x20;



