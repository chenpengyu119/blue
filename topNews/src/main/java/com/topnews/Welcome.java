package com.topnews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class Welcome extends Activity implements View.OnClickListener {
	private AlphaAnimation start_anima;
	View view;
	private ImageView start;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		view = View.inflate(this, R.layout.welcome, null);
		setContentView(view);
		initView();
		initData();
	}
	private void initData() {
		start_anima = new AlphaAnimation(0.3f, 1.0f);
		start_anima.setDuration(2000);
		view.startAnimation(start_anima);
		start_anima.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				redirectTo();
			}
		});
	}
	
	private void initView() {
		
	}
	//跳回主活动
	private void redirectTo() {
		//startActivity(new Intent(getApplicationContext(), MainActivity.class));
		//finish();
		start =(android.widget.ImageView)findViewById(R.id.start);
		start.setOnClickListener(this);

	}
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.start:
				startActivity(new Intent(getApplicationContext(), MainActivity.class));
				finish();
			default:
				break;
		}
	}
}