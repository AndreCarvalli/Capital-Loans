package com.tech.eyeq.capitalloans.config;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.tech.eyeq.capitalloans.SignInActivity;
import com.tech.eyeq.capitalloans.models.User;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "capitalloanspref";
    private static final String KEY_ID_NO = "keyidno";
    private static final String KEY_NAME = "keyname";
    private static final String KEY_PHONE = "keyphone";
    private static final String KEY_DOB = "keydob";
    private static final String KEY_TOKEN = "keytoken";
    private static final String KEY_VERIFIED = "keyverified";

    private static SharedPrefManager mInstance;
    private static Context mContext;

    private SharedPrefManager(Context context) {
        mContext = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context.getApplicationContext());
        }
        return mInstance;
    }

    //LoginActivity user and store user data
    public void userLogin(User user) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME, user.getName());
        editor.putString(KEY_PHONE, user.getPhone());
        editor.putString(KEY_ID_NO, user.getId_no());
        editor.putString(KEY_TOKEN, user.getToken());
        editor.putString(KEY_DOB, user.getDob());
        editor.putBoolean(KEY_VERIFIED, user.getVerified());
        editor.apply();
    }

    //Check if User is logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_TOKEN, null) != null;
    }

    //Check if User is verified or not
    public boolean isVerified() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(KEY_VERIFIED, false);
    }

    //Logout user from the application
    public void logout() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        Intent intent;
        intent = new Intent(mContext, SignInActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

}
