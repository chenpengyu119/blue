package com.topnews.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.topnews.R;
import com.topnews.tool.AnswerActivity;
import com.topnews.view.ShuatiActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComputerFragment extends Fragment {
    View view;
    private RelativeLayout computer_chapter,computer_real,computer_favorite;

    public ComputerFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_computer, container, false);

        computer_chapter=(RelativeLayout)view.findViewById(R.id.computer_chapter);
        computer_favorite=(RelativeLayout)view.findViewById(R.id.computer_favorite);
        computer_real=(RelativeLayout)view.findViewById(R.id.computer_real);


        //章节练习
        computer_chapter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), AnswerActivity.class);
                intent1.putExtra("pre", "computer_chapter");
                startActivity(intent1);
            }
        });

        //真题
        computer_real.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getActivity(), AnswerActivity.class);
                intent2.putExtra("pre", "computer_real");
                startActivity(intent2);
            }
        });


        //收藏
        computer_favorite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), ShuatiActivity.class);
                startActivity(intent1);
            }
        });








        return view;
    }

}
