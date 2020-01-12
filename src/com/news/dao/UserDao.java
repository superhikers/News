package com.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.entity.User;
import com.news.util.DBUtil;

/**
 * 访问数据库用户表的实现类
 * @author admin
 *
 */
public class UserDao implements IUserDao {

	@Override
	public int regist(User u) {
		//先让值等于-1，如果代码错误，就是返回-1
		int count = -1;
		//获取数据库连接对象
		Connection conn = DBUtil.getConn();
		//连接对象不为空才可以进行数据库操作
		if(conn!=null) {
			PreparedStatement pstmt = null;
			//定义SQL语句
			String sql = "insert into user (username,password) values(?,?)";
			try {
				//编译SQL语句
				pstmt = conn.prepareStatement(sql);
				//对SQL的？进行赋值
				pstmt.setObject(1, u.getUsername());
				pstmt.setObject(2, u.getPassword());
				//执行SQL语句，返回受影响的行数
				count = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				//关闭资源
				DBUtil.closeAll(conn, pstmt, null);
			}
		}
		return count;
	}

	@Override
	public User login(User u) {
		//先定义一个空对象，如果方法执行过程有异常，外面就是接收到null
		User loginUser = null;
		//获取数据库连接对象
		Connection conn = DBUtil.getConn();
		//连接对象不为空才可以进行数据库操作
		if(conn!=null) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			//定义SQL语句
			String sql = "select * from user where username = ? and password = ?";
			try {
				//编译SQL语句
				pstmt = conn.prepareStatement(sql);
				//对SQL的？进行赋值
				pstmt.setObject(1, u.getUsername());
				pstmt.setObject(2, u.getPassword());
				rs = pstmt.executeQuery();
				//单结果只需要用if
				//rs.next()用于判断是否有下一条（也就是是否有数据）
				if(rs.next()) {
					loginUser = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),rs.getInt("power"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				//关闭资源
				DBUtil.closeAll(conn, pstmt, rs);
			}
		}
		
		return loginUser;
	}

	@Override
	public int chackUser(User u) {
		//先定义一个空对象，如果方法执行过程有异常，外面就是接收到null
				User loginUser = null;
				//获取数据库连接对象
				Connection conn = DBUtil.getConn();
				int i = 0;
				//连接对象不为空才可以进行数据库操作
				if(conn!=null) {
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					//定义SQL语句
					String sql = "select * from user where username = ? ";
					try {
						//编译SQL语句
						pstmt = conn.prepareStatement(sql);
						//对SQL的？进行赋值
						pstmt.setObject(1, u.getUsername());
						rs = pstmt.executeQuery();
						//单结果只需要用if
						//rs.next()用于判断是否有下一条（也就是是否有数据）
						if(rs.next()) {
							i++;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						//关闭资源
						DBUtil.closeAll(conn, pstmt, rs);
					}
				}
				
				return i;
	}

	@Override
	public List<User> getUser() {
		
		//先定义一个空对象，如果方法执行过程有异常，外面就是接收到null
				List<User> userList = new ArrayList<User>();
				//获取数据库连接对象
				Connection conn = DBUtil.getConn();
				//连接对象不为空才可以进行数据库操作
				if(conn!=null) {
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					//定义SQL语句
					String sql = "select * from user ";
					try {
						//编译SQL语句
						pstmt = conn.prepareStatement(sql);
						//对SQL的？进行赋值
						rs = pstmt.executeQuery();
						//单结果只需要用if
						//rs.next()用于判断是否有下一条（也就是是否有数据）
						while(rs.next()) {
							User User = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),rs.getInt("power"));
							userList.add(User);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						//关闭资源
						DBUtil.closeAll(conn, pstmt, rs);
					}
				}
				
				return userList;
	}

	@Override
	public int changePower(User user) {
		//先定义一个空对象，如果方法执行过程有异常，外面就是接收到null
		User loginUser = null;
		//获取数据库连接对象
		Connection conn = DBUtil.getConn();
		int i = 1;
		//连接对象不为空才可以进行数据库操作
		if(conn!=null) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			//定义SQL语句
			String sql = "UPDATE user SET POWER = ? WHERE id = ?  ";
			try {
				//编译SQL语句
				pstmt = conn.prepareStatement(sql);
				//对SQL的？进行赋值
				pstmt.setObject(1, user.getPower());
				pstmt.setObject(2, user.getId());
				pstmt.executeUpdate();
				//单结果只需要用if
				//rs.next()用于判断是否有下一条（也就是是否有数据）
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				//关闭资源
				DBUtil.closeAll(conn, pstmt, rs);
			}
		}
		
		return i;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
