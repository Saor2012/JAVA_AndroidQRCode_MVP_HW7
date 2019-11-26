package com.example.androidqrcodejava;

public interface IBasePresenter<V> {
    void startView(V view);
    void detachView();
}
