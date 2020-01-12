package com.news.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.entity.User;

/**
 * 拦截器拦截未登录管理员的页面
 * @author linb
 *
 */

@WebFilter(filterName="/AdminPrivilegeFilter",urlPatterns= {"/admin/admin.jsp"})
public class AdminPrivilegeFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// 1 强制转换
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		// 2判断是否具有权限
		User user = (User) request.getSession().getAttribute("adminUser");

		if (user != null && 0==user.getPower()) {
			// 3.放行
			chain.doFilter(request, response);
			return;
		}
			System.out.println("----拦截器拦截到管理员未登录！----");
		response.sendRedirect(request.getContextPath() + "/news/index");

	}

	public void destroy() {

	}

}
