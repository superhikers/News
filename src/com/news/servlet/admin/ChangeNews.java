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
@WebServlet("/admin/change-news")
public class ChangeNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    //生成给予时间的随机数
 	public static String getTime() {
 		SimpleDateFormat sdfTime = new SimpleDateFormat("mm:ss:SS");
 		return sdfTime.format(new Date()).replaceAll("[[\\s-:punct:]]", "");
 	}
 // 获取当前时间
 		public static String getEndTime() {
 			SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 			return sdfTime.format(new Date());
 		}

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
		//获取内容
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		String content = request.getParameter("content");
		String author = request.getParameter("author");
		//获取新闻
		news.setTitle(title);news.setType(type);news.setContent(content);news.setAuthor(author);
		news.setId(Integer.parseInt(id));
		//获取当前时间
		java.sql.Date ctime = new java.sql.Date(new java.util.Date().getTime());
		news.setDate(ctime);
		int i = NewsService.changeNews(news);
		if(i==1) {
			request.setAttribute("changeInfo", "<script>alert(\"修改成功！\")</script>");
		}else {
			request.setAttribute("changeInfo", "<script>alert(\"修改失败！\")</script>");
		}
		System.out.println(id+"---"+news.toString());
		//writer = response.getWriter();
//		if(i==1) {
//            writer.println("<script>alert(\"发布成功！\")</script>");
//		}else {
//			request.setAttribute("message","发布失败!");
//			writer.println("<script>alert(\"发布失败！\")</script>");
//		}
		//writer.flush();
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
