package com.example.androidqrcodejava.data.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.androidqrcodejava.data.constant.Constant;

public class SharedPreferencesStorage {
    private Constant constant;
    private final SharedPreferences preferences;
    private final SharedPreferences.Editor editor;
    private static SharedPreferencesStorage instance;
    //@SuppresssLint("CommitPrefEdits")
    private SharedPreferencesStorage(Context context) {
        preferences = context.getApplicationContext().getSharedPreferences(constant.NAME_PREFERENCE_STORAGE, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }
    public static synchronized SharedPreferencesStorage getInstance(Context ... context) {
        if (instance == null)
            if (context[0] != null) instance = new SharedPreferencesStorage(context[0]);

        return instance;
    }
    public void saveDataStringValue(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }
    public void saveDataLongValue(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }
    public void saveDataBooleanValue(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }
    public String loadDataStringValue(String key) {
        return preferences.getString(key, "");
    }
    public long loadDataLongValue(String key) {
        return preferences.getLong(key, -1);
    }
    public boolean loadDataBooleanValue(String key) {
        return preferences.getBoolean(key, false);
    }
    /*public void clearDataStringValue(String key) {
        preferences.edit().remove(key).apply();
    }
    public void clearDataLongValue(String key) {
        preferences.edit().remove(key).apply();
    }
    public void clearDataBooleanValue(String key) {
        preferences.edit().remove(key).apply();
    }*/
    public void clearDataValue(String key) {
        preferences.edit().remove(key).apply();
    }
    public void clearAll() {
        preferences.edit().clear().apply();
    }
}
