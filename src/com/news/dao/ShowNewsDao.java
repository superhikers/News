package com.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.entity.News;
import com.news.util.DBUtil;

public class ShowNewsDao implements IShowIndexDao {

	@Override
	public List<News> showBannerNews(News n) {

		// 先定义一个空对象，如果方法执行过程有异常，外面就是接收到null
		List<News> newsList = new ArrayList<News>();
		// 获取数据库连接对象
		Connection conn = DBUtil.getConn();

		if (conn != null) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			// 定义SQL语句
			String sql = "select * from news_ where type = ? ";
			try {
				// 编译SQL语句
				pstmt = conn.prepareStatement(sql);
				// 进行查询
				pstmt.setObject(1, n.getType());
				rs = pstmt.executeQuery();
				// 多结果的时候，使用循环
				// rs.next()用于判断是否有下一条（也就是是否有数据）
				while (rs.next()) {
					// 构造对象
					News news = new News(rs.getInt("id"),rs.getString("title"), rs.getString("type"), rs.getString("content"),
							rs.getString("author"), rs.getDate("date"), rs.getString("img"));
					newsList.add(news);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// 关闭资源
				DBUtil.closeAll(conn, pstmt, rs);
			}
		}

		return newsList;

	}

	@Override
	public List<News> showAll(News n) {
		// 先定义一个空对象，如果方法执行过程有异常，外面就是接收到null
		List<News> newsList = new ArrayList<News>();
		// 获取数据库连接对象
		Connection conn = DBUtil.getConn();

		if (conn != null) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			// 定义SQL语句
			String sql = "select * from news_  ";
			try {
				// 编译SQL语句
				pstmt = conn.prepareStatement(sql);
				// 进行查询
				rs = pstmt.executeQuery();
				// 多结果的时候，使用循环
				// rs.next()用于判断是否有下一条（也就是是否有数据）
				while (rs.next()) {
					// 构造对象
					News news = new News(rs.getInt("id"),rs.getString("title"), rs.getString("type"), rs.getString("content"),
							rs.getString("author"), rs.getDate("date"), rs.getString("img"));
					newsList.add(news);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// 关闭资源
				DBUtil.closeAll(conn, pstmt, rs);
			}
		}
		return newsList;
	}

	@Override
	public News getNew(News n) {

		// 先定义一个空对象，如果方法执行过程有异常，外面就是接收到null
		News news = new News();
		// 获取数据库连接对象
		Connection conn = DBUtil.getConn();

		if (conn != null) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			// 定义SQL语句
			String sql = "select * from news_ where id = ? ";
			try {
				// 编译SQL语句
				pstmt = conn.prepareStatement(sql);
				
				// 进行查询
				pstmt.setObject(1, n.getId());
				rs = pstmt.executeQuery();
				// 多结果的时候，使用循环
				// rs.next()用于判断是否有下一条（也就是是否有数据）
				if (rs.next()) {
					// 构造对象
					news = new News(rs.getInt("id"),rs.getString("title"), rs.getString("type"), rs.getString("content"),
							rs.getString("author"), rs.getDate("date"), rs.getString("img"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// 关闭资源
				DBUtil.closeAll(conn, pstmt, rs);
			}
		}
		return news;
	}
}
