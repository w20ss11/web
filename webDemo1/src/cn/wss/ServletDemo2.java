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
		
			//ServletContext获取转发对象
		String string = "servletDemo2_info";
		context.setAttribute("datai", string);
		RequestDispatcher rd = context.getRequestDispatcher("/demo2.jsp");
		rd.forward(request, response);
		
			//通过ServletContext获取资源文件
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
		
			//通过java（工具）类读取数据 与webservlet层隔开
		System.out.println("工具类装载器，数据读取层");
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
