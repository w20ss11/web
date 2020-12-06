package cn.wss.JSP;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_demo6
 */
@WebServlet("/JSPServlet_demo6_1")
public class JSPServlet_demo6_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSPServlet_demo6_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JSPServlet_demo6_1");
		PrintWriter out = response.getWriter();
		out.print("JSPServlet_demo6_1");
		
		request.setAttribute("name", "redis");
		
		//1.请求转发request 的getRequestDistpatcher()方法获取RequestDistpatcher对象
		//调用getRequestDispatcher()需要传入要转发的地址
		String path = "/JSPServlet_demo6_3";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/"+path);
		//2.调用request的forward(request,response)进行请求的转发
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
