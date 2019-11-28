package com.example.androidqrcodejava.presentasion.presenter;

import android.graphics.Bitmap;

import com.example.androidqrcodejava.app.App;
import com.example.androidqrcodejava.data.constant.Constant;
import com.example.androidqrcodejava.data.model.ExampleModel;
import com.example.androidqrcodejava.data.storage.SharedPreferencesStorage;
import com.example.androidqrcodejava.domain.IInteractor;
import com.example.androidqrcodejava.domain.Interactor;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import timber.log.Timber;

public class Presenter implements IPresenter.Listener{
    private IPresenter.View view;
    private IInteractor interactor;
    private String key;

    public Presenter() {
        interactor = new Interactor();
    }

    private Bitmap qrCode(String QRcode) { //QRCode object
        Bitmap bitmap = null;
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
             bitmap = barcodeEncoder.encodeBitmap(QRcode, BarcodeFormat.QR_CODE, 200, 200);
        } catch (Exception e) {
            view.message(e.getMessage());
            Timber.e(e.getMessage().toString());
        }
        /*
        if(true) {
        interatror.save(key,value)
            .subscribe(new CompletableObserver(){

                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onComplete() {

                }

                @Override
                public void onError(Throwable e) {

                }
            });
        }
        */

        /*
        else {
        interactor.load().subscribe(new DisposableSingleObserver<Bitmap>() {
            @Override
            public void onSuccess(Bitmap bitmap) {
                view.setQRCodeImage(bitmap);
                dispose();
            }

            @Override
            public void onError(Throwable e) {
                Timber.e(e.getMessage());
                view.message(e.getMessage());
            }
        });
        }
        */
        return bitmap;
    }

    /*public void saveData() {
        ExampleModel exampleModel = new ExampleModel();
        exampleModel.setName("");
        exampleModel.setNumber("");
        String json = App.gson().toJson(exampleModel);
        ExampleModel exampleModel1 = App.gson().fromJson(json, ExampleModel.class);
    }*/


    @Override
    public void init() {
        /*String str = SharedPreferencesStorage.getInstance().loadDataStringValue(Constant.NAME_QRCODE_PREFERENCE_STORAGE);
        if (!str.isEmpty()) view.setQRCodeImage(qrCode(str));
        else Timber.e("Invalid value for QRCode image " + str);*/

        interactor.load(Constant.NAME_QRCODE_PREFERENCE_STORAGE).subscribe(new DisposableSingleObserver<Bitmap>() {
            @Override
            public void onSuccess(Bitmap bitmap) {
                view.setQRCodeImage(bitmap);
                dispose();
            }

            @Override
            public void onError(Throwable e) {
                Timber.e(e.getMessage());
                view.message(e.getMessage());
            }
        });
    }

    @Override
    public void eventClick() {
        String str = view.handleOnClikc();
        Timber.e(str);

        //if (str.equals(SharedPreferencesStorage.getInstance().loadDataStringValue(Constant.NAME_QRCODE_PREFERENCE_STORAGE))) {
        //if (str.equals("0")) str = "New String";
        //view.setQRCodeImage(qrCode(str));
            interactor.load(Constant.NAME_QRCODE_PREFERENCE_STORAGE).subscribe(new DisposableSingleObserver<Bitmap>() {
                @Override
                public void onSuccess(Bitmap bitmap) {
                    view.setQRCodeImage(bitmap);
                    dispose();
                }

                @Override
                public void onError(Throwable e) {
                    Timber.e(e.getMessage());
                    view.message(e.getMessage());
                }
            });
        //} else {
            interactor.save(Constant.NAME_QRCODE_PREFERENCE_STORAGE, str)
                .subscribe(new CompletableObserver() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        Timber.e("Subscribe");
                    }

                    @Override
                    public void onComplete() {
                        Timber.e("Complete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e.getMessage());
                        view.message(e.getMessage());
                    }
                });
        //}
        /*ExampleModel exampleModel = new ExampleModel();
        exampleModel.setName("");
        exampleModel.setNumber("");
        String json = App.gson().toJson(exampleModel);
        ExampleModel exampleModel1 = App.gson().fromJson(json, ExampleModel.class);
        SharedPreferencesStorage.getInstance().saveDataStringValue(Constant.NAME_PREFERENCE_STORAGE, str);*/
        /*interactor.save(Constant.NAME_QRCODE_PREFERENCE_STORAGE, str)
                .subscribe(new CompletableObserver() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        Timber.e("Subscribe");
                    }

                    @Override
                    public void onComplete() {
                        Timber.e("Complete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e.getMessage());
                        view.message(e.getMessage());
                    }
                });*/
        //SharedPreferencesStorage.getInstance().saveDataStringValue(Constant.NAME_QRCODE_PREFERENCE_STORAGE, str);
    }

    @Override
    public void startView(IPresenter.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view != null) view = null;
        if (key != null) key = null;
        if (interactor != null) interactor = null;
    }
}
