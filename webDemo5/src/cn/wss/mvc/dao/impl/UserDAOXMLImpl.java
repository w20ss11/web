package cn.wss.mvc.dao.impl;

import java.util.List;

import cn.wss.mvc.dao.CriteriaUser;
import cn.wss.mvc.dao.UserDao;
import cn.wss.mvc.domain.User;

public class UserDAOXMLImpl implements UserDao {

	@Override
	public List<User> getForListWithCriteriaUser(CriteriaUser cu) {
		System.out.println("getForListWithCriteriaUser");
		return null;
	}

	@Override
	public List<User> getAll() {
		System.out.println("getAll");
		return null;
	}

	@Override
	public void save(User customer) {
		System.out.println("save");
	}

	@Override
	public User get(Integer id) {
		System.out.println("get");
		return null;
	}

	@Override
	public void delete(Integer id) {
		System.out.println("delete");

	}

	@Override
	public void update(User customer) {
		System.out.println("update");

	}

	@Override
	public long getCountWithName(String name) {
		System.out.println("getCountWithName");
		return 0;
	}

}
