package com.rxandroid.elice.skeletonpj.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rxandroid.elice.skeletonpj.R;
import com.rxandroid.elice.skeletonpj.data.dto.DaumImageDTO;
import com.rxandroid.elice.skeletonpj.util.CollectionUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by elice.kim on 2017. 7. 15..
 */

public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewAdapter.ImageViewHolder> {

    private Context context;
    private ArrayList<DaumImageDTO.Channel.Item> imgList;

    public ImageViewAdapter(Context context) {
        this.context = context;
        this.imgList = new ArrayList<>();
    }

    public void addAll(List<DaumImageDTO.Channel.Item> list) {
        if (CollectionUtil.isEmpty(list)) return;
        addItemList(list);
    }

    public void replaceAll(List<DaumImageDTO.Channel.Item> list) {
        if (CollectionUtil.isEmpty(list)) return;
        imgList.clear();
        addItemList(list);
    }

    private void addItemList(List<DaumImageDTO.Channel.Item> list) {
        imgList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.view_image, parent, false));
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Glide.with(context).load(imgList.get(position).image).into(holder.daumImageView);
    }

    @Override
    public int getItemCount() {
        return imgList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.daumImageView) ImageView daumImageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
