package cn.wss.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionDemo8_2
 */
@WebServlet("/SessionDemo8_2")
public class SessionDemo8_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDemo8_2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//处理表单
		boolean b = isTokenValid(request);
		if(!b){
			System.out.println("请不要重复提交！");
			return;
		}
		request.getSession().removeAttribute("token");
		String username = request.getParameter("username");
		System.out.println("向数据库中注册用户:"+username+"！");
	}

	private boolean isTokenValid(HttpServletRequest request) {
		String client_token = request.getParameter("token");
		if(client_token==null){
			return false;
		}
		String server_token = (String) request.getSession().getAttribute("token");
		if(server_token==null){
			return false;
		}
		if(!client_token.equals(server_token)){
			return false;
		}
		return true;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
