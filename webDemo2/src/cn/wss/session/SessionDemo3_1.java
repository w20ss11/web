package cn.wss.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo3_1
 */
@WebServlet("/SessionDemo3_1")
public class SessionDemo3_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDemo3_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//购买洗衣机(两行 第一行与最后一行代码)
		HttpSession session = request.getSession();
			//浏览器访问服务器，服务器创建session，复写服务器回写给浏览器的cookie，因为默认的cookie没有设置有效期，下次开浏览器，购买的洗衣机记录也就没了
		String sessionid = session.getId();
		Cookie cookie = new Cookie("JSESSIONID", sessionid);
		cookie.setPath("/webDemo2");
		cookie.setMaxAge(30*60);//半个小时
		response.addCookie(cookie);
		session.setAttribute("name", "洗衣机");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
