package com.example.medapollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button login, register;
    CheckBox loginState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginbtn);
        loginState = findViewById(R.id.loggedinoption);
        register= findViewById(R.id.registerbtn);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { login();

            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, register.class));
                finish();
            }
        });
    }

    private void login() {
        EditText email=findViewById(R.id.email);
        EditText password=findViewById(R.id.password);

        String smail=email.getText().toString();
        String spassword=password.getText().toString();

        if(smail.length()==0)
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
        if(spassword.length()==0)
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();

        finish();

    }
}