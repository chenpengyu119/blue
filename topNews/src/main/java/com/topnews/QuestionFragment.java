package com.topnews;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {
private FrameLayout htextview;

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        htextview=(FrameLayout)getView().findViewById(R.id.fragment_question1);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

}
