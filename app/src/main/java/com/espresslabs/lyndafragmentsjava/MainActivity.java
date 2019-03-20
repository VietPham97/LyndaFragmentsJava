package com.espresslabs.lyndafragmentsjava;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String FRAGMENT_TAG = "fragment_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addFragment(View view) {
        SimpleFragment fragment = new SimpleFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .add(R.id.fragment_container, fragment, FRAGMENT_TAG)
                .commit();
    }

    public void removeFragment(View view) {
        // Retrieve the fragment from the Manager
        Fragment fragment = getSupportFragmentManager()
                .findFragmentByTag(FRAGMENT_TAG);

        // check if fragment is valid
        if (fragment != null) {
            // pause and stop the fragment, but
            // will NOT remove from the back stack
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragment)
                    .commit();
        }
    }
}
