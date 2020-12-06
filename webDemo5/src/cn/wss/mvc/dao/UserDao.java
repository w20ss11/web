package cn.wss.mvc.dao;

import java.util.List;

import cn.wss.mvc.domain.User;

public interface UserDao {
	/**
	 * ���������ѯ������ List
	 * @param cc: ��װ�˲�ѯ����
	 * @return
	 */
	public List<User> getForListWithCriteriaUser(CriteriaUser cu);
	
	public List<User> getAll();
	
	public void save(User customer);
	
	public User get(Integer id);
	
	public void delete(Integer id);
	
	public void update(User customer);
	
	/**
	 * ���غ� name ��ȵļ�¼��. 
	 * @param name
	 * @return
	 */
	public long getCountWithName(String name);
}
