package cn.wss.db;

import java.sql.Connection;
import java.util.List;

import cn.wss.bean.FileUploadBean;


public class UploadFileDao extends DAO<FileUploadBean>{
	
	public List<FileUploadBean> getFiles(){
		
		Connection conn = null;
		
		try {
			conn = JDBCUtils.getConnection();
			String sql = "SELECT id, filename fileName, filepath filePath, " +
					"filedesc fileDesc FROM uploadFiles";
			return getForList(conn, sql);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.release(conn);
		}
		
		return null;
	} 
	
	public void save(List<FileUploadBean> uploadFiles){
		
		Connection conn = null;
		
		try {
			conn = JDBCUtils.getConnection();
			String sql = "INSERT INTO uploadFiles (filename, filepath, filedesc) VALUES " +
					"(?, ?, ?)";
			for(FileUploadBean file: uploadFiles){
				update(conn, sql, file.getFileName(), file.getFilePath(), file.getFileDesc());
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.release(conn);
		}
		
	}
	
}
