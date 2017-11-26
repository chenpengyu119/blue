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
public class TaxFragment extends Fragment {
    View view;
    private RelativeLayout tax_chapter,tax_real,tax_favorite;

    public TaxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_tax, container, false);

        tax_chapter=(RelativeLayout)view.findViewById(R.id.tax_chapter);
        tax_favorite=(RelativeLayout)view.findViewById(R.id.tax_favorite);
        tax_real=(RelativeLayout)view.findViewById(R.id.tax_real);


        //章节练习
        tax_chapter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), AnswerActivity.class);
                startActivity(intent1);
            }
        });

        //真题
        tax_real.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), ShuatiActivity.class);
                startActivity(intent1);
            }
        });


        //收藏
        tax_favorite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), ShuatiActivity.class);
                startActivity(intent1);
            }
        });



        return view;
    }

}
