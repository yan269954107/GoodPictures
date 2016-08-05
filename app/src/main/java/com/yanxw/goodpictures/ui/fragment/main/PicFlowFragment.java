package com.yanxw.goodpictures.ui.fragment.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanxw.goodpictures.R;
import com.yanxw.goodpictures.adapter.PicListAdapter;
import com.yanxw.goodpictures.model.pic.tiangou.TgList;
import com.yanxw.goodpictures.ui.fragment.RefreshFragment;
import com.yanxw.goodpictures.vp.pic.PicFlowView;
import com.yanxw.goodpictures.vp.pic.PicPresenter;
import com.yanxw.goodpictures.widget.AutoLoadRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PicFlowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PicFlowFragment extends RefreshFragment implements PicFlowView{

    private static final String TAG = PicFlowFragment.class.getSimpleName();
    private static final int DEFAULT_COLUMN = 2;

    private static final String CATEGORY_ID = "category_id";
    private int mCategoryId;
    private PicPresenter mPicPresenter;
    private PicListAdapter mAdapter;
    private int page = 1;

    @BindView(R.id.rv_pic_flow)
    AutoLoadRecyclerView mRecyclerView;

    public PicFlowFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param categoryId Parameter 1.
     * @return A new instance of fragment PicFlowFragment.
     */
    public static PicFlowFragment newInstance(int categoryId) {
        PicFlowFragment fragment = new PicFlowFragment();
        Bundle args = new Bundle();
        args.putInt(CATEGORY_ID, categoryId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCategoryId = getArguments().getInt(CATEGORY_ID);
        }
        Log.d(TAG, "@@@@onCreate category id : " + mCategoryId);
    }

    @Override
    protected View provideContentView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_pic_flow, container, false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "@@@@onCreateView category id : " + mCategoryId);
        View view = super.onCreateView(inflater, container, savedInstanceState);
        init();
        return view;
    }

    private void init() {
        mRefreshLayout.setOnRefreshListener(this);
        mPicPresenter = new PicPresenter();
        mPicPresenter.attachView(this);

        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(DEFAULT_COLUMN,
                StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new PicListAdapter(new ArrayList<TgList.PicturesInfo>());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLoadMoreListener(this);

        showRefresh();
    }

    @Override
    public void loadData() {
        mPicPresenter.loadData(mCategoryId, page);
        page ++;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "@@@@onDestroyView category id : " + mCategoryId);
        mPicPresenter.detachView();
    }

    @Override
    public void onRefresh() {
        Log.d(TAG, "@@@@onRefresh category id : " + mCategoryId);
        page = 1;
        loadData();
    }

    @Override
    public void refresh(List<TgList.PicturesInfo> picturesInfoList) {
        mRefreshLayout.setRefreshing(false);
        Log.d("tag", "@@@@ setRefreshing false");
        mAdapter.replaceData(picturesInfoList);
        mRecyclerView.setLoading(false);
    }

    @Override
    public void onLoadMore() {
        loadData();
    }
}
