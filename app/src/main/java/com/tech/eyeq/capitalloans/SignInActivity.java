package com.tech.eyeq.capitalloans;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.ClientError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import com.tech.eyeq.capitalloans.config.SharedPrefManager;
import com.tech.eyeq.capitalloans.config.URLs;
import com.tech.eyeq.capitalloans.config.VolleySingleton;
import com.tech.eyeq.capitalloans.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignInActivity extends AppCompatActivity {

    EditText editTextPhone, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //Start Main Activity if user is logged in
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, HomeActivity.class));
        }

        editTextPhone = findViewById(R.id.login_phone);
        editTextPassword = findViewById(R.id.login_password);

        /*Perform action on signIn button onClick*/
        findViewById(R.id.signin_to_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });
    }

    public void userLogin()
    {
        final String phone = editTextPhone.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(phone)) {
            editTextPhone.setError("Please enter Phone Number");
            editTextPhone.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Please enter Password");
            editTextPassword.requestFocus();
            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_LOGIN,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {

                        JSONObject obj = new JSONObject(response);
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();

                        JSONObject userJson = obj.getJSONObject("user");

                        User user = new User(
                            userJson.getString("name"),
                            userJson.getString("phone"),
                            userJson.getString("id_no"),
                            obj.getString("token"),
                            userJson.getString("dob"),
                                userJson.getInt("verified") > 0
                        );

                        //storing the user in shared preferences
                        SharedPrefManager.getInstance(getApplicationContext()).loginUser(user);

                        finish();
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                        noConnectError();
                    } else if (error instanceof ClientError) {
                        NetworkResponse response = error.networkResponse;
                        if(response != null && response.data != null){
                            switch(response.statusCode) {
                                case 422:
                                    String jsonError = new String(response.data);
                                    jsonError = trimMessage(jsonError);
                                    displayMessage(jsonError);
                                    break;
                            }
                        }
                    }

                }

                private String trimMessage(String json){
                    String trimmedString;

                    try{
                        JSONArray errorArray = new JSONArray(json);
                        trimmedString = errorArray.getString(0);
                    } catch(JSONException e){
                        e.printStackTrace();
                        return null;
                    }

                    return trimmedString;
                }

                private void displayMessage(String toastString){
                    Toast.makeText(getApplicationContext(), toastString, Toast.LENGTH_LONG).show();
                }
            }) {

                @Override
                public Map<String, String> getHeaders() {
                    Map<String, String> headers = new HashMap<>();
                    headers.put("Accept", "application/json");
                    return headers;
                }

                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("phone", phone);
                    params.put("password", password);
                    return params;
                }
            };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void noConnectError(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(SignInActivity.this);
        builder.setTitle("Connection Error");
        builder.setMessage("There was an Error in Connection.");
        builder.setCancelable(false);
        builder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                userLogin();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
