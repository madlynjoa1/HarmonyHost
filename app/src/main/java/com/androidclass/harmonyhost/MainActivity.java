package com.androidclass.harmonyhost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button loginLButton;
    public  Button registerLButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginLButton= findViewById(R.id.mainLoginButton);
        registerLButton=findViewById(R.id.mainRegisterButton);

        loginLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //inside here we put from where we start to what activity we continue to
                Intent intent= new Intent(MainActivity.this,GoogleSignIn.class);
                startActivity(intent);
            }
        });

        registerLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(MainActivity.this,Register.class);
                startActivity(regIntent);
            }
        });
    }
}