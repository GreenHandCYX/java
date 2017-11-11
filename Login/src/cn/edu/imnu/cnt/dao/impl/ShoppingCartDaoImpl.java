package cn.edu.imnu.cnt.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.imnu.cnt.dao.ShoppingCartDao;
import cn.edu.imnu.cnt.db.DBUtil;
import cn.edu.imnu.cnt.pro.Shopping;
import cn.edu.imnu.cnt.pro.ShoppingCart;
import cn.edu.imnu.cnt.pro.User;

public class ShoppingCartDaoImpl implements ShoppingCartDao {

	public int addShoppingCart(int pid, int uid,Timestamp fdate) throws SQLException {
		String sql="insert into shoppingcart(pid,uid,fdate)values(?,?,?)";
		Connection conn=DBUtil.getConnection();
		PreparedStatement psmt=conn.prepareStatement(sql);
		psmt.setInt(1, pid);
		psmt.setInt(2, uid);
		psmt.setTimestamp(3, fdate);
		int i=psmt.executeUpdate();
		psmt.close();
		conn.close();
		return i;
	}

	

	public ShoppingCart judge(int pid, int uid) throws SQLException {
		ShoppingCart result=null;
		Connection conn= DBUtil.getConnection();
		PreparedStatement psmt=conn.prepareStatement("select * from shoppingcart where pid=? and uid=?");
		psmt.setInt(1, pid);
		psmt.setInt(2, uid);
		ResultSet rs=psmt.executeQuery();
		while(rs.next()){
			result=new ShoppingCart();
			result.setPid(rs.getInt("pid"));
			result.setUid(rs.getInt("uid"));
			
		}
		psmt.close();
		conn.close();
		return result;
	}

	

	public int deleteShoppingCart(int uid) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from shoppingcart where uid = ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setInt(1, uid);
		int i = psmt.executeUpdate();
		psmt.close();
		conn.close();
		return i;
	}
	public int deleteEachShopping(int pid) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement("delete from shoppingcart where pid=?");
		psmt.setInt(1, pid);
		int i = psmt.executeUpdate();
		System.out.println("impl"+i);
		psmt.close();
		conn.close();
		return i;
	}



	@SuppressWarnings("null")
	public List mychoice(int uid) throws SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List list=new ArrayList();
		
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement("select sc.fdate,p.pid,p.pname,p.price,p.purl from shopping p,shoppingcart sc,user u where p.pid=sc.pid and u.uid=sc.uid and u.uid=?");
		Shopping shopping=null;
		ShoppingCart shoppingcart=null;
		psmt.setInt(1, uid);
		ResultSet rs=psmt.executeQuery();
		while(rs.next()){
			shopping=new Shopping();
			shoppingcart=new ShoppingCart();
			shopping.setPname(rs.getString("pname"));
			shopping.setPrice(rs.getInt("price"));
			shopping.setPurl(rs.getString("purl"));
			shopping.setPid(rs.getInt("pid"));
			shoppingcart.setFdate(rs.getTimestamp("fdate"));
			System.out.println(shopping);
			list.add(shopping);
			list.add(shoppingcart);
		}
		psmt.close();
		conn.close();
		
		return list;
	}
	
}
