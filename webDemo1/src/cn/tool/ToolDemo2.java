package cn.tool;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ToolDemo2 {
	public void getInfo() throws IOException{
//		InputStream in = Tool.class.getClassLoader().getResourceAsStream("/cn/wss/db.properties");
//		Properties pro = new Properties();
//		pro.load(in);
//		System.out.println(pro.getProperty("url")+" getClassLoader");
		//通过类加载器读取文件
		String path = ToolDemo2.class.getClassLoader().getResource("/cn/wss/db.properties").getPath();
		FileInputStream in = new FileInputStream(path);
		Properties properties = new Properties();
		properties.load(in);
		System.out.println("path: "+path);
		System.out.println(properties.getProperty("url"));
	}
}
