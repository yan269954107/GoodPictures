package com.yanxw.goodpictures.ui.fragment.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yanxw.goodpictures.R;
import com.yanxw.goodpictures.ui.fragment.RefreshFragment;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PicFlowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PicFlowFragment extends RefreshFragment {

    private static final String CATEGORY_ID = "category_id";
    private String mCategoryId;

    @BindView(R.id.txt_category_id)
    TextView mTxtCategoryId;

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
    public static PicFlowFragment newInstance(String categoryId) {
        PicFlowFragment fragment = new PicFlowFragment();
        Bundle args = new Bundle();
        args.putString(CATEGORY_ID, categoryId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCategoryId = getArguments().getString(CATEGORY_ID);
        }
    }

    @Override
    protected View provideContentView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_pic_flow, container, false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mTxtCategoryId.setText(mCategoryId);
        return view;
    }

}
