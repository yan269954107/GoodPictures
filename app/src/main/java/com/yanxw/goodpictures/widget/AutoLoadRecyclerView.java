package com.yanxw.goodpictures.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

/**
 * Created by yanxinwei on 16/8/5.
 */

public class AutoLoadRecyclerView extends RecyclerView {

    private static final int PRELOAD_SIZE = 6;

    private LoadMoreListener loadMoreListener;
    private AutoLoadScroller autoLoadScroller;
    private boolean isLoading = false;

    public interface LoadMoreListener {
        void onLoadMore();
    }

    public AutoLoadRecyclerView(Context context) {
        this(context, null);
    }


    public AutoLoadRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        autoLoadScroller = new AutoLoadScroller();
        addOnScrollListener(autoLoadScroller);
    }


    public void setLoadMoreListener(LoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    public void removeAutoScroller() {
        removeOnScrollListener(autoLoadScroller);
    }

    private class AutoLoadScroller extends OnScrollListener {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (getLayoutManager() instanceof LinearLayoutManager) {
                int lastVisiblePos = ((LinearLayoutManager) getLayoutManager()).findLastVisibleItemPosition();
                int itemCount = getAdapter().getItemCount();
                if (loadMoreListener != null && !isLoading && lastVisiblePos > itemCount - PRELOAD_SIZE / 2 && dy > 0) {
                    loadMoreListener.onLoadMore();
                    isLoading = true;
                }
            } else if (getLayoutManager() instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager layoutManager = (StaggeredGridLayoutManager) getLayoutManager();
                boolean isBottom = layoutManager.findLastCompletelyVisibleItemPositions(new int[2])[1] >= getAdapter().getItemCount() - PRELOAD_SIZE;
                if (loadMoreListener != null && !isLoading && isBottom) {
                    loadMoreListener.onLoadMore();
                    isLoading = true;
                }
            }
        }
    }

}
