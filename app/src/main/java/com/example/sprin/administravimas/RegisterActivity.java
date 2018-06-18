package com.example.sprin.administravimas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

        EditText username;
        EditText password;

        EditText email;
        Button register;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            username = (EditText) findViewById(R.id.username);
            password = (EditText) findViewById(R.id.password);
            email = (EditText) findViewById(R.id.email);

            register = (Button)findViewById(R.id.register);
            register.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View arg0) {

                    if(!Validation.isValidCredentials(username.getText().toString())){
                        Toast.makeText(getApplicationContext(),
                                "Netinkamas username arba password", Toast.LENGTH_LONG).show();
                    }else if(!Validation.isValidCredentials(password.getText().toString())){
                        Toast.makeText(getApplicationContext(),
                                "Netinkamas username arba password", Toast.LENGTH_LONG).show();
                    }else if(!Validation.isValidEmail(email.getText().toString())){
                        Toast.makeText(getApplicationContext(),
                                "Netinkamai ivestas email", Toast.LENGTH_LONG).show();
                    }else{// validated

                        Database database = new Database(getApplicationContext());

                        User userToSQLite = new User("1",
                                username.getText().toString(),
                                password.getText().toString(),
                                email.getText().toString());
                        database.addUser(userToSQLite);
                        List<User> useriai = database.getAllUsers();
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    }

            }
        }
    }

