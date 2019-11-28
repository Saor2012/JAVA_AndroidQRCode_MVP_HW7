package com.example.androidqrcodejava.presentasion.presenter;

import android.graphics.Bitmap;

import com.example.androidqrcodejava.presentasion.presenter.base.IBasePresenter;

public interface IPresenter {
    interface View {
        void message(String string);
        String handleOnClikc();
        void setQRCodeImage(Bitmap bitmap);
    }
    interface Listener extends IBasePresenter<View> {
        void init();
        void eventClick();
    }
}
