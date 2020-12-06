package cn.wss.mvc.dao.factory;

import java.util.HashMap;
import java.util.Map;

import cn.wss.mvc.dao.UserDao;
import cn.wss.mvc.dao.impl.UserDAOJdbcImpl;
import cn.wss.mvc.dao.impl.UserDAOXMLImpl;

public class UserDAOFactory {
	private Map<String, UserDao> daos = new HashMap<String, UserDao>();


	private static UserDAOFactory instance = new UserDAOFactory();

	public static UserDAOFactory getInstance() {
		return instance;
	}

	private String type = null;

	public void setType(String type) {
		this.type = type;
	}

	private UserDAOFactory(){
		daos.put("jdbc", new UserDAOJdbcImpl());
		daos.put("xml", new UserDAOXMLImpl());
	}

	public UserDao getUserDAO(){
		return daos.get(type);
	}
}
