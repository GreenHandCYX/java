package cn.edu.imnu.cnt.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.imnu.cnt.dao.ManagerDao;
import cn.edu.imnu.cnt.db.DBUtil;
import cn.edu.imnu.cnt.pro.Manager;
import cn.edu.imnu.cnt.pro.Shopping;
import cn.edu.imnu.cnt.pro.User;

public class ManagerDaoImpl implements ManagerDao {

	public boolean login(Manager manager) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from manager where mname=? and mpass = ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, manager.getMname());
		psmt.setString(2, manager.getMpass());
		ResultSet rs = psmt.executeQuery();
		boolean falg = rs.first();
		psmt.close();
		conn.close();
		return falg;
	}
	
	
	

}
