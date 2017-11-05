package com.samsung.shack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.samsung.shack.ProfileActivities.SpenTests;


public class ProfileActivity extends AppCompatActivity {

    private TextView mTextMessage;
    public static final String prefs = "MyPrefsFile";
    static boolean loggedIn = false;
    Context loginContext = this;

    //public static boolean loggedIn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final Intent setSignature = new Intent(this, SpenTests.class );
        final Intent loginPage = new Intent(this, LoginActivity.class );


        Button signature = findViewById(R.id.signature);
        Button logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getSharedPreferences(MainActivity.database, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("loggedIn", loggedIn);
                editor.putString("email", null);
                editor.putString("pass", null);
                editor.commit();
                Toast.makeText(loginContext, settings.getString("email", ""),Toast.LENGTH_LONG);
                Toast.makeText(loginContext, settings.getString("pass", ""),Toast.LENGTH_LONG);
                startActivity(loginPage);
                editor.commit();
            }
        });
        signature.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(setSignature);
            }
        });
        /* logout code
        SharedPreferences settings = getSharedPreferences(prefs, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("loggedIn", false);
        editor.commit();*/

    }





    protected void onStop(){
        super.onStop();

    }
}
