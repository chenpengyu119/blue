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
import com.topnews.VideoPlayActivity;
import com.topnews.tool.AnswerActivity;
import com.topnews.view.ShuatiActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class LawFragment extends Fragment {
    View view;
    private RelativeLayout law_chapter,law_real,law_favorite;

    public LawFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_law, container, false);

        law_chapter=(RelativeLayout)view.findViewById(R.id.law_chapter);
        law_favorite=(RelativeLayout)view.findViewById(R.id.law_favorite);
        law_real=(RelativeLayout)view.findViewById(R.id.law_real);


        //章节练习
        law_chapter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), AnswerActivity.class);

                intent1.putExtra("pre", "law_chapter");
                startActivity(intent1);
            }
        });

        //真题
        law_real.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getActivity(), VideoPlayActivity.class);
                intent2.putExtra("KEY_URL", "192.168.191.1:8080/Test/1.mp4");
                startActivity(intent2);
            }
        });


        //收藏
        law_favorite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), ShuatiActivity.class);
                startActivity(intent1);
            }
        });




        return view;
    }

}
