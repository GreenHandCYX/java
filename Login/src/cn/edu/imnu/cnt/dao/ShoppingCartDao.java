package cn.edu.imnu.cnt.dao;

import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.imnu.cnt.pro.Shopping;
import cn.edu.imnu.cnt.pro.ShoppingCart;




public interface ShoppingCartDao {
	public ShoppingCart judge(int pid,int uid) throws SQLException;
	public int addShoppingCart(int pid,int uid,Timestamp fdate) throws SQLException;
	public List mychoice(int uid) throws SQLException;
	
	public int deleteEachShopping(int pid) throws SQLException;
	public int deleteShoppingCart(int uid) throws SQLException;
}
