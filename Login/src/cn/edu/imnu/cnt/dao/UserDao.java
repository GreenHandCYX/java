package cn.edu.imnu.cnt.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.imnu.cnt.pro.User;

public interface UserDao {
	public User login(User user)throws SQLException;
	public boolean  register(User user)throws SQLException;
	public boolean query(User user) throws SQLException ;
	public List<User> queryAll() throws SQLException;
	public int delete(int uid) throws SQLException;
	public int deleteall(int uid) throws SQLException;
}
