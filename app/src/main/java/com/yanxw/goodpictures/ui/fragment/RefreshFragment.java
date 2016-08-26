package com.yanxw.goodpictures.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanxw.goodpictures.R;
import com.yanxw.goodpictures.vp.RefreshView;
import com.yanxw.goodpictures.widget.AutoLoadRecyclerView;

import butterknife.BindView;

/**
 * Created by yanxinwei on 16/8/3.
 */

public abstract class RefreshFragment extends BaseFragment implements RefreshView,
        SwipeRefreshLayout.OnRefreshListener, AutoLoadRecyclerView.LoadMoreListener{

    @BindView(R.id.swipe_refresh_layout)
    public SwipeRefreshLayout mRefreshLayout;

    @Override
    public void showRefresh() {
        if (mRefreshLayout != null) {
            mRefreshLayout.post(() -> {
                mRefreshLayout.setRefreshing(true);
                loadData();
            });
        }
    }

    public void loadData(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mRefreshLayout.setColorSchemeColors(ContextCompat.getColor(getContext(), R.color.colorOrangeDark));
        return view;
    }

    @Override
    public void showError(int messageId) {

    }
}
