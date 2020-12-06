package cn.wss;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.tool.UserDemo6;

/**
 * Servlet implementation class ServletDemo6
 */
@WebServlet("/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//request 获取请求中的客户机信息
		System.out.println("------------- 客户机信息 ----------------");
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		//http://localhost/webDemo/RequestDemo6?name=aaa
		System.out.println(request.getQueryString());
		//-----------------------
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRemoteHost());
		System.out.println(request.getRemotePort());
		System.out.println(request.getMethod());
		
			//request 获取请求头
		System.out.println("------------- 请求头 ------------------");
		String headValue = request.getHeader("Accept-Encoding");
		System.out.println("请求头单个Accept-Encoding："+headValue);
		Enumeration<String> e = request.getHeaders("Accept-Encoding");
		while(e.hasMoreElements()){
			String value = (String) e.nextElement();
			System.out.println("请求头多个Accept-Encoding："+value);
		}
		e = request.getHeaderNames();
		while(e.hasMoreElements()){
			String name = e.nextElement();
			String value = request.getHeader(name);
			System.out.println("请求头所有信息："+name+" : "+value);
		}
		
			//request 获取从html传来的数据
		System.out.println("----------- 获取html的数据 --------------");
		System.out.println("----------- 1");
		String value = request.getParameter("name");
		System.out.println("html单个参数："+value);
		System.out.println("----------- 2");
		Enumeration<String> e1 = request.getParameterNames();
		while(e1.hasMoreElements()){
			String name = e1.nextElement();
			String v = request.getParameter(name);
			System.out.println("html所有参数："+name+" : "+v);
		}
		System.out.println("----------- 3");
		String[] values = request.getParameterValues("username");
		for(int i=0;values!=null && i<values.length;i++){
			System.out.println("html重名参数："+values[i]);
		}
		System.out.println("----------- 4");
		Map<String, ?> map = request.getParameterMap();
		UserDemo6 user = new UserDemo6();
		try {
			BeanUtils.populate(user, map);
			UserDemo6 user_new = new UserDemo6();
			BeanUtils.copyProperties(user, user_new);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		System.out.println(user);
		
		System.out.println("----------- 5");
		InputStream in = request.getInputStream();
		int len = 0;
		byte buffer[] = new byte[1024];
		while((len=in.read(buffer))>0){
			System.out.println(new String(buffer,0,len));
		}
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
