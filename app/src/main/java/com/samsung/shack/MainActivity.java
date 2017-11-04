package com.samsung.shack;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.content.SharedPreferences;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    public static final String prefs = "MyPrefsFile";
    static boolean loggedIn = false;
    //public static boolean loggedIn = false;



    /*
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings = getSharedPreferences(prefs, 0);
        loggedIn = settings.getBoolean("loggedIn", loggedIn);
        startLogin(loggedIn);
    }



    public void startLogin(boolean loggedIn) {
        if(!loggedIn) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }

    protected void onStop(){
        super.onStop();
        SharedPreferences settings = getSharedPreferences(prefs, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("loggedIn", loggedIn);
        editor.commit();
    }
}
