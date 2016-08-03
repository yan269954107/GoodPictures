package com.yanxw.goodpictures.ui.fragment.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanxw.goodpictures.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GifFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GifFragment extends Fragment {

    public GifFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment GifFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GifFragment newInstance() {
        GifFragment fragment = new GifFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gif, container, false);
    }

}
