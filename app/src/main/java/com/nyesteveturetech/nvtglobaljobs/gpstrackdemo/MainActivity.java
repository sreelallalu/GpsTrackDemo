package com.nyesteveturetech.nvtglobaljobs.gpstrackdemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import fr.quentinklein.slt.LocationTracker;
import fr.quentinklein.slt.TrackerSettings;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (    ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // You need to ask the user to enable the permissions
        } else {
            TrackerSettings settings =
                    new TrackerSettings()
                            .setUseGPS(true)
                            .setUseNetwork(true)
                            .setUsePassive(true)
                            .setTimeBetweenUpdates(300);
                            //.setMetersBetweenUpdates(100);
            LocationTracker tracker = new LocationTracker(MainActivity.this,settings) {
                @Override
                public void onLocationFound(Location location) {
                   // Do some stuff
                   double k=location.getLatitude();
                   String kp=Double.toString(k);
                   Log.e("double",kp);


                }



                @Override
                public void onTimeout() {

                }
            };
            tracker.startListening();
        }

    }
}
