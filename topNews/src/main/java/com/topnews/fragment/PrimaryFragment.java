package com.topnews.fragment;


import android.os.Bundle;
import android.app.Fragment;       //一定要用这个，别用support.v4,不然不兼容
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.topnews.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrimaryFragment extends Fragment {


    public PrimaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_primary, container, false);
    }

}
