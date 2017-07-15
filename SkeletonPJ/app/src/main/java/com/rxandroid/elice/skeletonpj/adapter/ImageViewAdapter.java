package com.rxandroid.elice.skeletonpj.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rxandroid.elice.skeletonpj.R;
import com.rxandroid.elice.skeletonpj.model.DaumImageModel;

import java.util.ArrayList;

/**
 * Created by elice.kim on 2017. 7. 15..
 */

public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewAdapter.ImageViewHolder> {

    private Context context;
    private ArrayList<DaumImageModel.Channel.Item> imgList;

    public ImageViewAdapter(Context context, ArrayList<DaumImageModel.Channel.Item> imgList) {
        this.context = context;
        this.imgList = imgList;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_image, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        DaumImageModel.Channel.Item model = imgList.get(position);

        Glide.with(context).load(model.image).into(holder.daumImgView);
    }

    @Override
    public int getItemCount() {
        return imgList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        private ImageView daumImgView;

        public ImageViewHolder(View itemView) {
            super(itemView);

            daumImgView = (ImageView) itemView.findViewById(R.id.daumImageView);
        }
    }
}
