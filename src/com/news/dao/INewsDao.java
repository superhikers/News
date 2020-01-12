package com.news.dao;

import java.util.List;

import com.news.entity.News;
/**
 * 对数据库新闻表进行操作的接口 - 用作是用于规范方法
 * @author admin
 *
 */
public interface INewsDao {
	/**
	 * 添加新闻
	 * @param n
	 * @return
	 */
	public int sendNews(News n);
	/**
	 * 修改新闻
	 * @param n
	 * @return
	 */
	public int changeNews(News n);
	/**
	 * 删除新闻
	 * @param n
	 * @return
	 */
	public int deleteNews(News n);
}
