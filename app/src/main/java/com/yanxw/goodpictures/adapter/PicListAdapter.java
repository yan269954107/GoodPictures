package com.yanxw.goodpictures.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yanxw.goodpictures.R;
import com.yanxw.goodpictures.model.pic.tiangou.TgList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yanxinwei on 16/8/5.
 */

public class PicListAdapter extends RecyclerView.Adapter<PicListAdapter.PicListHolder> {

    public static final int THUMBNAILS_WIDTH = 300;
    public static int PICTURE_HEIGHT = 450;

    private List<TgList.PicturesInfo> mPicList;

    public PicListAdapter(List<TgList.PicturesInfo> picList) {
        mPicList = picList;
    }

    @Override
    public PicListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PicListHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_picture, parent, false));
    }

    @Override
    public void onBindViewHolder(PicListHolder holder, int position) {
        TgList.PicturesInfo picturesInfo = mPicList.get(position);
        Uri uri = Uri.parse(picturesInfo.getThumbnailsUrl());
        ViewGroup.LayoutParams params = holder.mDraweeView.getLayoutParams();
        params.height = PICTURE_HEIGHT;
        holder.mDraweeView.setLayoutParams(params);
        holder.mDraweeView.setImageURI(uri);
        holder.mTxtDes.setText(picturesInfo.getTitle());
    }

    @Override
    public int getItemCount() {
        return mPicList.size();
    }

    class PicListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.sdv_pic)
        SimpleDraweeView mDraweeView;

        @BindView(R.id.txt_description)
        TextView mTxtDes;

        public PicListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public void replaceData(List<TgList.PicturesInfo> picList) {
        mPicList = picList;
        notifyDataSetChanged();
    }
}
