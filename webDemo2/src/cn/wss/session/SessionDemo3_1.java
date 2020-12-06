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
			//����ϴ�»�(���� ��һ�������һ�д���)
		HttpSession session = request.getSession();
			//��������ʷ�����������������session����д��������д���������cookie����ΪĬ�ϵ�cookieû��������Ч�ڣ��´ο�������������ϴ�»���¼Ҳ��û��
		String sessionid = session.getId();
		Cookie cookie = new Cookie("JSESSIONID", sessionid);
		cookie.setPath("/webDemo2");
		cookie.setMaxAge(30*60);//���Сʱ
		response.addCookie(cookie);
		session.setAttribute("name", "ϴ�»�");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
