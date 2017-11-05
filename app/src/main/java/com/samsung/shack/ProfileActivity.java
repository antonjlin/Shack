package com.samsung.shack;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.samsung.shack.ProfileActivities.SpenTests;


public class ProfileActivity extends AppCompatActivity {

    private TextView mTextMessage;
    public static final String prefs = "MyPrefsFile";
    static boolean loggedIn = false;
    //public static boolean loggedIn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final Intent intent = new Intent(this, SpenTests.class );
        Button signature = findViewById(R.id.signature);
        Button setFingerprint = findViewById(R.id.fingerprint);
        setFingerprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        signature.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(intent);

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
