package cn.edu.imnu.cnt.serlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.imnu.cnt.dao.factory.DaoFactory;
import cn.edu.imnu.cnt.pro.Manager;
import cn.edu.imnu.cnt.pro.Shopping;
import cn.edu.imnu.cnt.pro.User;

public class ManagerServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ManagerServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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

		response.setContentType("text/html");
		String action = request.getParameter("action");
		
		if("ManagerLogin".equals(action)){
			String mname=request.getParameter("mname");
			String mpass=request.getParameter("mpass");
			System.out.println(mname);
			System.out.println(mpass);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			response.setHeader("content-type","text/html;charset=UTF-8");
			Manager manager=new Manager();
			manager.setMname(mname);
			manager.setMpass(mpass);
			
			try {
				boolean falg = DaoFactory.getManagerDao().login(manager);
				if(falg){
					request.getRequestDispatcher("/Manager.jsp").forward(request, response);
				}else{
					PrintWriter out=response.getWriter();
					out.print("<script language='javascript'>alert('error');window.location.href='ManagerIndex.jsp';</script>");
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		} 
		


	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
