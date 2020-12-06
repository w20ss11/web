package cn.wss.mvc.db;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ����JDBC�Ĺ����࣬���з�װ��һЩ���߷���
 * */
public class JdbcUtils {

	private static DataSource dataSource = null;
	static{
		//���ݿ����ӳ�Ӧֻ����ʼ��һ��
		dataSource = new ComboPooledDataSource("helloc3p0");
	}
	public static Connection getConnection() throws Exception{
		Connection conn = dataSource.getConnection();
		return conn;
	}
	

	public static void release(Connection conn){
		if(conn!=null)
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
	}
	
	/**
	 * �ύ����
	 * */
	public static void commit(Connection conn){
		if(conn!=null){
			try {
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * �ع�����
	 * */
	public static void rollback(Connection conn){
		if(conn!=null){
			try {
				conn.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 *  ��ʼ����
	 * */
	public static void beginTx(Connection conn){
		if(conn!=null){
			try {
				conn.setAutoCommit(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
