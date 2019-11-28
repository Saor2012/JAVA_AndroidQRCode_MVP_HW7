package com.example.androidqrcodejava.app;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.example.androidqrcodejava.BuildConfig;
import com.example.androidqrcodejava.data.repository.Repository;
import com.example.androidqrcodejava.data.storage.SharedPreferencesStorage;

import timber.log.Timber;

public class App extends Application {
    private static Gson gson;
    public void onCreate() {
        super.onCreate();
        Repository.getInstance();
        SharedPreferencesStorage.getInstance(getApplicationContext());
        gson = provideGson();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }


    }
    static Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.setLenient().create();
    }
    public static Gson gson() {
        return gson;
    }
}
