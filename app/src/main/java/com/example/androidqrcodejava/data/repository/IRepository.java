package com.example.androidqrcodejava.data.repository;

import io.reactivex.Single;

public interface IRepository {
    Single<String> load(String key);
    //Single<String> create(String key);
    //Single<String> delete(String key);
    Single<String> update(String key);
    void save(String key, String str);
    void delete(String key);

}
