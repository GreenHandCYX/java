package cn.edu.imnu.cnt.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.imnu.cnt.pro.Manager;
import cn.edu.imnu.cnt.pro.Shopping;
import cn.edu.imnu.cnt.pro.User;

public interface ManagerDao {
	
	public boolean login(Manager manager)throws SQLException;
	
	
}
