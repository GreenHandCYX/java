package cn.edu.imnu.cnt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.imnu.cnt.dao.ShoppingDao;
import cn.edu.imnu.cnt.db.DBUtil;


import cn.edu.imnu.cnt.pro.Shopping;

public class ShoppingDaoImpl implements ShoppingDao{
	public int add(Shopping shopping) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into shopping(pname,pinfo,price,purl,pTime)values(?,?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, shopping.getPname());
		psmt.setString(2, shopping.getPinfo());
		psmt.setInt(3, shopping.getPrice());
		psmt.setString(4, shopping.getPurl());
		psmt.setTimestamp(5, shopping.getpTime());
		int i = psmt.executeUpdate();
		psmt.close();
		conn.close();
		return i;
	}

	public int deleteShopping(int pid) throws SQLException {
		String sql = "delete from shopping where pid = ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setInt(1, pid);
		int i = psmt.executeUpdate();
		psmt.close();
		conn.close();
		return i;
	}

	public List<Shopping> queryAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Shopping> list = new ArrayList<Shopping>();
		String sql = "select * from shopping";
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);

		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			Shopping result = new Shopping();
			result.setPid(rs.getInt("pid"));
			result.setPname(rs.getString("pname"));
			result.setPinfo(rs.getString("pinfo"));
			result.setPrice(rs.getInt("price"));
			result.setPurl(rs.getString("purl"));
			result.setpTime(rs.getTimestamp("pTime"));
			
			list.add(result);
		}
		rs.close();
		psmt.close();
		conn.close();
		return list;	}

	public int update(Shopping shopping) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update  shopping set pname=? ,price = ?,pinfo = ?  where pid = ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, shopping.getPname());
		psmt.setInt(2, shopping.getPrice());
		psmt.setString(3, shopping.getPinfo());
		
		psmt.setInt(4, shopping.getPid());
		int i = psmt.executeUpdate();
		psmt.close();
		conn.close();
		return i;
	}
	
}
