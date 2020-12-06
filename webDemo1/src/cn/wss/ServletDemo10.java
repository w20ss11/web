package cn.wss;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo10
 */
@WebServlet("/ServletDemo10")
public class ServletDemo10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo10() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//��ַд��
		//1.�����ַ���������ã�/��ʾwebӦ��	  requestת��
		//request.getRequestDispatcher("/demo4.html").forward(request, response);
		//2.�����ַ��������ã�/��ʾ��վ        	  response�ض���
		//response.sendRedirect("/webDemo/demo4.html");
		//3.����������ȡ��Դ����·��
		//this.getServletContext().getRealPath("/demo4.html");
		//4.����������ȡ��Դ��ַ
		//this.getServletContext().getResourcePaths("/demo4.html");
		//5.
		/* <a href="/webDemo/demo4.html">���</a>
		 * <form action="/webDemo/demo4.html">
		 * </form>
		 * */
		
			//������
		String referer = request.getHeader("referer");
		if(referer==null || !referer.startsWith("http://localhost")){
			response.sendRedirect("/webDemo/index.html");
			return;
		}
		String data = "����ռ�";
		response.setCharacterEncoding("UTF-8");//response �������д���������
		response.setHeader("content-type", "text/html;charset=UTF-8");//�������ʲô���򿪷����͵�����
		response.getWriter().write(data);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
