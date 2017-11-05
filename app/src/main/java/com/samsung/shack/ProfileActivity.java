package com.samsung.shack;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {

    private TextView mTextMessage;
    public static final String prefs = "MyPrefsFile";
    static boolean loggedIn = false;
    //public static boolean loggedIn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button signature = findViewById(R.id.signature);
        Button setFingerprint = findViewById(R.id.fingerprint);
        setFingerprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        signature.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });

    }





    protected void onStop(){
        super.onStop();

    }
}
