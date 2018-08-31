package com.tech.eyeq.capitalloans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        /*View variable declaration*/
        Button signup_to_home = findViewById(R.id.signup_to_home);

        /*Perform action on signUp button onClick*/
        signup_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, HomeActivity.class));
            }
        });
    }
}
