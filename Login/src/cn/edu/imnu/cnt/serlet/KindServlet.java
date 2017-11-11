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
import cn.edu.imnu.cnt.pro.Kind;
import cn.edu.imnu.cnt.pro.Shopping;

public class KindServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public KindServlet() {
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
		
		String action=request.getParameter("action");
		if("listAllKind".equals(action)){
			try {
				List<Kind> list=DaoFactory.getKindDao().queryAll();
				System.out.println("kindlist");
				System.out.println(list);
				request.getSession().setAttribute("kindlist", list);
				request.getRequestDispatcher("/AllKind.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if("listKindShopping".equals(action)){
			String kname=request.getParameter("kname");
			try {
				List<Shopping> list=DaoFactory.getKindDao().queryKind(kname);
				System.out.println("kindshopping");
				System.out.println(list);
				request.getSession().setAttribute("kindshopping", list);
				request.getRequestDispatcher("/KindShopping.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("listAllKindManager".equals(action)){
			try {
				List<Kind> list=DaoFactory.getKindDao().queryAll();
				System.out.println("kindlist");
				System.out.println(list);
				request.getSession().setAttribute("kindlistM", list);
				request.getRequestDispatcher("/AllKindManager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if ("addShoppingKind".equals(action)){
			
				String kname = request.getParameter("kname");
				Kind kind=new Kind();
				kind.setKname(kname);
					if(kname==""){
						PrintWriter out=response.getWriter();
						out.print("<script language='javascript'>alert('类别名不能为空');window.location.href='addKind.jsp';</script>");	
					}else{
					try {
						System.out.println("addKind");
						int i = DaoFactory.getKindDao().add(kind);
						if (i != 0) {
							System.out.println("--kindaddok--");
							response.sendRedirect("KindServlet?action=listAllKindManager");
						} else {
							request.getRequestDispatcher("/error.jsp").forward(request,
									response);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
		} else if ("deleteKind".equals(action)) {
			int kid = Integer.parseInt(request.getParameter("kid"));
			System.out.println("-----successdeletekind----");
			try {
				int i = DaoFactory.getKindDao().deleteKind(kid);
				if (i != 0) {
					System.out.println("-----successdeletekind----");
					response.sendRedirect("KindServlet?action=listAllKindManager");
					
					
				} else {
					request.getRequestDispatcher("/error.jsp").forward(request,response);
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
