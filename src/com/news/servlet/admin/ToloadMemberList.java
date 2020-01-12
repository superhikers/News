package com.news.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.entity.User;
import com.news.service.UserService;



/**
 * 加载用户列表
 */
@WebServlet("/admin/member-list")
public class ToloadMemberList extends HttpServlet {
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
		int id = -1;
		int power = -1;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			power = Integer.parseInt(request.getParameter("power"));
		} catch (Exception e) {
			System.out.println("---未获取id和power----");
		}System.out.println(id+"---:id  power:--"+power);
		if(id!=-1&&power!=-1) {
			if(power==1) {power=0;}else {power=1;}
			User user = new User();
			user.setId(id);
			user.setPower(power);
			UserService.changePower(user);
		}
		List<User> userList = new ArrayList<User>();
		userList = UserService.getUser();
		request.setAttribute("userList", userList);
		System.out.println(userList.toString()); 
		//response.sendRedirect(request.getContextPath() + "/news/index.jap");
		request.getRequestDispatcher("member-list.jsp").forward(request, response);
	}
}





