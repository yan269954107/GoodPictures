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
import com.yanxw.goodpictures.common.utils.rx.RxSubscribe;
import com.yanxw.goodpictures.common.utils.rx.RxUtils;
import com.yanxw.goodpictures.model.pic.PicCategories;
import com.yanxw.goodpictures.repository.pic.PicRepository;
import com.yanxw.goodpictures.ui.fragment.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment {

//    private static final int VIEWPAGER_LIMIT_COUNT = 3;

    @BindView(R.id.tl_category)
    TabLayout mTabLayout;

    @BindView(R.id.vp_category)
    ViewPager mViewPager;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private PicCategoryAdapter mCategoryAdapter;

    public HomeFragment() {
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

//        mViewPager.setOffscreenPageLimit(VIEWPAGER_LIMIT_COUNT);
//        TgRepository.getInstance().getCategory()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(tgClassify -> {
//                            processCategory(tgClassify);
//                        },
//                        throwable -> {
//                            throwable.printStackTrace();
//                            ToastUtils.showShort(getContext(), R.string.error_unable_handle);
//                        });
        PicRepository.getInstance().getPicCategories()
                .compose(RxUtils.getTransformer())
                .subscribe(new RxSubscribe<PicCategories>() {
                    @Override
                    protected void _onNext(PicCategories picCategories) {
                        processCategory(picCategories);
                    }
                });
        return contentView;
    }

    private void processCategory(PicCategories picCategories) {
        if (null != picCategories && null != picCategories.getCategories()) {
            String[] titles = new String[picCategories.getCategories().size()];
            int i = 0;
            for (PicCategories.PicCategory category : picCategories.getCategories()) {
                mFragments.add(PicFlowFragment.newInstance(category.getUrl()));
                titles[i] = category.getName();
                i++;
            }
            mCategoryAdapter = new PicCategoryAdapter(getFragmentManager(), getContext(), mFragments, titles);
            mViewPager.setAdapter(mCategoryAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
        }
    }

//    private void processCategory(TgClassify tgClassify) {
//        if (null != tgClassify && tgClassify.isStatus() && null != tgClassify.getTngou()) {
//            String[] titles = new String[tgClassify.getTngou().size()];
//            int i = 0;
//            for (TgClassify.Classify bean : tgClassify.getTngou()) {
//                mFragments.add(PicFlowFragment.newInstance(bean.getId()));
//                titles[i] = bean.getDescription();
//                i++;
//            }
//            mCategoryAdapter = new PicCategoryAdapter(getFragmentManager(), getContext(), mFragments, titles);
//            mViewPager.setAdapter(mCategoryAdapter);
//            mTabLayout.setupWithViewPager(mViewPager);
//        }
//    }

}
