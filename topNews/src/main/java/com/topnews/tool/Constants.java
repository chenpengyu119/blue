package com.topnews.tool;

import java.util.ArrayList;
import java.util.List;

import com.topnews.bean.NewsClassify;
import com.topnews.bean.NewsEntity;

public class Constants {
	public static ArrayList<NewsClassify> getData() {
		ArrayList<NewsClassify> newsClassify = new ArrayList<NewsClassify>();
		NewsClassify classify = new NewsClassify();

		classify.setId(0);
		classify.setTitle("首页");
		newsClassify.add(classify);

		classify = new NewsClassify();
		classify.setId(1);
		classify.setTitle("题库");
		newsClassify.add(classify);

		classify = new NewsClassify();
		classify.setId(2);
		classify.setTitle("资讯");
		newsClassify.add(classify);

		classify = new NewsClassify();
		classify.setId(3);
		classify.setTitle("我的");
		newsClassify.add(classify);

		classify = new NewsClassify();
		classify.setId(4);
		classify.setTitle("通知");
		newsClassify.add(classify);

		classify = new NewsClassify();
		classify.setId(5);
		classify.setTitle("关于");
		newsClassify.add(classify);


		return newsClassify;
	}

	public static ArrayList<NewsEntity> getNewsList() {
		ArrayList<NewsEntity> newsList = new ArrayList<NewsEntity>();
		for(int i =0 ; i < 10 ; i++){
			NewsEntity news = new NewsEntity();
			news.setId(i);
			news.setNewsId(i);
			news.setCollectStatus(false);
			news.setCommentNum(i + 10);
			news.setInterestedStatus(true);
			news.setLikeStatus(true);
			news.setReadStatus(false);
			news.setNewsCategory("头条");
			news.setNewsCategoryId(1);
			news.setTitle("[注会]真题回忆及讨论：审计|财管|经济法");
			List<String> url_list = new ArrayList<String>();
			if(i%2 == 1){
				String url1 = "http://www.dongao.com/upload/resources/image/2017/10/12/101355_363x225.jpg";
				String url2 = "http://www.dongao.com/upload/resources/image/2017/10/14/102066_500x500.jpg";
				String url3 = "hhttp://www.dongao.com/upload/resources/image/2017/10/14/102068.png";
				news.setPicOne(url1);
				news.setPicTwo(url2);
				news.setPicThr(url3);
				url_list.add(url1);
				url_list.add(url2);
				url_list.add(url3);
			}else{
				news.setTitle("[直播]15日免费直播：注会考后试卷点评");
				String url = "http://www.dongao.com/upload/resources/image/2017/10/14/102069.jpg";
				news.setPicOne(url);
				url_list.add(url);
			}
			news.setPicList(url_list);
			news.setPublishTime(Long.valueOf(i));
			news.setReadStatus(false);
			news.setSource("中华会计网校");
			news.setSummary("　2017年注册会计师考试于10月14日、15日两天举行，今天是考试的第一天，东奥小编就接到了很多学员的反馈，有说审计考试题出题非常良心的，有说财管虽然题不难，但是计算量非常大，还有的地区不让携带科学计算器等等，现东奥小编将这些内容整理出来。");
			news.setMark(i);
			if(i == 4){
				news.setTitle("部落战争强势回归");
				news.setLocal("推广");
				news.setIsLarge(true);
				String url = "http://imgt2.bdstatic.com/it/u=3269155243,2604389213&fm=21&gp=0.jpg";
				news.setPicOne(url);
				url_list.clear();
				url_list.add(url);
			}else{
				news.setIsLarge(false);
			}
			if(i == 2){
				news.setComment("讲的不错。");
			}
			newsList.add(news);
		}
		return newsList;
	}

	/** mark=0 ：推荐 */
	public final static int mark_recom = 0;
	/** mark=1 ：热门 */
	public final static int mark_hot = 1;
	/** mark=2 ：首发 */
	public final static int mark_frist = 2;
	/** mark=3 ：独家 */
	public final static int mark_exclusive = 3;
	/** mark=4 ：收藏 */
	public final static int mark_favor = 4;
}
