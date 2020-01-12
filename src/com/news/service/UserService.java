package com.news.service;

import java.util.Date;
import java.util.List;

import com.news.dao.IUserDao;
import com.news.dao.UserDao;
import com.news.entity.User;


/**
 * 用户相关的服务类，里面提供用户操作相关的方法
 * @author admin
 *
 */
public class UserService {
	//将访问数据库的对应方法引入到当前方法
	public static IUserDao ud = new UserDao();
	
	/**
	 * 执行注册操作的业务，如果有一些默认数据，可以在此处设置
	 * @param u 用户对象
	 * @return 数据库受影响的行数
	 */
	public static int regist(User u) {
		//在服务层中，可以对数据进行处理，这个一般不会在访问数据库的地方做，而在当前类中实现
		
		return ud.regist(u);
	}
	
	/**
	 * 执行登录的业务
	 * @param u
	 * @return
	 */
	public static User login(User u) {
		return ud.login(u);
	}
	
	public static int checkUser(User u) {
		return ud.chackUser(u);
	}
	
	/**
	 * 获取用户列表
	 * @return List<User>
	 */
	public static List<User> getUser(){
		return ud.getUser();
	}
	
	public static int changePower(User user) {
		return ud.changePower(user);
		
	}
	
}
