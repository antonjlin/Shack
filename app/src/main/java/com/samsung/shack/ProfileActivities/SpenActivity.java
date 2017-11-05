package com.samsung.shack.ProfileActivities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.engine.SpenSurfaceView;
import com.samsung.android.sdk.pen.recognition.SpenSignatureVerification;
import com.samsung.android.sdk.pen.recognition.SpenSignatureVerificationManager;
import com.samsung.shack.R;
import com.samsung.shack.penSamples.PenSample5_7_SignatureRegistration;
import com.samsung.shack.penSamples.SDKUtils;

import java.util.ArrayList;

/**
 * Created by pranav on 11/4/17.
 */

public class SpenActivity extends AppCompatActivity {

    private Context mContext = null;
    private SpenNoteDoc mSpenNoteDoc;
    private SpenPageDoc mSpenPageDoc;
    private SpenSurfaceView mSpenSurfaceView;

  /*  public PenSample5_7_SignatureRegistration.ListAdapter mSignatureAdapter;
    public ArrayList<PenSample5_7_SignatureRegistration.ListItem> mSignatureListItem;*/

    public int mSignatureRegistrationNum = 0;
    public int mSignatureRegistrationNumMax;
    public ListView mSignatureList;

    //private int mResult = 0;

    private SpenSignatureVerificationManager mSpenSignatureVerificationManager;
    private SpenSignatureVerification mSpenSignatureVerification;

    private final int LIST_REGISRTATION = 0;
    private final int LIST_RETRY = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcel);

        mContext = this;
        SpenSignatureVerificationManager verificationManager = new SpenSignatureVerificationManager(this);

        // Initialize Spen
        boolean isSpenFeatureEnabled = false;
        Spen spen = new Spen();
        try {
            spen.initialize(this);
            isSpenFeatureEnabled = spen.isFeatureEnabled(Spen.DEVICE_PEN);
        } catch (SsdkUnsupportedException e) {
            if( SDKUtils.processUnsupportedException(this, e) == true) {
                return;
            }
        } catch (Exception e1) {
            Toast.makeText(mContext, "Cannot initialize Spen.",
                    Toast.LENGTH_SHORT).show();
            e1.printStackTrace();
            finish();
        }

        // Create SpenView
        RelativeLayout spenViewLayout = (RelativeLayout) findViewById(R.id.spenLayout);
        mSpenSurfaceView = new SpenSurfaceView(mContext);
        if (mSpenSurfaceView == null) {
            Toast.makeText(mContext, "Cannot create new SpenView.",
                    Toast.LENGTH_SHORT).show();
            finish();
        }
        spenViewLayout.addView(mSpenSurfaceView);






    }
}
