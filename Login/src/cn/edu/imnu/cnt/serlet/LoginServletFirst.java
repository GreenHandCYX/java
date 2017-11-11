package cn.edu.imnu.cnt.serlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import cn.edu.imnu.cnt.dao.factory.DaoFactory;
import cn.edu.imnu.cnt.pro.Shopping;
import cn.edu.imnu.cnt.pro.User;

public class LoginServletFirst extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if("login".equals(action)){
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		response.setCharacterEncoding("UTF-8");
		User user=new User();
		user.setUserName(userName);
		user.setPassWord(passWord);
		
		
		try {
			User result=DaoFactory.getUserDao().login(user);
			
			if(result==null){
				
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>alert('error');window.location.href='index.jsp';</script>");
				
			}else{
				System.out.println("--login-");
				
				request.getSession().setAttribute("sessionuser", result.getUid());
				request.getSession().setAttribute("sessionuserall", result);
				request.getSession().setAttribute("sessionuserpicture", result.getPicture());
				List<Shopping> list=DaoFactory.getShoppingDao().queryAll();
				
				request.getSession().setAttribute("sessionShopping",list);
				request.getRequestDispatcher("/MyHome.jsp").forward(request, response);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}else if("show".equals(action)){
  		System.out.println("-----show------");
		String str=JSONObject.toJSONString(request.getSession().getAttribute("sessionuserpicture"));
		PrintWriter out=response.getWriter();
		
		out.print(str);
		System.out.println(str);
		
  	}
	}
}
