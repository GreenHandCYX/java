package cn.edu.imnu.cnt.dao;

import java.sql.SQLException;
import java.util.List;


import cn.edu.imnu.cnt.pro.Shopping;

public interface ShoppingDao {
	public int add(Shopping shopping) throws SQLException;
	public List<Shopping> queryAll() throws SQLException;
	public int deleteShopping(int pid) throws SQLException;
	public int update(Shopping shopping) throws SQLException;
}
