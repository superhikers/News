package com.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.entity.User;
import com.news.service.UserService;


/**
 * Servlet implementation class LogonServlet
 */
@WebServlet("/news/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//获取用户的输入
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"----"+password);
		//判断数据的有效性
		if(username == null || "".equals(username) ||
				password == null || "".equals(password)) {
			//如果数据有问题，直接重定向到登录页面
//			response.sendRedirect("login.jsp");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		//如果数据没有问题，执行下面的操作
		User u = new User(username, password);
		//判断用户是否是已经注册的用户
		User loginUser = UserService.login(u);
		//System.out.println(loginUser.toString());
		HttpSession session = request.getSession();
		//判断是否是管理员用户
		//登录成功，将用户对象放到session对象中 
		if(loginUser!=null) {
			if(loginUser.getPower()==0) {
				session.setAttribute("adminUser", loginUser);
				response.sendRedirect("../admin/admin.jsp");
				//request.getRequestDispatcher("../admin/admin.jsp").forward(request, response);
				//request.getRequestDispatcher("../admin/admin.jsp").forward(request, response);
				return;
			}
			System.out.println(loginUser.toString());
			session.setAttribute("user", loginUser);
			request.setAttribute("unLoginInfo", "");
			//查询所有商品并显示到首页
//			response.sendRedirect("index.jsp");
			request.getRequestDispatcher("index").forward(request, response);
		}else {
			//登录失败，跳转到登录页面
//			response.sendRedirect("login.jsp");
			request.setAttribute("unLoginInfo", "用户名或密码有误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
