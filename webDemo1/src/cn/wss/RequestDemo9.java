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
			//request ת����demo9.jsp ��������reques��洢���ݴ���jsp
		String data = "aabaa";
		request.setAttribute("data", data);
		request.getRequestDispatcher("/demo9.jsp").forward(request, response);
		
			//request ת��ʧ�ܰ���
		//String data = "aaa";
		//PrintWriter writer = response.getWriter();
		//writer.write(data);
		//writer.close();
		//writer�Ѿ�close request������ת�� �������ᱨ��
		//request.getRequestDispatcher("/demo9.jsp").forward(request, response);
		
			//requset forward����ִ�к�ԭ��д��response��������������ݻᱻ���
		//String data = "ccccc";
		//response.getWriter().write(data);
		//request.getRequestDispatcher("/index.html").forward(request, response);
		
			//reqyest getRequestDispatcher.include����������˰�������
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
