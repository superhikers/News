package com.news.servlet.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.news.entity.News;
import com.news.service.NewsService;



/**
 * 发布新闻
 */
@WebServlet("/admin/deleteNews")
public class DeleteNews extends HttpServlet {
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
		
		
		response.setContentType("text/html;charset=utf-8");
		//PrintWriter writer = response.getWriter();
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		News news = new News();
		//获取id
		String id = request.getParameter("id");
		System.out.println(id+"------------id________-----");
		news.setId(Integer.parseInt(id));
		int i = NewsService.deleteNews(news);
		if(i==1) {
			request.setAttribute("changeInfo", "<script>alert(\"删除成功！\")</script>");
		}else {
			request.setAttribute("changeInfo", "<script>alert(\"删除失败！\")</script>");
		}
		
		System.out.println("----删除id为"+id+"的新闻！！----");
		request.getRequestDispatcher("news-change").forward(request, response);
		
	}

	/**
	 * 上传图片的方法
	 * @param request
	 * @param response
	 * @return 图片路径
	 * @throws IOException
	 */
}
