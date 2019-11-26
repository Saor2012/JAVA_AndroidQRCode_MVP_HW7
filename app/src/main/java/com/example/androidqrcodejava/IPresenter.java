package com.example.androidqrcodejava;

import android.graphics.Bitmap;

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
