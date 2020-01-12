package com.news.dao;

import java.util.List;

import com.news.entity.News;

/**
 * 对数据库用户表进行操作的接口 - 用作是用于规范方法
 * @author lb
 *
 */
public interface IShowIndexDao {
	/**
	 * 获取轮播图新闻列表
	 * @param 
	 * @return 轮播图新闻列表
	 */
	public List<News> showBannerNews(News n);
	/**
	 * 获取首页新闻列表
	 * @param 
	 * @return 首页新闻列表
	 */
	public List<News> showAll(News n);
	/**
	 * 根据id获取新闻
	 * @param n
	 * @return
	 */
	public News getNew(News n);
	
	
}
