package com.tech.eyeq.capitalloans;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class LoanRequirementsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_requirements);
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
