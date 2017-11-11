package cn.edu.imnu.cnt.serlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import cn.edu.imnu.cnt.dao.factory.DaoFactory;
import cn.edu.imnu.cnt.pro.User;

public class LoginServletSecond extends HttpServlet {

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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		String action = request.getParameter("action");
		if("add".equals(action)){
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		String email=request.getParameter("email");
		String info=request.getParameter("info");
		String sex=request.getParameter("sex");
		String picture=request.getParameter("picture");
		System.out.println(picture);
		User user=new User();
		user.setUserName(userName);
		user.setPassWord(passWord);
		user.setEmail(email);
		user.setInfo(info);
		user.setSex(sex);
		user.setPicture(picture);
		System.out.println(userName);
		if(userName==""||passWord==""){
			PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>alert('请完善您的信息');window.location.href='no.jsp';</script>");
			
			
		}else{
		try {
			boolean b=DaoFactory.getUserDao().register(user);
			System.out.println(b);
			System.out.println(user.toString());
			PrintWriter out = response.getWriter();
			System.out.println(b);
			
			if(b==false){
				System.out.println("---no----");
				request.getRequestDispatcher("/no.jsp").forward(request, response);
			}
			else{
				request.getSession().setAttribute("sessionname", picture);
				
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			out.flush();
			out.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		}
	}else if("query".equals(action)){
			String userName=request.getParameter("userName");
			User user=new User(0, userName, null);
				try {
					PrintWriter out = response.getWriter();
					boolean falg = DaoFactory.getUserDao().query(user);
					System.out.println(falg);
					if(falg){
						System.out.println("ok");
						out.write(JSONObject.toJSONString("ok"));
						out.flush();
						out.close();
					}else{
						System.out.println("no");
						out.write(JSONObject.toJSONString("no"));
						out.flush();
						out.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if("list".equals(action)){
				try {
					List<User> list=DaoFactory.getUserDao().queryAll();
					System.out.println("list");
					request.getSession().setAttribute("list", list);
					
					request.getRequestDispatcher("/main.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if ("delete".equals(action)) {
				int uid = Integer.parseInt(request.getParameter("uid"));
				System.out.println(uid);
				try {
					List result=DaoFactory.getShoppingCartDao().mychoice(uid);
					if(result==null||result.size()==0){
						try {
							int i = DaoFactory.getUserDao().delete(uid);
							
							if (i != 0) {
								System.out.println("-----successdelete----");
								response.sendRedirect("LoginServletSecond?action=list");
							} else {
								request.getRequestDispatcher("/Manager.jsp").forward(request,response);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else{
						try {
							int i = DaoFactory.getUserDao().deleteall(uid);
							
							if (i != 0) {
								System.out.println("-----successdelete----");
								response.sendRedirect("LoginServletSecond?action=list");
							} else {
								request.getRequestDispatcher("/Manager.jsp").forward(request,response);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
	}
}
