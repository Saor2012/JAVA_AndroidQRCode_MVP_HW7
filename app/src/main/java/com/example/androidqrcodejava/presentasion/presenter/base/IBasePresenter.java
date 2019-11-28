package com.example.androidqrcodejava.presentasion.presenter.base;

public interface IBasePresenter<V> {
    void startView(V view);
    void detachView();
}
