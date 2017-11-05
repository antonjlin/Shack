package com.samsung.shack;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by pranav on 11/4/17.
 */

public class ParcelActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent finger = new Intent(this, FingerprintAuthenticator.class);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_parcel);

        Button sign = (Button) findViewById(R.id.signfordelivery);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(finger);

            }
        });

    }
}
