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
 * 注册
 */
@WebServlet("/news/register")
public class RegisterServlet extends HttpServlet {
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
		String password2 = request.getParameter("password2");
		
		System.out.println(username+"----"+password);
		//判断密码是否一致
		if(!password.equals(password2)) {
			request.setAttribute("unLoginInfo", "两次密码不一致！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return ;
		}
		//判断数据的有效性
		if(username == null || "".equals(username) ||
				password == null || "".equals(password)) {
			//如果数据有问题，直接重定向到登录页面
//			response.sendRedirect("login.jsp");
			request.setAttribute("unLoginInfo", "用户名或密码为空！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		//如果数据没有问题，执行下面的操作
		User u = new User(username, password);
		//判断用户是否是已经注册的用户
		int uNum = UserService.checkUser(u);
		
		HttpSession session = request.getSession();
		//注册成功，将用户对象放到session对象中 
		if(uNum==0) {
			UserService.regist(u);
			request.setAttribute("unLoginInfo", "");
//			response.sendRedirect("index.jsp");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			//注册失败，跳转到登录页面
//			response.sendRedirect("login.jsp");
			request.setAttribute("unLoginInfo", "用户名已存在！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}
}
