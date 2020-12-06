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
@WebServlet(displayName = "/InitServlet", //����  
			name = "InitServlet", //servlet����  
			urlPatterns = { "/InitServlet"},//url  
			loadOnStartup = 1)//������ 
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		UserDAOFactory.getInstance().setType("jdbc");

		//��ȡ��·���µ� switch.properties �ļ�
		InputStream in = 
				getServletContext().getResourceAsStream("/WEB-INF/classes/switch.properties");
		Properties properties = new Properties();
		try {
			properties.load(in);
			//��ȡ switch.properties �� type ����ֵ
			String type = properties.getProperty("type");
			//������ CustomerDAOFactory �� type ����ֵ
			UserDAOFactory.getInstance().setType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("webdemo5 init servlet");
	}

}
