package com.rxandroid.elice.skeletonpj.presentation.presenter;

import com.rxandroid.elice.skeletonpj.data.net.RestClient;
import com.rxandroid.elice.skeletonpj.presentation.view.activity.MainActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by elice.kim on 2017. 7. 15..
 */

public class ImagePresenter extends BasePresenter<MainActivity> {

    private RestClient restClient;

    public ImagePresenter(RestClient restClient) {
        this.restClient = restClient;
    }

    public void loadImgList() {
        subscription = restClient.getImageRepository()
                .getImageList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> view.showLoading())
                .doOnTerminate(() -> view.hideLoading())
                .subscribe(response -> view.onComplete(response.channel.item),
                        e -> view.onFail());
    }
}
