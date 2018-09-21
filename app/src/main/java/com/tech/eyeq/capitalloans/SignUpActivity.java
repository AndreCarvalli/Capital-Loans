package com.tech.eyeq.capitalloans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.tech.eyeq.capitalloans.config.SharedPrefManager;

public class SignUpActivity extends AppCompatActivity {

    EditText editTextName, editTextDOB, editTextPhone, editTextPassword, editTextPasswordRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Start Main Activity if user is logged in
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, HomeActivity.class));
        }

        editTextName = findViewById(R.id.signup_fullname);
        editTextDOB = findViewById(R.id.signup_dob);
        editTextPhone = findViewById(R.id.signup_phone);
        editTextPassword = findViewById(R.id.signup_password);
        editTextPasswordRepeat = findViewById(R.id.signup_password_repeat);

        /*Perform action on signUp button onClick*/
        findViewById(R.id.signup_to_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSignUp();
            }
        });
    }

    public void userSignUp(){

        final String fullName = editTextName.getText().toString().trim();
        final String dob = editTextDOB.getText().toString().trim();
        final String phone = editTextPhone.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        final String passwordRepeat = editTextPasswordRepeat.getText().toString().trim();

        if (TextUtils.isEmpty(fullName)) {
            editTextName.setError("Please enter Full Name");
            editTextName.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(dob)) {
            editTextDOB.setError("Please enter DOB");
            editTextDOB.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(phone)) {
            editTextPhone.setError("Please enter Phone Number");
            editTextPhone.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(password)) {
            editTextPassword.setError("Please enter Password");
            editTextPassword.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(passwordRepeat)) {
            editTextPasswordRepeat.setError("Please enter Password");
            editTextPasswordRepeat.requestFocus();
            return;
        }

        if (!TextUtils.isEmpty(password) && !TextUtils.isEmpty(passwordRepeat)) {
            if(!password.equals(passwordRepeat)) {
                editTextPasswordRepeat.setError("Passwords Do Not Match");
                editTextPasswordRepeat.requestFocus();
            }
        }
    }
}
