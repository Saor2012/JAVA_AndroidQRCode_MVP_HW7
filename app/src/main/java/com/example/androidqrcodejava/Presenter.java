package com.example.androidqrcodejava;

import android.app.SharedElementCallback;
import android.graphics.Bitmap;
import com.example.androidqrcodejava.Constant;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.encoder.QRCode;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import timber.log.Timber;

public class Presenter implements IPresenter.Listener{
    private IPresenter.View view;

    private Bitmap qrCode(String QRcode) { //QRCode object
        Bitmap bitmap = null;
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
             bitmap = barcodeEncoder.encodeBitmap(QRcode, BarcodeFormat.QR_CODE, 200, 200);
        } catch (Exception e) {
            view.message(e.getMessage());
            Timber.e(e.getMessage().toString());
        }
        return bitmap;
    }

    @Override
    public void init() {
        String str = SharedPreferencesStorage.getInstance().loadDataStringValue(Constant.NAME_QRCODE_PREFERENCE_STORAGE);
        if (str.isEmpty() != true) view.setQRCodeImage(qrCode(str));
        else Timber.e("Invalid value for QRCode image " + str);
    }

    @Override
    public void eventClick() {
        String str = view.handleOnClikc();
        if (str.equals(SharedPreferencesStorage.getInstance().loadDataStringValue(Constant.NAME_QRCODE_PREFERENCE_STORAGE)) || str.equals("0")) return;
        if (str.equals("0")) str = "New String";
        Timber.e(str);
        view.setQRCodeImage(qrCode(str));
        SharedPreferencesStorage.getInstance().saveDataStringValue(Constant.NAME_QRCODE_PREFERENCE_STORAGE, str);
    }

    @Override
    public void startView(IPresenter.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view != null) view = null;
    }
}
