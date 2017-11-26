package com.topnews.fragment;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.topnews.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {

    Fragment fragment_train;
    Fragment fragment_primary;
    Fragment fragment_middle;
    Fragment fragment_cpa;

    FragmentTransaction transaction;

    TextView video_train,video_primary,video_middle,video_cpa;

    public VideoFragment() {
        // Required empty public constructor
    }
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_video, container, false);

        video_train=(TextView)view.findViewById(R.id.video_train);
        video_primary=(TextView)view.findViewById(R.id.video_primary);
        video_middle=(TextView)view.findViewById(R.id.video_middle);
        video_cpa=(TextView)view.findViewById(R.id.video_cpa);

        transaction = getChildFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        selected();
        video_train.setSelected(true);
        fragment_train = new TrainFragment();

        //把要添加的fragment放到父布局的占位区
        transaction.add(R.id.fragment_container_videolist, fragment_train).commit();

        video_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getChildFragmentManager().beginTransaction();
                hideAllFragment(transaction);
                selected();
                video_train.setSelected(true);
                fragment_train = new TrainFragment();
                transaction.add(R.id.fragment_container_videolist, fragment_train).commit();
            }
        });


        video_primary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getChildFragmentManager().beginTransaction();
                hideAllFragment(transaction);
                selected();
                video_primary.setSelected(true);
                fragment_primary = new PrimaryFragment();
                transaction.add(R.id.fragment_container_videolist, fragment_primary).commit();
            }
        });

        video_middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getChildFragmentManager().beginTransaction();
                hideAllFragment(transaction);
                selected();
                video_middle.setSelected(true);
                fragment_middle = new MiddleFragment();
                transaction.add(R.id.fragment_container_videolist, fragment_middle).commit();
            }
        });


        video_cpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getChildFragmentManager().beginTransaction();
                hideAllFragment(transaction);
                selected();
                video_cpa.setSelected(true);
                fragment_cpa = new CpaFragment();
                transaction.add(R.id.fragment_container_videolist, fragment_cpa).commit();
            }
        });






        return view;
    }




    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction) {
        if (fragment_train != null) {
            transaction.hide(fragment_train);
        }
        if (fragment_primary != null) {
            transaction.hide(fragment_primary);
        }
        if (fragment_middle != null) {
            transaction.hide(fragment_middle);
        }
        if (fragment_cpa != null) {
            transaction.hide(fragment_cpa);
        }

    }

    //重置所有文本的选中状态
    public void selected() {
        video_train.setSelected(false);
        video_primary.setSelected(false);
        video_middle.setSelected(false);
        video_cpa.setSelected(false);
    }

}
