package com.dchan.sample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d("DCHAN", "returned id old: " + this.getResources().getIdentifier("amazon_gc_prototype", "raw", this.getPackageName()));
        Log.d("DCHAN", "returned id new: " + ResourceLoader.getIdentifier(this, "amazon_gc_prototype", "raw", this.getPackageName()));
    }
}
