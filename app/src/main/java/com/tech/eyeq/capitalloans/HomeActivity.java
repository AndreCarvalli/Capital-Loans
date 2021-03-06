package com.tech.eyeq.capitalloans;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.tech.eyeq.capitalloans.config.SharedPrefManager;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Start Main Activity if user is logged in
        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, SplashActivity.class));
        }

        initToolbar();
        homeToLoanApplicationView();
        homeToLoanRequirements();
        homeToAboutUs();
        homeToFaqView();
    }
    /*Handling button presses*/
    public void homeToLoanApplicationView()
    {
        Button btn_home_to_application_activity = findViewById(R.id.btn_application_to_application_page);
        btn_home_to_application_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoanApplicationActivity.class ));
            }
        });
    }

    public void homeToFaqView()
    {
        CardView card_home_to_faq_activity = findViewById(R.id.id_faqs_card);
        card_home_to_faq_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FaqActivity.class ));
            }
        });
    }

    public void homeToLoanRequirements()
    {
        CardView card_home_to_loan_requirements = findViewById(R.id.id_requirements_card);
        card_home_to_loan_requirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoanRequirementsActivity.class ));
            }
        });
    }
    public void homeToAboutUs()
    {
        CardView card_home_to_loan_requirements = findViewById(R.id.id_about_us_card);
        card_home_to_loan_requirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AboutUsActivity.class ));
            }
        });
    }

    //set toolbar method
    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_home);
        toolbar.setNavigationIcon(R.drawable.ic_back_button_light);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Capital Loans");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_basic_with_overflow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
            builder.setTitle("Confirm Logout");
            builder.setMessage("Do you wish to Logout?");
            builder.setCancelable(true);
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                    SharedPrefManager.getInstance(getApplicationContext()).logout();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
