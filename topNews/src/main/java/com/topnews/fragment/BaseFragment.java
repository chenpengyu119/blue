package com.topnews.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.topnews.R;
import com.topnews.tool.AnswerActivity;
import com.topnews.view.ShuatiActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {
    View view;
    private RelativeLayout base_chapter,base_favorite,base_real;
    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_base, container, false);

        base_chapter=(RelativeLayout)view.findViewById(R.id.base_chapter);
        base_favorite=(RelativeLayout)view.findViewById(R.id.base_favorite);
        base_real=(RelativeLayout)view.findViewById(R.id.base_real);


        //章节练习
        base_chapter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1;

                intent1=new Intent(getActivity(), AnswerActivity.class);


                intent1.putExtra("pre", "base_chapter");//传值，判断选择哪个数据库表的试题

                startActivity(intent1);
            }
        });

        //真题
        base_real.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), AnswerActivity.class);
                intent1.putExtra("pre", "base_real");
                startActivity(intent1);
            }
        });


        //收藏
        base_favorite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), ShuatiActivity.class);
                startActivity(intent1);
            }
        });







        return view;
    }

}
