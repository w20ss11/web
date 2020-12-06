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
			//����servlet
		String id = request.getParameter("id");
		Book book = Db.getAll().get(id);
		
		HttpSession session = request.getSession();
		//�ֹ���cookie��ʽ��sessionid���Խ���ر���������ϴι���Ķ���û����
		//ûд
		
		//��session�õ��û����ڱ���������ļ��ϣ����ﳵ��
		@SuppressWarnings("unchecked")
		List<Book> list = (List<Book>) session.getAttribute("list");
		if(list==null){
			list = new ArrayList<>();
			session.setAttribute("list", list);
		}
		list.add(book);
		//1.ʹ��ת��ʱ���������ˢ�£�����id������һ��
		//request.getRequestDispatcher("/SessionDemo5_3").forward(request, response);
		//2.�ض���
		//response.sendRedirect(request.getContextPath()+"/SessionDemo5_3");
		//3.����encodeurl��ֹ�û��ر�cookie
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
