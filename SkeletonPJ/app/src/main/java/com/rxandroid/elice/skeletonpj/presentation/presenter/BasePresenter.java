package com.rxandroid.elice.skeletonpj.presentation.presenter;

import rx.Subscription;

/**
 * Created by elice.kim on 2017. 7. 15..
 */

public class BasePresenter<T> {

    protected Subscription subscription;

    public T view;

    public void setView(T view) {
        this.view = view;
    }

    public Subscription getSubscription() {
        return subscription;
    }
}
