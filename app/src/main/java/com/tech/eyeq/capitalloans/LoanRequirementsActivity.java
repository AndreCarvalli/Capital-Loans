package com.tech.eyeq.capitalloans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.tech.eyeq.capitalloans.config.SharedPrefManager;

public class LoanRequirementsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_requirements);

        //Start Main Activity if user is logged in
        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, SplashActivity.class));
        }

        initToolbar();
    }

    //set toolbar method
    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back_button_light);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Loan Requirements (Qualify)");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //actionBar back button code
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
