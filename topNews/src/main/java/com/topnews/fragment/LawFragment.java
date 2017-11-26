package com.topnews.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.topnews.R;
import com.topnews.tool.AnswerActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class LawFragment extends Fragment {


    public LawFragment() {
        // Required empty public constructor
    }

    View view;
private RelativeLayout demo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_law, container, false);




        return view;
    }

}
