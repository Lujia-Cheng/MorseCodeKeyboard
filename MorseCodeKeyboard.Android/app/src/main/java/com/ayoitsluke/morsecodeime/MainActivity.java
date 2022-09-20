package com.ayoitsluke.morsecodeime;

import androidx.appcompat.app.AppCompatActivity;

// TODO Since keyboard is a service, Forward main to preference
public class MainActivity extends AppCompatActivity {
    public void onCreate() {
        super.onCreate();
        // TODO get preference
        this.getLayoutInflater().inflate(SettingsFragment, null);
    }
}
