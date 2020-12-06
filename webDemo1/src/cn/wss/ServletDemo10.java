package cn.wss;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo10
 */
@WebServlet("/ServletDemo10")
public class ServletDemo10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo10() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//地址写法
		//1.这个地址给服务器用，/表示web应用	  request转发
		//request.getRequestDispatcher("/demo4.html").forward(request, response);
		//2.这个地址给浏览器用，/表示网站        	  response重定向
		//response.sendRedirect("/webDemo/demo4.html");
		//3.给服务器获取资源绝对路径
		//this.getServletContext().getRealPath("/demo4.html");
		//4.给服务器获取资源地址
		//this.getServletContext().getResourcePaths("/demo4.html");
		//5.
		/* <a href="/webDemo/demo4.html">点点</a>
		 * <form action="/webDemo/demo4.html">
		 * </form>
		 * */
		
			//防盗链
		String referer = request.getHeader("referer");
		if(referer==null || !referer.startsWith("http://localhost")){
			response.sendRedirect("/webDemo/index.html");
			return;
		}
		String data = "凤姐日记";
		response.setCharacterEncoding("UTF-8");//response 向浏览器写出数据码表
		response.setHeader("content-type", "text/html;charset=UTF-8");//浏览器用什么码表打开服务发送的数据
		response.getWriter().write(data);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
