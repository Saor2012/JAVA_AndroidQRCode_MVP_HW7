package com.example.androidqrcodejava.data.repository;

import com.example.androidqrcodejava.data.storage.SharedPreferencesStorage;

import io.reactivex.Single;

public class Repository implements IRepository{
    private static IRepository instance;

    private Repository(){}

    public static synchronized IRepository getInstance() {
        if(instance == null)
            instance = new Repository();
        return instance;
    }

    @Override
    public Single<String> load(String key) {
        return Single.defer(() ->
            Single.just(SharedPreferencesStorage.getInstance().loadDataStringValue(key))
        );
    }

    //@Override
    public Single<String> create(String key) {
        return null;/*Single.defer(() ->
            Single.just(SharedPreferencesStorage.getInstance())
        );*/
    }

    /*@Override
    public Single<String> delete(String key) {
        return null;
    }*/

    @Override
    public Single<String> update(String key) {
        return null;
    }

    @Override
    public void save(String key, String str) {
        SharedPreferencesStorage.getInstance().saveDataStringValue(key, str);
    }

    @Override
    public void delete(String key) {
        SharedPreferencesStorage.getInstance().clearDataValue(key);
    }
}
