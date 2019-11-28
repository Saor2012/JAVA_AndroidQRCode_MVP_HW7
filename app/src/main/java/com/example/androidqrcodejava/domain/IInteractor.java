package com.example.androidqrcodejava.domain;

import android.graphics.Bitmap;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface IInteractor {
    Single<Bitmap> load(String key);
    //Single<Bitmap> save(String key);
    Completable save(String key, String str);
}
