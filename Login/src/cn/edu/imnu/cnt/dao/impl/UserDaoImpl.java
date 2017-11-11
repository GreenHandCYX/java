package cn.edu.imnu.cnt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.imnu.cnt.dao.UserDao;
import cn.edu.imnu.cnt.db.DBUtil;
import cn.edu.imnu.cnt.pro.User;

public class UserDaoImpl implements UserDao {

	public User login(User user) throws SQLException {
		// TODO Auto-generated method stub
		User result=null;
		Connection conn=DBUtil.getConnection();
		PreparedStatement psmt=conn.prepareStatement("select * from user where userName=? and passWord=?");
		psmt.setString(1, user.getUserName());
		psmt.setString(2, user.getPassWord());
		ResultSet rs=psmt.executeQuery();
		while(rs.next()){
			result=new User();
			result.setUid(rs.getInt("uid"));
			result.setUserName(rs.getString("userName"));
			result.setPassWord(rs.getString("passWord"));
			result.setPicture(rs.getString("picture"));
		}
		psmt.close();
		conn.close();
		return result;
	}

	public boolean register(User us) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql=""+"insert into user"+
		"(userName,passWord,email,info,sex,picture)"+
		"values("+"?,?,?,?,?,?)";
		
		
		boolean flag=false;
		Connection conn=DBUtil.getConnection();
		PreparedStatement psmt=conn.prepareStatement(sql);
		psmt.setString(1, us.getUserName());
		psmt.setString(2, us.getPassWord());
		psmt.setString(3, us.getEmail());
		psmt.setString(4, us.getInfo());
		psmt.setString(5, us.getSex());
		psmt.setString(6, us.getPicture());

		
		int i=psmt.executeUpdate();
		if(i!=0){
			flag=true;
		}
		psmt.close();
		conn.close();
		return flag;
	}

	public boolean query(User user) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn =DBUtil.getConnection();
		PreparedStatement psmt= conn.prepareStatement("select * from user where userName=?");
		psmt.setString(1, user.getUserName());
		ResultSet rs = psmt.executeQuery();
		boolean flag =!rs.next() ? false : true;
		rs.close();
		psmt.close();
		conn.close();
		return flag;
	}
	public int delete(int uid) throws SQLException {
		// TODO Auto-generated method stub
		String sql = " delete  from user where uid=?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setInt(1, uid);
		int i = psmt.executeUpdate();
		psmt.close();
		conn.close();
		return i;
	}
	public int deleteall(int uid) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete sc.*,u.* from user u,shoppingcart sc where u.uid=sc.uid and u.uid=?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setInt(1, uid);
		int i = psmt.executeUpdate();
		psmt.close();
		conn.close();
		return i;
	}

	public List<User> queryAll() throws SQLException {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		String sql = "select * from user";
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);

		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			User result = new User();
			result.setUid(rs.getInt("uid"));
			result.setUserName(rs.getString("userName"));
			result.setPassWord(rs.getString("passWord"));
			result.setEmail(rs.getString("email"));
			result.setInfo(rs.getString("info"));
			result.setSex(rs.getString("sex"));
			result.setPicture(rs.getString("picture"));
			list.add(result);
		}
		rs.close();
		psmt.close();
		conn.close();
		return list;
	}



}
