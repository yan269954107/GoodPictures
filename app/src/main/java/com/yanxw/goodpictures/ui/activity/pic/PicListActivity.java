package com.yanxw.goodpictures.ui.activity.pic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;

import com.yanxw.goodpictures.R;
import com.yanxw.goodpictures.adapter.PicListAdapter;
import com.yanxw.goodpictures.model.pic.PicList;
import com.yanxw.goodpictures.ui.activity.BaseLoadingActivity;
import com.yanxw.goodpictures.vp.pic.PicOriginalPresenter;
import com.yanxw.goodpictures.vp.pic.PicOriginalView;
import com.yanxw.goodpictures.widget.AutoLoadRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PicListActivity extends BaseLoadingActivity implements PicOriginalView,AutoLoadRecyclerView.LoadMoreListener{

    @BindView(R.id.rv_pic_list)
    AutoLoadRecyclerView mRecyclerView;

    public static void startActivity(Context context, String url) {
        Intent starter = new Intent(context, PicListActivity.class);
        starter.putExtra("firstUrl", url);
        context.startActivity(starter);
    }

    private String nextUrl;

    private PicOriginalPresenter mPresenter;
    private PicListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_list);
        ButterKnife.bind(this);

        init();

        String firstUrl = getIntent().getStringExtra("firstUrl");
        loadData(firstUrl);
    }

    private void init() {
        mPresenter = new PicOriginalPresenter();
        mPresenter.attachView(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new PicListAdapter(this, new ArrayList<>());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void loadData(String url) {
        mPresenter.loadData(url);
    }

    @Override
    public void onLoadMore() {
        if (!TextUtils.isEmpty(nextUrl)) {
            loadData(nextUrl);
        }
    }

    @Override
    public void appendData(PicList picList) {
        nextUrl = picList.getNextPageUrl();
        mAdapter.appendData(picList.getPicDetails());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
