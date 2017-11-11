package cn.edu.imnu.cnt.serlet;




import java.io.*;

import java.util.*;

import javax.servlet.*;

import javax.servlet.http.*;

import org.apache.commons.fileupload.*;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.omg.CORBA.Request;

import com.alibaba.fastjson.JSONObject;



public class UploadServlet extends HttpServlet {

	  


    public void init(ServletConfig config) {

    	

    }



    public void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {
    	


    	doPost(request, response);
    	                                                                                             

    }



    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {
    	
      	String action=request.getParameter("action"); 
      	if("upload".equals(action)){
        	boolean isMultipart;//检查文件上传请求是否存在  	   
     	  int maxFileSize = 1000 * 1024;// 允许上传的文件大小的最大值
     	   int maxMemSize = 1000* 1024;//允许存储在内存中文件大小的最大值
     	 
        	String filePath=request.getRealPath("/")+ "onload/";
        	File file=new File(filePath);
    		System.out.println(filePath);
    		if(file.exists()){
    			file.mkdirs();
    			
    		}
        	
        	 // 检查我们有一个文件上传请求
            isMultipart = ServletFileUpload.isMultipartContent(request);

            request.setCharacterEncoding("UTF-8");
         // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 文件大小的最大值将被存储在内存中
            factory.setSizeThreshold(maxMemSize);
            // 超出内存存储大小的将被存在c:\temp目录下
            factory.setRepository(new File("c:\temp"));
          
           
            // 创建一个新的文件上传处理程序
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 允许上传的文件大小的最大值
            upload.setSizeMax( maxFileSize );
            
            try {
            	System.out.println("-----upload------");
            	// 解析请求，获取文件项
    			List<FileItem> items = upload.parseRequest(request);
    			// 处理上传的文件项
    			Iterator<FileItem> iter = items.iterator();
    			while (iter.hasNext()) {
    			    FileItem item = iter.next();

    			    if (item.isFormField()) {
    			    	// 获取上传文件的参数
    			    	 
    			    	    InputStream uploadedStream = item.getInputStream();
    			    	   
    			    	    uploadedStream.close();
    			    } else {
    			    	if (!item.isFormField()) {
    			    		// 获取上传文件的参数
    			    	   
    			    	    String fileName = item.getName();
    			    	   
    			    	   
    			    	    File uploadedFile = new File( filePath+fileName);
    			    	    request.setAttribute("list", uploadedFile);
    			    	    try {
    			    	    	
    							
    							item.write(uploadedFile);
    							String path="onload/"+fileName;
    							request.getSession().setAttribute("sessionname", path);
    							request.getSession().setAttribute("filename", fileName);
    							
    							
    							
    						} catch (Exception e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
    			    	}
    			    }
    			}
    		} catch (FileUploadException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		response.sendRedirect("indexRegister.jsp");
    		
      	}else if("show".equals(action)){
      		System.out.println("-----show------");
    		String str=JSONObject.toJSONString(request.getSession().getAttribute("sessionuserpicture"));
			PrintWriter out=response.getWriter();	
			out.print(str);		
      	}
    }
    
}