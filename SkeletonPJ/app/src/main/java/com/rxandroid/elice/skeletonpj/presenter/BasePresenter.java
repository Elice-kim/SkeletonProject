package com.rxandroid.elice.skeletonpj.presenter;

/**
 * Created by elice.kim on 2017. 7. 15..
 */

public class BasePresenter<T> {

    public T view;

    public void setView(T view){
        this.view = view;
    }
}
