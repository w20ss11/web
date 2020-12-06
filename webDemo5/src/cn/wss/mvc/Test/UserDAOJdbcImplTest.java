package cn.wss.mvc.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.wss.mvc.dao.CriteriaUser;
import cn.wss.mvc.dao.impl.UserDAOJdbcImpl;
import cn.wss.mvc.domain.User;

public class UserDAOJdbcImplTest {

	UserDAOJdbcImpl userDao = new UserDAOJdbcImpl();
	
	
	@Test
	public void testGetForListWithCriteriaUser() {
		CriteriaUser cu = new CriteriaUser("o", "2", 0);
		List<User> users = userDao.getForListWithCriteriaUser(cu);
		System.out.println(users.toString());
	}

	@Test
	public void testGetAll() {
		List<User> list = userDao.getAll();
		System.out.println(list);
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setName("wss");
		user.setPsd("mima");
		user.setBalance(15000);
		userDao.save(user);
		
	}

	@Test
	public void testGetInteger() {
//		System.out.println(u.clazz);
		User user = userDao.get(1);
		System.out.println(user);
	}

	@Test
	public void testDelete() {
		userDao.delete(3);
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCountWithName() {
		long count = userDao.getCountWithName("Jerry");
		System.out.println(count);
	}

}
