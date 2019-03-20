package com.espresslabs.lyndafragmentsjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mOut;
    private boolean mUseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOut = findViewById(R.id.text_out);
    }

    public void onMeasureBtnClick(View view) {
        // Create an instance of ScreenUtility
        ScreenUtility su = new ScreenUtility(this);

        // Display the result in dimensions
        mOut.setText(String.format("Width: %s, Height: %s", su.getDpWidth(), su.getDpHeight()));

        if (su.getDpWidth() >= 820) {
            // Time to place fragments side-by-side instead of using 2 different activities
            mUseFragment = true;
        } else {
            mUseFragment = false;
        }

        Toast.makeText(this,
                "Using Fragment? " + mUseFragment, Toast.LENGTH_SHORT).show();

    }

}
