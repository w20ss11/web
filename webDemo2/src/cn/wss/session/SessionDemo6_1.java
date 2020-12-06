package cn.wss.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SessionDemo6_1
 */
@WebServlet("/SessionDemo6_1")
public class SessionDemo6_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDemo6_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//处理demo6.html的登录表单 login
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		List<UserDemo6> list = DataBase.getAll();
		for(UserDemo6 user:list){
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				request.getSession().setAttribute("user", user);//登录成功，向session存入一个登录标记
				response.sendRedirect("/webDemo2/index.jsp");
				return;
			}
		}
		out.write("用户名或密码不对！<br/>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
class DataBase{
	public static List<UserDemo6> list = new ArrayList<>();
	static{
		list.add(new UserDemo6("aaa", "123"));
		list.add(new UserDemo6("bbb", "123"));
		list.add(new UserDemo6("ccc", "123"));
	}
	public static List<UserDemo6> getAll(){
		return list;
	}
}