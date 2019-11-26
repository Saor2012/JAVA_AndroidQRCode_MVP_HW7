package com.example.androidqrcodejava;

import android.app.Application;

import timber.log.Timber;

public class App extends Application {
    public void onCreate() {
        super.onCreate();
        SharedPreferencesStorage.getInstance(getApplicationContext());
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

    }
}
