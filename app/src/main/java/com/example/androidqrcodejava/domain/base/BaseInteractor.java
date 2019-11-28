package com.example.androidqrcodejava.domain.base;

import io.reactivex.CompletableTransformer;
import io.reactivex.FlowableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseInteractor { //Work with Thread for conection
    private Scheduler workThread;
    private Scheduler observeThread;

    public BaseInteractor() {
        workThread = Schedulers.io();
        observeThread = AndroidSchedulers.mainThread();
    }

    protected <T>SingleTransformer<T, T> applySingleSchedulers() { //Перетворює поток в io() поток
        return single -> single.subscribeOn(workThread)
                .observeOn(observeThread);
    }
    protected <T> FlowableTransformer<T, T> applySFlowableSchedulers() {
        return flowable -> flowable.subscribeOn(workThread)
                .observeOn(observeThread);
    }
    protected <T> ObservableTransformer<T, T> applyObservableSchedulers() {
        return observable -> observable.subscribeOn(workThread)
                .observeOn(observeThread);
    }
    protected CompletableTransformer applyCompletableSchedulers() {
        return completable -> completable.subscribeOn(workThread)
                .observeOn(observeThread);
    }
}
