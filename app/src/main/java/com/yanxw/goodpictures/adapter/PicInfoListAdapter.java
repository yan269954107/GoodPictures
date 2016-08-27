package com.yanxw.goodpictures.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yanxw.goodpictures.R;
import com.yanxw.goodpictures.model.pic.PicInfoList;
import com.yanxw.goodpictures.ui.activity.pic.PicListActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * PicInfoListAdapter
 * Created by yanxinwei on 16/8/5.
 */

public class PicInfoListAdapter extends RecyclerView.Adapter<PicInfoListAdapter.PicListHolder> {

    public static final int THUMBNAILS_WIDTH = 300;
    public static int PICTURE_HEIGHT = 450;

    private List<PicInfoList.PicInfo> mPicList;
    private Context mContext;

    public PicInfoListAdapter(Context context, List<PicInfoList.PicInfo> picList) {
        mContext = context;
        mPicList = picList;
    }

    @Override
    public PicListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PicListHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_picture_thumb, parent, false));
    }

    @Override
    public void onBindViewHolder(PicListHolder holder, int position) {
        PicInfoList.PicInfo picInfo = mPicList.get(position);
        Uri uri = Uri.parse(picInfo.getThumbUrl());
        ViewGroup.LayoutParams params = holder.mDraweeView.getLayoutParams();
        params.height = PICTURE_HEIGHT;
        holder.mDraweeView.setLayoutParams(params);
        holder.mDraweeView.setImageURI(uri);
        holder.mTxtDes.setText(picInfo.getDescription());
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

        PicListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            PicListActivity.startActivity(mContext, mPicList.get(getAdapterPosition()).getListUrl());
        }
    }

    public void replaceData(List<PicInfoList.PicInfo> picList) {
        mPicList = picList;
        notifyDataSetChanged();
    }

    public void appendData(List<PicInfoList.PicInfo> picList) {
        mPicList.addAll(picList);
        notifyDataSetChanged();
    }

}
