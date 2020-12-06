package cn.wss;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo5
 */
@WebServlet("/ResponseDemo5")
public class ResponseDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//response 控制浏览器定时刷新
		//response.setHeader("refresh", "3");
		//String data = new Random().nextInt(10000)+"";
		//response.getWriter().write(data);
		
			//response 设置3秒后自动跳转
		//response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html;charset=UTF-8");
		//response.setHeader("refresh", "3;url='/webDemo/index.html'");
		//response.getWriter().write("恭喜你，登录成功，本浏览器将在3秒后，跳到首页，如果没有跳转，请点击<a href=''>超链接</a>");
		
			//reponse 转发到jsp 再跳转到主页
		//假设程序运行到此，用户登录成功了
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String message = "<meta http-equiv='refresh' content='3;url='/webDemo/index.html'>恭喜登录成功，本浏览器将在3秒后，跳到首页，如果没有跳转，请点击<a href='/webDemo/index.html'>超链接</a>";
		this.getServletContext().setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/demo5.jsp").forward(request, response);
		
			//response 控制缓存时间
		//response.setDateHeader("expries", System.currentTimeMillis()+1000*3600);//控制缓存1个小时
		//String data = "aaaaaaaa";
		//response.getWriter().write(data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
