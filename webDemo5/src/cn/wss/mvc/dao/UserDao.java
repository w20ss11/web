package cn.wss.mvc.dao;

import java.util.List;

import cn.wss.mvc.domain.User;

public interface UserDao {
	/**
	 * 返回满足查询条件的 List
	 * @param cc: 封装了查询条件
	 * @return
	 */
	public List<User> getForListWithCriteriaUser(CriteriaUser cu);
	
	public List<User> getAll();
	
	public void save(User customer);
	
	public User get(Integer id);
	
	public void delete(Integer id);
	
	public void update(User customer);
	
	/**
	 * 返回和 name 相等的记录数. 
	 * @param name
	 * @return
	 */
	public long getCountWithName(String name);
}
