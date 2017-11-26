package com.topnews;

//目前没用这个Activity

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.topnews.fragment.IndexFragment;
import com.topnews.fragment.InfoFragment;
import com.topnews.fragment.MyFragment;
import com.topnews.fragment.QuestionFragment;


public class MyNewIndexActivity extends Activity implements View.OnClickListener {

    //这是活动里面的一个占位符，其他fragment都放在这里


    //定义接收四个fragment,注意看四个fragment里面导入的是哪个app.fragment,android.app.fragment和supportv4.app.fragment不兼容
    Fragment f1 = new QuestionFragment();
    Fragment f2 = new IndexFragment();
    Fragment f3 = new InfoFragment();
    Fragment f4 = new MyFragment();


    private TextView txt_index, txt_work, txt_info, txt_my;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_new_index);
       // question = (FrameLayout) findViewById(R.id.fragment_question1);

        bindView();
       // FragmentManager frgManager = getFragmentManager();
        // frgManager.beginTransaction().replace(R.id.fragment_question1, fragment).commit();
       // frgManager.beginTransaction().show(f1);

    }

    //UI组件初始化与事件绑定
    private void bindView() {
        txt_index = (TextView) this.findViewById(R.id.txt_index);
        txt_work = (TextView) this.findViewById(R.id.txt_work);
        txt_info = (TextView) this.findViewById(R.id.txt_info);
        txt_my = (TextView) this.findViewById(R.id.txt_my);

        txt_index.setOnClickListener(this);
        txt_work.setOnClickListener(this);
        txt_info.setOnClickListener(this);
        txt_my.setOnClickListener(this);
    }

    //重置所有文本的选中状态
    public void selected() {
        txt_index.setSelected(false);
        txt_work.setSelected(false);
        txt_info.setSelected(false);
        txt_my.setSelected(false);
    }

    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction) {
        if (f1 != null) {
            transaction.hide(f1);
        }
        if (f2 != null) {
            transaction.hide(f2);
        }
        if (f3 != null) {
            transaction.hide(f3);
        }
        if (f4 != null) {
            transaction.hide(f4);
        }

    }


    //事件响应
    public void onClick(View v) {
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);

        switch (v.getId()) {
            case R.id.txt_index:
                selected();
                txt_index.setSelected(true);
                if (f1 == null) {
                    f1 = new QuestionFragment();


                    transaction.add(R.id.fragment_container, f1);
                } else {
                transaction.show(f1);
        }
        break;


        case R.id.txt_work:
        selected();

        txt_work.setSelected(true);
        if (f2 == null) {
            f2 = new QuestionFragment();
            transaction.add(R.id.fragment_container, f2);
        } else {
            transaction.show(f2);
        }

        // Intent intent = new Intent(this, Register.class);
        //  startActivity(intent);
        break;

        case R.id.txt_info:
        selected();
        txt_info.setSelected(true);
        if (f3 == null) {
            f3 = new InfoFragment();
            transaction.add(R.id.fragment_container, f3);
        } else {
            transaction.show(f3);
        }
        break;

        case R.id.txt_my:
        selected();
        txt_my.setSelected(true);
        if (f4 == null) {
            f4 = new MyFragment();
            transaction.add(R.id.fragment_container, f4);
        } else {
            transaction.show(f4);
        }
        break;
    }




        transaction.commit();
    }



}
