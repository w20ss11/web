package cn.wss.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo5_2
 */
@WebServlet("/SessionDemo5_2")
public class SessionDemo5_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDemo5_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//购买servlet
		String id = request.getParameter("id");
		Book book = Db.getAll().get(id);
		
		HttpSession session = request.getSession();
		//手工以cookie形式发sessionid，以解决关闭浏览器后，上次购买的东西没有了
		//没写
		
		//从session得到用户用于保存所有书的集合（购物车）
		@SuppressWarnings("unchecked")
		List<Book> list = (List<Book>) session.getAttribute("list");
		if(list==null){
			list = new ArrayList<>();
			session.setAttribute("list", list);
		}
		list.add(book);
		//1.使用转发时，在浏览器刷新，会让id书再买一次
		//request.getRequestDispatcher("/SessionDemo5_3").forward(request, response);
		//2.重定向
		//response.sendRedirect(request.getContextPath()+"/SessionDemo5_3");
		//3.设置encodeurl防止用户关闭cookie
		String url = response.encodeRedirectURL(request.getContextPath()+"/SessionDemo5_3");
		response.sendRedirect(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
