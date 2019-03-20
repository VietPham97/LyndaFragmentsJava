package com.espresslabs.lyndafragmentsjava;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

public class ScreenUtility {

    // The device independent pixels width and height
    private float dpWidth;
    private float dpHeight;

    public ScreenUtility(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();

        // get the raw dimensions as DisplayMetrics
        // represents the size of the screen in physical pixels - not what Android dev care about
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        // Calculate density - the number of pixels per inch
        float density = activity.getResources().getDisplayMetrics().density;

        // Calculate device independent pixels - that's exactly what Android dev care about
        dpWidth = outMetrics.widthPixels / density;
        dpHeight = outMetrics.heightPixels / density;
    }

    public float getDpWidth() { return dpWidth; }

    public float getDpHeight() { return dpHeight; }
}
