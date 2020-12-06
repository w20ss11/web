package cn.wss;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo1
 */
@WebServlet(
		displayName = "/ServletDemo1", //描述  
		name = "ServletDemo1", //servlet名称  
		urlPatterns = { "/ServletDemo1" },//url  
		loadOnStartup = 1, //启动项  
		initParams = { @WebInitParam(name = "data", value = "xxxx") })//初始化参数 )
public class ServletDemo1 extends HttpServlet {
	private ServletConfig config;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletDemo1() {
    }
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config = config;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//response重定向
//		response.setStatus(302);
//		response.setHeader("location", "/webDemo1/demo1.html");
		
			//通过servletconfig 对象获取initparam
		//String str = config.getInitParameter("data");
		//System.out.println(str);
		//response.getOutputStream().write(str.getBytes());
		
			//servletContext 对象设置initparam
		ServletContext context = this.getServletContext();
		context.setAttribute("data1", "data1 value");
		String value = (String) context.getAttribute("data1");
		response.getOutputStream().write(value.getBytes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
