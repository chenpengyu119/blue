package com.topnews;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.topnews.R;
import com.topnews.base.BaseActivity;
import com.topnews.tool.AnswerActivity;
import com.topnews.tool.TwoActivity;
import com.topnews.view.ShuatiActivity;

public class QusetionActivity extends BaseActivity implements View.OnClickListener {
    ImageView kjshixun;
    ImageView chuji;
    ImageView zhongji;
    ImageView zhukuai;

    TextView back; //返回按钮
    TextView title;//标题栏文字

    private Button video;
    private Button dongtu;

    private Button dati;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        initView();
        initData();
    }

    private void initData() {
        title.setText("选择科目");
    }


    private void initView() {
        back = (TextView)findViewById(R.id.back);
        title = (TextView)findViewById(R.id.title);
        kjshixun=(ImageView)findViewById(R.id.kjshixun);
        chuji=(ImageView)findViewById(R.id.chuji);
        zhongji=(ImageView)findViewById(R.id.zhongji);
        zhukuai=(ImageView)findViewById(R.id.zhukuai);

        video=(Button)findViewById(R.id.video);
        video.setOnClickListener(this);

        dongtu=(Button)findViewById(R.id.dongtu);
        dongtu.setOnClickListener(this);

        dati=(Button)findViewById(R.id.dati);
        dati.setOnClickListener(this);

        back.setOnClickListener(this);

    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
//		overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kjshixun:

                break;
            case R.id.chuji:
                onBackPressed();
                break;
            case R.id.zhongji:
                onBackPressed();
                break;

            case R.id.zhukuai:
                onBackPressed();
                break;

            case R.id.back:
                onBackPressed();
                break;

            case R.id.video:
                String url = "https://media.w3.org/2010/05/sintel/trailer.mp4";
                Intent intent = new Intent();
                intent.setClass(this, VideoPlayActivity.class);
                intent.putExtra(VideoPlayActivity.KEY_URL, url);
                startActivity(intent);
                break;
            case R.id.dongtu:
                Intent intent1=new Intent(this, MyNewIndexActivity.class);
                startActivity(intent1);
                break;

            case R.id.dati:
                Intent intent2=new Intent(this, ShuatiActivity.class);//AnswerActivity
                startActivity(intent2);
                break;



            default:
                break;
        }
    }
}
