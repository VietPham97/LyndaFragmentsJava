package com.espresslabs.lyndafragmentsjava;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addFragment(View view) {
        SimpleFragment fragment = new SimpleFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }

    public void removeFragment(View view) {
        // Retrieve the fragment from the Manager
        Fragment fragment = getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container);

        // check if fragment is valid and then remove it
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragment)
                    .commit();
        }
    }
}
