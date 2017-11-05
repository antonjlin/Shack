package com.samsung.shack;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class NewParcelActivity extends AppCompatActivity implements LoaderCallbacks<Cursor> , AdapterView.OnItemSelectedListener {

    Intent switchToMain = new Intent(this, MainActivity.class);

    private static final int REQUEST_READ_CONTACTS = 0;

    private AutoCompleteTextView trackingIdView;
    private AutoCompleteTextView parcelNameView;
    private Spinner spinner;
    String carrier;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newparcel);
        trackingIdView = (AutoCompleteTextView) findViewById(R.id.trackingID);
        parcelNameView = (AutoCompleteTextView) findViewById(R.id.parcelName);
        final String trackingID = trackingIdView.getText().toString();
        final String parcelName = parcelNameView.getText().toString();


        Button confirm = (Button) findViewById(R.id.confirm);
        confirm.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.parcelNames.add(parcelName);
                MainActivity.trackingIDs.add(trackingID);
                MainActivity.parcel1.setText(parcelName);

            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.carrier, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        carrier = parent.getItemAtPosition(pos).toString();
        MainActivity.carrier.add(carrier);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "please choose the carrier",Toast.LENGTH_SHORT);

    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}


