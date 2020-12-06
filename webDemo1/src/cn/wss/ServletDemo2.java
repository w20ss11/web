package cn.wss;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tool.ToolDemo2;

/**
 * Servlet implementation class ServletDemo2
 */
@WebServlet("/ServletDemo2")
public class ServletDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		
			//ServletContext��ȡת������
		String string = "servletDemo2_info";
		context.setAttribute("datai", string);
		RequestDispatcher rd = context.getRequestDispatcher("/demo2.jsp");
		rd.forward(request, response);
		
			//ͨ��ServletContext��ȡ��Դ�ļ�
		//InputStream inputStream = context.getResourceAsStream("/WEB-INF/classes/cn/wss/db.properties");
		InputStream inputStream = context.getResourceAsStream("/db.properties");
		//System.out.println(this.getClass().getResource("/").getPath()+"");
		Properties properties = new Properties();
		properties.load(inputStream);
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
			//ͨ��java�����ߣ����ȡ���� ��webservlet�����
		System.out.println("������װ���������ݶ�ȡ��");
		ToolDemo2 tool = new ToolDemo2();
		tool.getInfo();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
