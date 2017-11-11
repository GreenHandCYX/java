package cn.edu.imnu.cnt.serlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.imnu.cnt.dao.factory.DaoFactory;
import cn.edu.imnu.cnt.pro.Shopping;
import cn.edu.imnu.cnt.pro.User;

public class ShoppingServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShoppingServlet() {
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
		String action=request.getParameter("action");
		response.setContentType("text/html");
		
		if ("addShopping".equals(action)) {
			String pname = request.getParameter("pname");
			String pinfo = request.getParameter("pinfo");
			String purl = request.getParameter("purl");
			System.out.println(purl);
			int  price= Integer.parseInt(request.getParameter("price"));
			
			
				Date date=new Date();
				SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String str=dformat.format(date);
				Timestamp pTime=Timestamp.valueOf(str);
				System.out.println(pTime);
				Shopping shopping=new Shopping();
				shopping.setPname(pname);
				shopping.setPinfo(pinfo);
				shopping.setPurl(purl);
				shopping.setPrice(price);
				shopping.setpTime(pTime);
				if(pinfo==""||pname==""||price==0){
					PrintWriter out=response.getWriter();
					out.print("<script language='javascript'>alert('请完善课程信息');window.location.href='no.jsp';</script>");
					
					
				}else{
				try {
					System.out.println("adasdasdasdasdasdasddasdasd");
					int i = DaoFactory.getShoppingDao().add(shopping);
					if (i != 0) {
						System.out.println("--shopaddok--");
						response.sendRedirect("ShoppingServlet?action=listShopping");
					} else {
						request.getRequestDispatcher("/error.jsp").forward(request,
								response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		}else if("listShopping".equals(action)){
			try {
				List<Shopping> list=DaoFactory.getShoppingDao().queryAll();
				System.out.println("shoppinglist");
				
				request.getSession().setAttribute("sessionShopping", list);
				request.getRequestDispatcher("/shoppingMessage.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if ("deleteshopping".equals(action)) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			System.out.println("-----success----");
			try {
				int i = DaoFactory.getShoppingDao().deleteShopping(pid);
				if (i != 0) {
					System.out.println("-----success----");
					response.sendRedirect("ShoppingServlet?action=listShopping");
					
					
				} else {
					request.getRequestDispatcher("/error.jsp").forward(request,response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("updateshopping".equals(action)){
			request.getSession().getAttribute("sessionShopping");
			System.out.println("updateshopping");
			int pid =Integer.parseInt(request.getParameter("pid"));
			System.out.println(pid);
			String pname = request.getParameter("pname");
			int price = Integer.parseInt(request.getParameter("price"));
		
			String pinfo=request.getParameter("pinfo");
			
			Shopping shopping=new Shopping(pid, pname,  price,pinfo, null,null);

			try {
				int i = DaoFactory.getShoppingDao().update(shopping);
				if (i != 0) {
					System.out.println("success-update");
					PrintWriter out=response.getWriter();
					List<Shopping> list=DaoFactory.getShoppingDao().queryAll();
					System.out.println("shoppinglist");
					
					request.getSession().setAttribute("sessionShopping", list);
					out.print("<script language='javascript'>alert('修改成功');window.location.href='updateshopping.jsp';</script>");
					
				} else {
					request.getRequestDispatcher("/error.jsp").forward(request,
							response);
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
