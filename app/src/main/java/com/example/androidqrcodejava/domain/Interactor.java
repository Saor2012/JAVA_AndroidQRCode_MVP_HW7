package com.example.androidqrcodejava.domain;

import android.graphics.Bitmap;
import android.os.Build;

import com.example.androidqrcodejava.data.repository.Repository;
import com.example.androidqrcodejava.domain.base.BaseInteractor;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.encoder.QRCode;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import io.reactivex.Completable;
import io.reactivex.Single;
import timber.log.Timber;

public class Interactor extends BaseInteractor implements IInteractor {

    public Interactor() {}

    @Override
    public Single<Bitmap> load(String key) {

        return Repository.getInstance().load(key)
                .flatMap(this::qrCode)
                .compose(applySingleSchedulers());
    }


    private Single<Bitmap> qrCode(String QRCode) { //QRCode object
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            if(QRCode != null && !QRCode.isEmpty()) {
                try {
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    //Timber.e(QRCode);
                    return Single.just(barcodeEncoder.encodeBitmap(QRCode, BarcodeFormat.QR_CODE, 200, 200));
                } catch (Exception e) {
                    Timber.e(e.getMessage().toString());
                    return Single.error(new NullPointerException());
                }
            } else return Single.error(new NullPointerException());
        //}
        //return bitmap;
    }

    //@Override
    public Single<Bitmap> save(String key) {
        return null; //Repository.getInstance().create(key).compose(applySingleSchedulers());
    }

    @Override
    public Completable save(String key, String str) {
        return Completable.fromAction(() ->
            Repository.getInstance().save(key, str) //.compose(applySingleSchedulers())
        );
    }
}
