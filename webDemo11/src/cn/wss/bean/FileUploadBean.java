package cn.wss.bean;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;


public class FileUploadBean {

	public static void main(String[] args) {
		FileUploadBean bean = new FileUploadBean("ABC", "e:\\abc.txt", "aabbcc");
		Gson gson = new Gson();
		String jsonStr = gson.toJson(bean);
		System.out.println(jsonStr);
		
		List<FileUploadBean> beans = new ArrayList<>();
		beans.add(bean);
		beans.add(new FileUploadBean("def", "e:\\def.txt", "ddeeff"));
		jsonStr = gson.toJson(beans);
		System.out.println(jsonStr);
	}
	
	private Integer id;
	// �ļ���
	private String fileName;
	// �ļ���·��
	private String filePath;
	// �ļ�������
	private String fileDesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileDesc() {
		return fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}

	public FileUploadBean(String fileName, String filePath, String fileDesc) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileDesc = fileDesc;
	}

	public FileUploadBean() {
		// TODO Auto-generated constructor stub
	}
}
