package com.yanxw.goodpictures.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yanxw.goodpictures.R;
import com.yanxw.goodpictures.model.pic.PicList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.yanxw.goodpictures.adapter.PicInfoListAdapter.PICTURE_HEIGHT;

/**
 * PicListAdapter
 * Created by yanxinwei on 16/8/26.
 */

public class PicListAdapter extends RecyclerView.Adapter<PicListAdapter.PicListHolder> {

    private List<PicList.PicDetail> mPicDetails;
    private Context mContext;

    public PicListAdapter(Context context, List<PicList.PicDetail> picDetails) {
        mContext = context;
        mPicDetails = picDetails;
    }

    @Override
    public PicListAdapter.PicListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PicListHolder(LayoutInflater.from(mContext).inflate(R.layout.item_picture_original,
                parent, false));
    }

    @Override
    public void onBindViewHolder(PicListAdapter.PicListHolder holder, int position) {

        ViewGroup.LayoutParams params = holder.mDraweeView.getLayoutParams();
        params.height = PICTURE_HEIGHT * 2;
        holder.mDraweeView.setLayoutParams(params);
        holder.mDraweeView.setImageURI(mPicDetails.get(position).getPicUrl());

    }

    @Override
    public int getItemCount() {
        return mPicDetails.size();
    }

    public void appendData(List<PicList.PicDetail> picDetails) {
        mPicDetails.addAll(picDetails);
        notifyDataSetChanged();
    }

    class PicListHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.sdv_pic_original)
        SimpleDraweeView mDraweeView;

        PicListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
