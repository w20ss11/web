package cn.wss.mvc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Demo1_DAO {

	public void deleteById(Integer id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///hello?characterEncoding=utf8&useSSL=true";
			String user = "root";
			String psd = "wss6565";
			
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, psd);
			
			String sql = "DELETE FROM person WHERE id = ?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();//ÖØÒª£¡£¡£¡
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
			try {
				if(preparedStatement != null){
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Demo1_Person> getAll(){
		
		List<Demo1_Person> persons = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///hello?characterEncoding=utf8&useSSL=true";
			String user = "root";
			String psd = "wss6565";
			
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, psd);
			
			String sql = "SELECT id,name,age,sex,birth from person";;
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				String sex = resultSet.getString(4);
				Date birth = Date.valueOf(resultSet.getString(5));
				
				Demo1_Person person = new Demo1_Person(id, name, age, sex, birth);
				persons.add(person);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(resultSet != null){
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(preparedStatement != null){
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return persons;
	}

}
