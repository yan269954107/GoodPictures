package com.yanxw.goodpictures.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yanxw.goodpictures.R;
import com.yanxw.goodpictures.common.utils.rx.RxUtils;
import com.yanxw.goodpictures.vp.LoadingView;

import rx.subscriptions.CompositeSubscription;

/**
 * BaseLoadingActivity
 * Created by yanxinwei on 16/8/26.
 */

public class BaseLoadingActivity extends BaseActivity implements LoadingView{

    protected CompositeSubscription mCompositeSubscription;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCompositeSubscription = RxUtils.getNewCompositeSubIfUnsubscribed(mCompositeSubscription);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxUtils.unsubscribe(mCompositeSubscription);
    }

    public void showProgressDialog() {
        showProgressDialog(getString(R.string.loading));
    }

    public void showProgressDialog(String info) {
        showProgress("", info, false);
    }

    public void showProgressDialog(String info, boolean cancelable) {
        showProgress("", info, cancelable);
    }

    public void showProgress(String title, String info, boolean cancelable) {
        if (!isFinishing()) {
            if (null == mProgressDialog) {

                mProgressDialog = ProgressDialog.show(this, title, info, true, cancelable,
                        dialogInterface -> {
                            mProgressDialog.dismiss();
                            RxUtils.unsubscribe(mCompositeSubscription);
                        });
            } else {
                if (!mProgressDialog.isShowing()) {
                    mProgressDialog.show();
                }
            }
        }
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing() && !isFinishing()) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    @Override
    public void showProgress() {
        showProgressDialog();
    }

    @Override
    public void hideProgress() {
        hideProgressDialog();
    }

    @Override
    public void showError(int messageId) {

    }
}
