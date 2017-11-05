package com.samsung.shack;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Context mContext = this;
    private TextView mTextMessage;
    public static final String database = "database";
    static boolean loggedIn = false;
    //public static boolean loggedIn = false;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //Toast.makeText(mContext, "Hello",Toast.LENGTH_SHORT);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_myProfile:
                    //mTextMessage.setText(R.string.title_myprofile);
                    onProfileClicked();
                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        SharedPreferences settings = getSharedPreferences(database, 0);
        loggedIn = settings.getBoolean("loggedIn", loggedIn);
        startLogin(loggedIn);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(mContext, "Hello", Toast.LENGTH_SHORT);
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        //mTextMessage.setText(R.string.title_home);
                        return true;
                    case R.id.navigation_myProfile:
                        // mTextMessage.setText(R.string.title_myprofile);
                        onProfileClicked();
                        return true;
                }
                return false;

            }

        });

        FloatingActionButton addParcel = findViewById(R.id.floatingActionButton2);
        addParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getSharedPreferences(MainActivity.database, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("pranavisgay", "pranav is very gay");
            }
        });
    }
        //onProfileClicked();

    public void onProfileClicked(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }



    public void startLogin(boolean loggedIn) {
        if(!loggedIn) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }

    protected void onStop(){
        super.onStop();
        SharedPreferences settings = getSharedPreferences(database, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("loggedIn", loggedIn);
        editor.commit();
    }
}
