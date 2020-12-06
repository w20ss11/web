package cn.wss.mvc.dao.impl;

import java.util.List;

import cn.wss.mvc.dao.CriteriaUser;
import cn.wss.mvc.dao.DAO;
import cn.wss.mvc.dao.UserDao;
import cn.wss.mvc.domain.User;

public class UserDAOJdbcImpl extends DAO<User> implements UserDao{

	@Override
	public List<User> getForListWithCriteriaUser(CriteriaUser cu) {
		String sql = "SELECT id,name, psd, balance FROM users WHERE " +
				"name LIKE ? AND psd LIKE ?";
		//修改了 CriteriaCustomer 的 getter 方法: 使其返回的字符串中有 "%%".
		//若返回值为 null 则返回 "%%", 若不为 null, 则返回 "%" + 字段本身的值 + "%"
		if(cu.getBalance()==-1)
			return getForList(sql, cu.getName(), cu.getPsd());
		else{
			sql = sql + "AND balance%10= ?";
			return getForList(sql, cu.getName(), cu.getPsd(), cu.getBalance());
		}
	}

	@Override
	public List<User> getAll() {
		String sql = "SELECT id, name, psd, balance FROM users";
		return getForList(sql);
	}

	@Override
	public void save(User user) {
		String sql = "INSERT INTO users(name, psd, balance) VALUES(?,?,?)";
		update(sql, user.getName(), user.getPsd(), user.getBalance());
	}

	@Override
	public User get(Integer id) {
		String sql = "SELECT id, name, psd, balance FROM users WHERE id = ?";
		return get(sql, id);
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM users WHERE id = ?";
		update(sql, id);
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE users SET name = ?, psd = ?, balance = ? " +
				"WHERE id = ?";
		update(sql, user.getName(), user.getPsd(), user.getBalance(),user.getId());
	}

	@Override
	public long getCountWithName(String name) {
		String sql = "SELECT count(id) FROM users WHERE name = ?";
		return getForValue(sql, name); 
	}

}
