package com.androidclass.harmonyhost;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class Login extends AppCompatActivity {
    EditText emaiET;
    EditText passwordET;
    Button buttonLogin;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        awesomeValidation = new AwesomeValidation(BASIC);

        emaiET= findViewById(R.id.loginEmailET);
        passwordET=findViewById(R.id.loginPasswordET);
        buttonLogin=findViewById(R.id.loginButtonB);

        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{1,}";
        awesomeValidation.addValidation(Login.this, R.id.loginEmailET, android.util.Patterns.EMAIL_ADDRESS, R.string.err_email);
        awesomeValidation.addValidation(Login.this, R.id.loginPasswordET,regexPassword,R.string.err_pass);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(emaiET.getText().toString()) || TextUtils.isEmpty(passwordET.getText().toString()) ){
                    Toast.makeText(Login.this, "fields cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if(awesomeValidation.validate()) {
                    //get user input to strings

                    String emailValidate= emaiET.getText().toString();
                    String passwordValidate=passwordET.getText().toString();

                    Intent registerRegIntent = new Intent(Login.this, Home.class);
                    startActivity(registerRegIntent);

                }
                else{
                    //if email incorrect display invalid
                    Toast.makeText(getApplicationContext(), "invalid inputs", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}