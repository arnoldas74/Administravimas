package com.example.sprin.administravimas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = (Button) findViewById(R.id.login);
        Button btnToregister = (Button) findViewById(R.id.)
        final EditText Username = (EditText) findViewById(R.id.username);
        final EditText Password = (EditText) findViewById(R.id.password);


        Username.setError(null);
        Password.setError(null);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cia vykdomas kodas, kai paspaudziamas mygtukas
                boolean cancel = false;
                if (!Validation.isValidCredentials(Username.getText().toString())) {
                    cancel = true;
                    Username.requestFocus();
                    Username.setError(getResources().getString(R.string.login_invalid_username));
                    //Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_invalid_username),
                    //Toast.LENGTH_SHORT).show();
                } else if (!Validation.isValidCredentials(Password.getText().toString())) {
                    cancel = true;
                    Password.requestFocus();
                    Password.setError(getResources().getString(R.string.login_invalid_password));
                    // Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_invalid_password),
                    // Toast.LENGTH_SHORT).show();
                }
                if (!cancel){
                    Toast.makeText(MainActivity.this,
                            "Prisijungimo vardas: " + Username.getText().toString() + "\n" +
                                    "Slaptažodis: " + Password.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent goToSearchActivity = new Intent(MainActivity.this, AdministrationActivity.class);
                    startActivity(goToSearchActivity);
                }


            }
        });
    }
}
