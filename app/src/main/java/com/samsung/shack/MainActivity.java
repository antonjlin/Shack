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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    static JSONArray parcelNamesJson = new JSONArray();
    static JSONArray trackingIDsJson = new JSONArray();
    static JSONArray carrierJson = new JSONArray();
    Button parcel1 = (Button) findViewById(R.id.parcel1);
    Button parcel2 = (Button) findViewById(R.id.parcel2);
    Button parcel3 = (Button) findViewById(R.id.parcel3);
    Button parcel4 = (Button) findViewById(R.id.parcel4);
    Button parcel5 = (Button) findViewById(R.id.parcel5);




    Context mContext = this;
    public static final String database = "database";
    static boolean loggedIn = false;

    public static ArrayList<String> parcelNames =new ArrayList<String>();
    public static ArrayList<String> trackingIDs =new ArrayList<String>();
    public static ArrayList<String> carrier = new ArrayList<String>();

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
                onCreateParcelClicked();
            }
        });
        parcel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        parcel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        parcel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        parcel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        parcel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        for(int x = 0; x<parcelNamesJson.length(); x++) {
            try {
                if(parcelNames != null) {
                    parcelNames.add((String) parcelNamesJson.get(x));
                    Toast.makeText(this, (String) parcelNamesJson.get(x), Toast.LENGTH_SHORT);
                }else{

                }
            } catch(JSONException e){
                e.printStackTrace();
            }
        }
        for(int x = 0; x<trackingIDsJson.length(); x++) {
            try {
                if(trackingIDs != null) {
                    trackingIDs.add((String) trackingIDsJson.get(x));
                    Toast.makeText(this, (String) trackingIDsJson.get(x), Toast.LENGTH_SHORT);
                }else{

                }

            } catch(JSONException e){
                e.printStackTrace();
            }
        }
        for(int x = 0; x<carrierJson.length(); x++) {
            try {
                if(carrier != null) {
                    carrier.add((String) carrierJson.get(x));
                    Toast.makeText(this, (String) carrierJson.get(x), Toast.LENGTH_SHORT);
                } else{

                }
            } catch(JSONException e){
                e.printStackTrace();
            }
        }




    }
        //onProfileClicked();

    public void onProfileClicked(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
    public void onCreateParcelClicked(){
        Intent intent = new Intent(this, NewParcelActivity.class);
        startActivity(intent);
    }



    public void startLogin(boolean loggedIn) {
        if(!loggedIn) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }

    protected void onDestroy(){
        super.onDestroy();
        SharedPreferences settings = getSharedPreferences(database, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("loggedIn", loggedIn);
        editor.commit();

        for(String x:parcelNames) {
            parcelNamesJson.put(x);
        }
        for(String x:trackingIDs) {
            trackingIDsJson.put(x);
        }
        for(String x:carrier) {
            carrierJson.put(x);
        }
    }
}

