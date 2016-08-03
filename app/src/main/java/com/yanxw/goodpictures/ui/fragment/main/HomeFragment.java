package com.yanxw.goodpictures.ui.fragment.main;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanxw.goodpictures.R;
import com.yanxw.goodpictures.adapter.PicCategoryAdapter;
import com.yanxw.goodpictures.common.utils.T;
import com.yanxw.goodpictures.model.pic.tiangou.TgClassify;
import com.yanxw.goodpictures.repository.pic.TgRepository;
import com.yanxw.goodpictures.ui.fragment.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.tl_category)
    TabLayout mTabLayout;

    @BindView(R.id.vp_category)
    ViewPager mViewPager;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private PicCategoryAdapter mCategoryAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected View provideContentView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contentView = super.onCreateView(inflater, container, savedInstanceState);

        TgRepository.getInstance().getCategory()
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<TgClassify>() {
                    @Override
                    public void call(TgClassify tgClassify) {
                        processCategory(tgClassify);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        T.showShort(getContext(), R.string.error_unable_handle);
                    }
                });
        return contentView;
    }

    private void processCategory(TgClassify tgClassify) {
        if (null != tgClassify && tgClassify.isStatus() && null != tgClassify.getTngou()) {
            String[] titles = new String[tgClassify.getTngou().size()];
            int i = 0;
            for (TgClassify.TngouBean bean : tgClassify.getTngou()) {
                mFragments.add(PicFlowFragment.newInstance(bean.getId() + ""));
                titles[i] = bean.getDescription();
                i++;
            }
            mCategoryAdapter = new PicCategoryAdapter(getFragmentManager(), getContext(), mFragments, titles);
            mViewPager.setAdapter(mCategoryAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
        }
    }

}
