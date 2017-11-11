package cn.edu.imnu.cnt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.imnu.cnt.dao.KindDao;
import cn.edu.imnu.cnt.db.DBUtil;
import cn.edu.imnu.cnt.pro.Kind;
import cn.edu.imnu.cnt.pro.Shopping;
import cn.edu.imnu.cnt.pro.User;

public class KindDaoImpl implements KindDao{

	public int add(Kind kind) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into kind(kname)values(?)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, kind.getKname());
		int i = psmt.executeUpdate();
		psmt.close();
		conn.close();
		return i;
	}

	public int deleteKind(int kid) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from kind where kid = ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setInt(1, kid);
		int i = psmt.executeUpdate();
		psmt.close();
		conn.close();
		return i;
	}

	public List<Kind> queryAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Kind> list = new ArrayList<Kind>();
		String sql = "select * from kind";
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		Kind result=null;
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			result = new Kind();
			result.setKid(rs.getInt("kid"));
			result.setKname(rs.getString("kname"));
			list.add(result);
		}
		rs.close();
		psmt.close();
		conn.close();
		return list;
	}

	public List<Shopping> queryKind(String kname) throws SQLException {
		List<Shopping> list = new ArrayList<Shopping>();
		String sql = "select * from shopping where  pname like '%"+kname+"%'";
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		System.out.println(kname);
		Shopping result=null;
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			result = new Shopping();
			result.setPid(rs.getInt("pid"));
			result.setPname(rs.getString("pname"));
			result.setPinfo(rs.getString("pinfo"));
			result.setPrice(rs.getInt("price"));
			result.setpTime(rs.getTimestamp("pTime"));
			result.setPurl(rs.getString("purl"));
			list.add(result);
		}
		rs.close();
		psmt.close();
		conn.close();
		return list;
	}

}
