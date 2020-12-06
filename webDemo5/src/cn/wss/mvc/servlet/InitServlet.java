package cn.wss.mvc.servlet;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import cn.wss.mvc.dao.factory.UserDAOFactory;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(displayName = "/InitServlet", //描述  
			name = "InitServlet", //servlet名称  
			urlPatterns = { "/InitServlet"},//url  
			loadOnStartup = 1)//启动项 
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		UserDAOFactory.getInstance().setType("jdbc");

		//读取类路径下的 switch.properties 文件
		InputStream in = 
				getServletContext().getResourceAsStream("/WEB-INF/classes/switch.properties");
		Properties properties = new Properties();
		try {
			properties.load(in);
			//获取 switch.properties 的 type 属性值
			String type = properties.getProperty("type");
			//赋给了 CustomerDAOFactory 的 type 属性值
			UserDAOFactory.getInstance().setType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("webdemo5 init servlet");
	}

}
