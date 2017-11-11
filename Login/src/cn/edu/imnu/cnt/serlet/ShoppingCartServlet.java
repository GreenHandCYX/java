package cn.edu.imnu.cnt.serlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;

import cn.edu.imnu.cnt.dao.factory.DaoFactory;
import cn.edu.imnu.cnt.pro.Shopping;
import cn.edu.imnu.cnt.pro.ShoppingCart;
import cn.edu.imnu.cnt.pro.User;

public class ShoppingCartServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShoppingCartServlet() {
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
		if ("addShoppingCart".equals(action)) {
			request.getSession().getAttribute("list");
			int  uid= Integer.parseInt(request.getParameter("uid"));
			System.out.println(uid);
			int  pid= Integer.parseInt(request.getParameter("pid")); 
			Date date=new Date();
			SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str=dformat.format(date);
			Timestamp fdate=Timestamp.valueOf(str);
			System.out.println(fdate);
			ShoppingCart shoppingcart=new ShoppingCart();
			shoppingcart.setUid(uid);
			shoppingcart.setPid(pid);
			shoppingcart.setFdate(fdate);
			System.out.println(fdate);
				if(pid==0){
					PrintWriter out=response.getWriter();
					out.print("<script language='javascript'>alert('不存在该课程');window.location.href='no.jsp';</script>");
					
					
				}else{
				try {
					ShoppingCart result=DaoFactory.getShoppingCartDao().judge(pid, uid);
					if (result==null) {
						
						int i=DaoFactory.getShoppingCartDao().addShoppingCart(pid, uid, fdate);
						System.out.println(fdate);
						PrintWriter out =response.getWriter();
						out.print("<script language='javascript'>alert('添加成功');window.location.href='MyHome.jsp'</script>");
					} else {
						PrintWriter out =response.getWriter();
						out.print("<script language='javascript'>alert('已收藏,请重新添加');window.location.href='MyHome.jsp'</script>");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
		}else if("listShoppingCart".equals(action)){
			
			
			int uid=Integer.parseInt(request.getParameter("uid1"));
			
			User user=new User();
			user.setUid(uid);
			System.out.println(uid);
				try {
					System.out.println("listShoppingCart");
					List result=DaoFactory.getShoppingCartDao().mychoice(uid);
					System.out.println(uid);
					System.out.println(result);
					request.getSession().setAttribute("listSC", result);
					
					request.getRequestDispatcher("/MyCart.jsp").forward(request, response);
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}else if("deleteEachShoppingInCart".equals(action)){
			int pid =Integer.parseInt(request.getParameter("pid"));
			
			try {
				int i = DaoFactory.getShoppingCartDao().deleteEachShopping(pid);
				if (i != 0) {
					
					System.out.println("-----success----");
					PrintWriter out =response.getWriter();
					int uid=Integer.parseInt(request.getParameter("uid1"));
					
					User user=new User();
					user.setUid(uid);
					System.out.println(uid);
					List result=DaoFactory.getShoppingCartDao().mychoice(uid);
					
					request.getSession().setAttribute("listSC", result);
					System.out.println(uid);
					out.print("<script language='javascript'>alert('删除成功');window.location.href='MyCart.jsp'</script>");
					
					
					
				} else {
					request.getRequestDispatcher("/Manager.jsp").forward(request,response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else if("clearShoppingCart".equals(action)){
			
			int uid =Integer.parseInt(request.getParameter("uid1"));
			
			try {
				int i = DaoFactory.getShoppingCartDao().deleteShoppingCart(uid);
				if (i != 0) {
					
					System.out.println("-----successclear----");
					PrintWriter out =response.getWriter();
					
					System.out.println(uid);
					out.print("<script language='javascript'>alert('收藏夹已清空');window.location.href='MyHome.jsp'</script>");
	
				} else {
					request.getRequestDispatcher("/no.jsp").forward(request,response);
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
