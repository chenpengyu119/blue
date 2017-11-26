package com.topnews.fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.topnews.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    private RelativeLayout base_chapter,base_favorite,base_real;

    Fragment baseFragment;
    Fragment lawFragment;
    Fragment taxFragment;
    Fragment computerFragment;

    FragmentTransaction transaction;

    TextView subject_base,subject_law,subject_tax,subject_computer;

    public QuestionFragment() {
        // Required empty public constructor
    }
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //接收fragment的xml布局文件fragment_question
        view = inflater.inflate(R.layout.fragment_question,container,false);

        subject_base=(TextView)view.findViewById(R.id.subject_base);
        subject_law=(TextView)view.findViewById(R.id.subject_law);
        subject_tax=(TextView)view.findViewById(R.id.subject_tax);
        subject_computer=(TextView)view.findViewById(R.id.subject_computer);

        transaction = getChildFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        selected();
        subject_base.setSelected(true);
        baseFragment = new BaseFragment();
        transaction.add(R.id.fragment_container_subject, baseFragment).commit();

        //会计基础监听事件
        subject_base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getChildFragmentManager().beginTransaction();

                hideAllFragment(transaction);
                selected();
                subject_base.setSelected(true);
                baseFragment = new BaseFragment();
                transaction.add(R.id.fragment_container_subject, baseFragment).commit();
            }
        });

        //财经法规监听事件
        subject_law.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               transaction = getChildFragmentManager().beginTransaction();
                hideAllFragment(transaction);
                selected();
                subject_law.setSelected(true);
                lawFragment = new LawFragment();
                transaction.add(R.id.fragment_container_subject, lawFragment).commit();

            }
        });

        //财税主管
        subject_tax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getChildFragmentManager().beginTransaction();
                hideAllFragment(transaction);
                selected();
                subject_tax.setSelected(true);
                taxFragment = new TaxFragment();
                transaction.add(R.id.fragment_container_subject, taxFragment).commit();

            }
        });

        //会计电算化
        subject_computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getChildFragmentManager().beginTransaction();
                hideAllFragment(transaction);
                selected();
                subject_computer.setSelected(true);
                computerFragment = new ComputerFragment();
                transaction.add(R.id.fragment_container_subject, computerFragment).commit();
            }
        });

        return view;
    }

    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction) {
        if (baseFragment != null) {
            transaction.hide(baseFragment);
        }
        if (lawFragment != null) {
            transaction.hide(lawFragment);
        }
       if (taxFragment != null) {
            transaction.hide(taxFragment);
        }
        if (computerFragment != null) {
            transaction.hide(computerFragment);
        }

    }

    //重置所有文本的选中状态
    public void selected() {
        subject_base.setSelected(false);
        subject_computer.setSelected(false);
        subject_tax.setSelected(false);
        subject_law.setSelected(false);
    }

}
