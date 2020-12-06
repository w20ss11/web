package cn.wss.mvc.Test;

import java.sql.Connection;

import org.junit.Test;

import cn.wss.mvc.db.JdbcUtils;

public class JDBCUtilsTest {

	@Test
	public void testGetConnection() throws Exception {
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn);
	}

}
