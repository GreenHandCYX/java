package cn.edu.imnu.cnt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// 
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:mys" +
					"ql://localhost:3306/user?useUnicode=true&characterEncoding=UTF-8", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		System.out.println(DBUtil.getConnection());
	}
}

