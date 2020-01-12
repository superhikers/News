package com.news.dao;

import java.util.List;

import com.news.entity.User;
/**
 * 对数据库用户表进行操作的接口 - 用作是用于规范方法
 * @author admin
 *
 */
public interface IUserDao {
	public int chackUser(User u);
	/**
	 * 注册用户的方法
	 * @param u 用户对象
	 * @return 数据库受影响的行数
	 */
	public int regist(User u);
	/**
	 * 登录的方法
	 * @param u 用户对象
	 * @return 登录成功的用户对象
	 */
	public User login(User u);
	
	/**
	 * 获取用户列表
	 * @return list<User>
	 */
	public List<User> getUser();
	/**
	 * 修改用户权限
	 * @param user
	 * @return
	 */
	public int changePower(User user);
}
