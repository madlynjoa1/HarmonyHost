package com.androidclass.harmonyhost;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class Register extends AppCompatActivity {

    TextView userNameRegister;
    TextView firstNameRegister;
    TextView lastNameRegister;
    TextView dateOfBirthRegister;
    TextView emailRegister;
    TextView passwordRegister;
    TextView confirmPassRegister;
    TextView phoneRegister;
    Button registerButton;


    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        awesomeValidation = new AwesomeValidation(BASIC);

        userNameRegister= findViewById(R.id.usernameETRegister);
        firstNameRegister=findViewById(R.id.firstNameRegisterET);
        lastNameRegister=findViewById(R.id.lastNameRegisterET);
        dateOfBirthRegister=findViewById(R.id.dateOfBirthRegisterET);
        emailRegister=findViewById(R.id.emailRegisterET);
        passwordRegister=findViewById(R.id.passwordETRegisterET);
        confirmPassRegister=findViewById(R.id.confirmPasswordRegisterET);
        registerButton=findViewById(R.id.buttonRegB);
        phoneRegister=findViewById(R.id.phoneET);

        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{1,}";
        awesomeValidation.addValidation(Register.this, R.id.usernameETRegister, "[a-zA-Z\\s]+", R.string.err_name);
        awesomeValidation.addValidation(Register.this, R.id.firstNameRegisterET, "[a-zA-Z\\s]+", R.string.err_name);
        awesomeValidation.addValidation(Register.this, R.id.lastNameRegisterET, "[a-zA-Z\\s]+", R.string.err_name);
        awesomeValidation.addValidation(Register.this, R.id.dateOfBirthRegisterET, "^(0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d$" , R.string.err_dob);
        awesomeValidation.addValidation(Register.this, R.id.emailRegisterET, android.util.Patterns.EMAIL_ADDRESS, R.string.err_email);
        awesomeValidation.addValidation(Register.this, R.id.passwordETRegisterET,regexPassword,R.string.err_pass);
        awesomeValidation.addValidation(Register.this, R.id.confirmPasswordRegisterET,regexPassword,R.string.err_con_pass);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(firstNameRegister.getText().toString()) || TextUtils.isEmpty(phoneRegister.getText().toString()) ||TextUtils.isEmpty(lastNameRegister.getText().toString()) ||
                        TextUtils.isEmpty(emailRegister.getText().toString()) || TextUtils.isEmpty(dateOfBirthRegister.getText().toString()) ||
                        TextUtils.isEmpty(userNameRegister.getText().toString()) || TextUtils.isEmpty(passwordRegister.getText().toString()) ||
                        TextUtils.isEmpty(confirmPassRegister.getText().toString())){
                    Toast.makeText(Register.this, "fields cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if(awesomeValidation.validate()) {
                    //get user input to strings

                    String nameValidate=firstNameRegister.getText().toString();
                    String lnameValidate=lastNameRegister.getText().toString();
                    String userNameValidate=userNameRegister.getText().toString();
                    String emailValidate= emailRegister.getText().toString();
                    String dateValidate= dateOfBirthRegister.getText().toString();
                    String passwordValidate=passwordRegister.getText().toString();
                    String confirmPasswordValidate=confirmPassRegister.getText().toString();

                    if(passwordRegister.getText().toString().equals(confirmPassRegister.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Created", Toast.LENGTH_LONG).show();
                        Intent registerRegIntent = new Intent(Register.this, MainActivity.class);
                        startActivity(registerRegIntent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Password don't match", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    //if email incorrect display invalis
                    Toast.makeText(getApplicationContext(), "invalid inputs", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}