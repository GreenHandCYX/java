package cn.edu.imnu.cnt.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.imnu.cnt.pro.Kind;
import cn.edu.imnu.cnt.pro.Shopping;



public interface KindDao {
	public int add(Kind kind) throws SQLException;
	public List<Kind> queryAll() throws SQLException;
	public int deleteKind(int kid) throws SQLException;
	public List<Shopping> queryKind(String kname) throws SQLException;
}
