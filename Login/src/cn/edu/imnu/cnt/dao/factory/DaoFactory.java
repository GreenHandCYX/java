package cn.edu.imnu.cnt.dao.factory;

import cn.edu.imnu.cnt.dao.KindDao;
import cn.edu.imnu.cnt.dao.ManagerDao;
import cn.edu.imnu.cnt.dao.ShoppingCartDao;
import cn.edu.imnu.cnt.dao.ShoppingDao;
import cn.edu.imnu.cnt.dao.UserDao;
import cn.edu.imnu.cnt.dao.impl.KindDaoImpl;
import cn.edu.imnu.cnt.dao.impl.ManagerDaoImpl;
import cn.edu.imnu.cnt.dao.impl.ShoppingCartDaoImpl;
import cn.edu.imnu.cnt.dao.impl.ShoppingDaoImpl;
import cn.edu.imnu.cnt.dao.impl.UserDaoImpl;

public class DaoFactory {

	public static UserDao getUserDao() {
		// TODO Auto-generated method stub
		return new UserDaoImpl();
	}
	public static ManagerDao getManagerDao(){
		return new ManagerDaoImpl();
	}
	public static ShoppingDao getShoppingDao(){
		return new ShoppingDaoImpl();
	}
	public static ShoppingCartDao getShoppingCartDao(){
		return new ShoppingCartDaoImpl();
	}
	public static KindDao getKindDao(){
		return new KindDaoImpl();
	}
}
