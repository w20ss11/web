package cn.wss;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo8
 */
@WebServlet("/RequestDemo8")
public class RequestDemo8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo8() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//request ��html�ύ��servlet�������������� post
//		String username = request.getParameter("username");
//		username = new String(username.getBytes("iso8859-1"),"UTF-8");//post���� jre��iso8859 �������utf-8
//		System.out.println(username);
		
			//request ��html�ύ��servlet�������������� get
//		String username = request.getParameter("username");
//		request.setCharacterEncoding("UTF-8");
//		System.out.println(username);
		
			//����request ��html��ȡ��request �ٴ�responseд��
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		response.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=gb2312");
		response.getWriter().write(username);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
