package cn.wss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo9
 */
@WebServlet("/RequestDemo9")
public class RequestDemo9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo9() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//request 转发到demo9.jsp 并且利用reques域存储数据传到jsp
		String data = "aabaa";
		request.setAttribute("data", data);
		request.getRequestDispatcher("/demo9.jsp").forward(request, response);
		
			//request 转发失败案例
		//String data = "aaa";
		//PrintWriter writer = response.getWriter();
		//writer.write(data);
		//writer.close();
		//writer已经close request不能再转发 下面这句会报错
		//request.getRequestDispatcher("/demo9.jsp").forward(request, response);
		
			//requset forward方法执行后，原来写到response输出缓冲区的内容会被清空
		//String data = "ccccc";
		//response.getWriter().write(data);
		//request.getRequestDispatcher("/index.html").forward(request, response);
		
			//reqyest getRequestDispatcher.include方法，服务端包含功能
		//request.getRequestDispatcher("/public/headDemo9.jsp").include(request, response);
		//response.getWriter().write("hahaha<br/>");
		//request.getRequestDispatcher("/public/footDemo9.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
