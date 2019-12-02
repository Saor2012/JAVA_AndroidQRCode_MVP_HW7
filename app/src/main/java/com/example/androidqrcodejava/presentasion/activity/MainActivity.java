package com.example.androidqrcodejava.presentasion.activity;

import android.graphics.Bitmap;

import com.example.androidqrcodejava.presentasion.presenter.base.IBasePresenter;
import com.example.androidqrcodejava.presentasion.presenter.IPresenter;
import com.example.androidqrcodejava.presentasion.presenter.Presenter;
import com.example.androidqrcodejava.R;
import com.example.androidqrcodejava.databinding.ActivityMainBinding;
import com.example.androidqrcodejava.presentasion.activity.base.BaseActivity;

import timber.log.Timber;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements IPresenter.View {
    private IPresenter.Listener presenter;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main_v2;
    }

    @Override
    protected void initView() {
        presenter = new Presenter();
        getBinding().setEvent(presenter);
        presenter.init();
    }

    @Override
    protected void onStartView() {
        presenter.startView(this);
//        presenter.init();
    }

    @Override
    protected void onDestroyView() {
        presenter.detachView();
        //SharedPreferencesStorage.getInstance().clearAll();
    }

    @Override
    protected IBasePresenter getPresenter() {
        return presenter;
    }

    @Override
    public void message(String string) {
        toast(string);
        Timber.e(string);
    }

    @Override
    public String handleOnClikc() {
        String str = getBinding().resultQRCodeField.getText().toString();
        if (str.equals(""))
            str = "0";
        return str;
    }

    @Override
    public void setQRCodeImage(Bitmap bitmap) {
        getBinding().QRCodeImage.setImageBitmap(bitmap);
    }
}
