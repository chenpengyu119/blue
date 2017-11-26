package com.topnews;

import java.util.ArrayList;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.topnews.bean.NewsClassify;
import com.topnews.fragment.IndexFragment;
import com.topnews.fragment.InfoFragment;
import com.topnews.fragment.MyFragment;
import com.topnews.fragment.QuestionFragment;
import com.topnews.tool.BaseTools;
import com.topnews.tool.Constants;
import com.topnews.view.ColumnHorizontalScrollView;
import com.topnews.view.DrawerView;
import com.topnews.view.ShuatiActivity;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements View.OnClickListener{



    //这是活动里面的一个占位符，其他fragment都放在这里
    private FrameLayout fragment_container;

    //定义接收四个fragment,注意看四个fragment里面导入的是哪个app.fragment,android.app.fragment和supportv4.app.fragment不兼容
    android.app.Fragment f1 = new IndexFragment();
    android.app.Fragment f2 = new QuestionFragment();
    android.app.Fragment f3 = new InfoFragment();
    android.app.Fragment f4 = new MyFragment();


    private TextView txt_index, txt_work, txt_info, txt_my;

	/** 自定义HorizontalScrollView */
	private ColumnHorizontalScrollView mColumnHorizontalScrollView;
	LinearLayout mRadioGroup_content;
	LinearLayout ll_more_columns;
	RelativeLayout rl_column;
	private ViewPager mViewPager;
	/** 新闻分类列表*/
	private ArrayList<NewsClassify> newsClassify=new ArrayList<NewsClassify>();
	/** 当前选中的栏目*/
	private int columnSelectIndex = 0;
	/** 左阴影部分*/
	public ImageView shade_left;
	/** 右阴影部分 */
	public ImageView shade_right;
	/** 屏幕宽度 */
	private int mScreenWidth = 0;
	/** Item宽度 */
	private int mItemWidth = 0;
	private ArrayList<Fragment> fragments = new ArrayList<Fragment>();

	protected SlidingMenu side_drawer;

	/** head 头部 的中间的loading*/
	private ProgressBar top_progress;
	/** head 头部 中间的刷新按钮*/
	private ImageView top_refresh;
	/** head 头部 的左侧菜单 按钮*/
	private ImageView top_head;
	/** head 头部 的右侧菜单 按钮*/
	private ImageView top_more;


    //questionfragment控件
    ImageView kjshixun;
    ImageView chuji;
    ImageView zhongji;
    ImageView zhukuai;

    TextView back; //返回按钮
    TextView title;//标题栏文字




	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mScreenWidth = BaseTools.getWindowsWidth(this);
		mItemWidth = mScreenWidth / 7;// 一个Item宽度为屏幕的1/7
		initView();
		initSlidingMenu();

        bindView();
	}
	/** 初始化layout控件*/
	private void initView() {

		top_head = (ImageView) findViewById(R.id.top_head);
		top_more = (ImageView) findViewById(R.id.top_more);

		top_progress = (ProgressBar) findViewById(R.id.top_progress);

		top_head.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(side_drawer.isMenuShowing()){
					side_drawer.showContent();
				}else{
					side_drawer.showMenu();
				}
			}
		});
		top_more.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(side_drawer.isSecondaryMenuShowing()){
					side_drawer.showContent();
				}else{
					side_drawer.showSecondaryMenu();
				}
			}
		});

		setChangelView();


        //questionfragment

        back = (TextView)findViewById(R.id.back);
        title = (TextView)findViewById(R.id.title);



/*		dongtu=(Button)findViewById(R.id.dongtu);
        dongtu.setOnClickListener(this);

        dati=(Button)findViewById(R.id.dati);
        dati.setOnClickListener(this);*/

       // back.setOnClickListener(this);
	}
	/**
	 *  当栏目项发生变化时候调用
	 * */
	private void setChangelView() {
		initColumnData();
		//initTabColumn();
	//	initFragment();
	}
	/** 获取Column栏目 数据*/
	private void initColumnData() {
		newsClassify = Constants.getData();
	}


	private void selectTab(int tab_postion) {
		columnSelectIndex = tab_postion;
		for (int i = 0; i < mRadioGroup_content.getChildCount(); i++) {
			View checkView = mRadioGroup_content.getChildAt(tab_postion);
			int k = checkView.getMeasuredWidth();
			int l = checkView.getLeft();
			int i2 = l + k / 2 - mScreenWidth / 2;
			// rg_nav_content.getParent()).smoothScrollTo(i2, 0);
			mColumnHorizontalScrollView.smoothScrollTo(i2, 0);
			// mColumnHorizontalScrollView.smoothScrollTo((position - 2) *
			// mItemWidth , 0);
		}
		//判断是否选中
		for (int j = 0; j <  mRadioGroup_content.getChildCount(); j++) {
			View checkView = mRadioGroup_content.getChildAt(j);
			boolean ischeck;
			if (j == tab_postion) {
				ischeck = true;
			} else {
				ischeck = false;
			}
			checkView.setSelected(ischeck);
		}
	}

	/*

	/**
	 *  ViewPager切换监听方法
	 * */
	public OnPageChangeListener pageListener= new OnPageChangeListener(){

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@TargetApi(Build.VERSION_CODES.GINGERBREAD)
		@Override
		public void onPageSelected(int position) {
			// TODO Auto-generated method stub
			mViewPager.setCurrentItem(position);
			selectTab(position);
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	protected void initSlidingMenu() {
		side_drawer = new DrawerView(this).initSlidingMenu();
	}

	private long mExitTime;
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if(side_drawer.isMenuShowing() ||side_drawer.isSecondaryMenuShowing()){
				side_drawer.showContent();
			}else {
				if ((System.currentTimeMillis() - mExitTime) > 2000) {
					Toast.makeText(this, "再按一次退出",
							Toast.LENGTH_SHORT).show();
					mExitTime = System.currentTimeMillis();
				} else {
					finish();
				}
			}
			return true;
		}
		//拦截MENU按钮点击事件，让他无任何操作
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}



	//开始Fragment的表演

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
             /*   if (f2 == null) {  */
                    f2 = new QuestionFragment();
                    transaction.add(R.id.fragment_container, f2);
             //   } else {
                    transaction.show(f2);
                //}

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



            case R.id.back:
                onBackPressed();
                break;


        /*      case R.id.dongtu:
                Intent intent1=new Intent(this, MyNewIndexActivity.class);
                startActivity(intent1);
                break;

            case R.id.dati:
                Intent intent2=new Intent(this, ShuatiActivity.class);//AnswerActivity
                startActivity(intent2);
                break;*/
        }



		//不能删除，否则不显示fragment
        transaction.commit();
    }











}
