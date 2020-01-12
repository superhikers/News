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
@WebServlet("/admin/sendNews")
public class SendNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "img";
 
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	
    private DiskFileItemFactory factory = new DiskFileItemFactory();
    private ServletFileUpload upload = new ServletFileUpload(factory);
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
//		PrintWriter writer = response.getWriter();
		// TODO Auto-generated method stub
		//doGet(request, response);
		//获取新闻
		News news = new News();
		//获取图片路径
		news = upload(request,response);
	
		//获取当前时间
		java.sql.Date ctime = new java.sql.Date(new java.util.Date().getTime());
		news.setDate(ctime);
		System.out.println(news.toString());
		int i = NewsService.sendNews(news);
//		writer = response.getWriter();
//		if(i==1) {
//            writer.println("<script>alert(\"发布成功！\")</script>");
//		}else {
//			request.setAttribute("message","发布失败!");
//			writer.println("<script>alert(\"发布失败！\")</script>");
//		}
//		writer.flush();
		request.setAttribute("sendInfo", "<script>alert(\"发布成功！\")</script>");
		request.getRequestDispatcher("send-news.jsp").forward(request, response);
		
	}

	/**
	 * 上传图片的方法
	 * @param request
	 * @param response
	 * @return 图片路径
	 * @throws IOException
	 */
	public News upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		News news = new News();
		String filePath = null;
		
//		if (!ServletFileUpload.isMultipartContent(request)) {
//            // 如果不是则停止
//            PrintWriter writer = response.getWriter();
//            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
//            writer.flush();
//            syso
//            return null;
//        }
 
        // 配置上传参数
//        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
//        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        
        // 中文处理
        upload.setHeaderEncoding("UTF-8"); 

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;
       
         
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                    	String fileName = new File(item.getName()).getName();
                        fileName = getTime()+fileName;
                        filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        //获取文件名
                        news.setImg(fileName);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        request.setAttribute("message",
                            "文件上传成功!");
                    }else {
                    	System.out.println(item.getFieldName()+"="+item.getString("utf-8"));
                    	String fileName = item.getFieldName();//得到表单中name的值
	                    String values = item.getString("utf-8");//得到表单中value的值
	                    /**
	                     * 根据表单控件名得到value的值并且插入到newsbean中
	                     */
	                    if(fileName.equals("title")) {
	                    	news.setTitle(new String(values));
	                    	System.out.println(values);
	                    }
	                    else if(fileName.equals("type")) {
	                    	news.setType(new String(values));}
	                    else if(fileName.equals("content")) {
	                    	news.setContent(new String(values));}
	                    else if(fileName.equals("author")) {
	                    	news.setAuthor(new String(values));}
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "错误信息: " + ex.getMessage());
        }
		
		return news;
	}
	
	
	
}
