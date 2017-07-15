package com.rxandroid.elice.skeletonpj.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.rxandroid.elice.skeletonpj.R;
import com.rxandroid.elice.skeletonpj.data.dto.DaumImageDTO;
import com.rxandroid.elice.skeletonpj.data.net.RestClient;
import com.rxandroid.elice.skeletonpj.presentation.presenter.ImagePresenter;
import com.rxandroid.elice.skeletonpj.presentation.view.adapter.ImageViewAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;

public class MainActivity extends BaseActivity {

    @BindView(R.id.imageRecyclerView) RecyclerView imageRecyclerView;
    private ImageViewAdapter adapter;
    private ImagePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        presenter.loadImgList();
    }

    private void initView() {
        imageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ImageViewAdapter(this);
        imageRecyclerView.setAdapter(adapter);
        presenter = new ImagePresenter(new RestClient(this));
        presenter.setView(this);
    }

    public void onComplete(List<DaumImageDTO.Channel.Item> imageList) {
        adapter.replaceAll(imageList);
    }

    public void onFail() {
        Toast.makeText(this, "이미지 로딩 실패", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        Subscription subscription = presenter.getSubscription();
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        super.onDestroy();
    }
}
