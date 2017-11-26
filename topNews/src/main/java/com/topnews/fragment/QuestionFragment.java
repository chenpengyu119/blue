package com.topnews.fragment;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.topnews.MyNewIndexActivity;
import com.topnews.R;
import com.topnews.VideoPlayActivity;
import com.topnews.tool.AnswerActivity;
import com.topnews.view.ShuatiActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    TextView subject_base,subject_law;

    public QuestionFragment() {
        // Required empty public constructor
    }
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //接收fragment的xml布局文件fragment_question
        view = inflater.inflate(R.layout.fragment_question,container,false);

      //  Button btn = (Button) view.findViewById(R.id.dati);
      //  ImageView shixun=(ImageView) view.findViewById(R.id.kjshixun);


        subject_base=(TextView)view.findViewById(R.id.subject_base);
        //会计基础监听事件
        subject_base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(), ShuatiActivity.class);
                startActivity(intent1);
            }
        });

        subject_law=(TextView)view.findViewById(R.id.subject_law);
        //财经法规监听事件
        subject_law.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent1=new Intent(getActivity(), AnswerActivity.class);
              //  startActivity(intent1);
                Fragment videoFragment = new BaseFragment();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.add(R.id.fragment_container_subject, videoFragment).commit();
            }
        });




        return view;

    }











}
