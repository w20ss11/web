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
			//response �����������ʱˢ��
		//response.setHeader("refresh", "3");
		//String data = new Random().nextInt(10000)+"";
		//response.getWriter().write(data);
		
			//response ����3����Զ���ת
		//response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html;charset=UTF-8");
		//response.setHeader("refresh", "3;url='/webDemo/index.html'");
		//response.getWriter().write("��ϲ�㣬��¼�ɹ��������������3���������ҳ�����û����ת������<a href=''>������</a>");
		
			//reponse ת����jsp ����ת����ҳ
		//����������е��ˣ��û���¼�ɹ���
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String message = "<meta http-equiv='refresh' content='3;url='/webDemo/index.html'>��ϲ��¼�ɹ��������������3���������ҳ�����û����ת������<a href='/webDemo/index.html'>������</a>";
		this.getServletContext().setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/demo5.jsp").forward(request, response);
		
			//response ���ƻ���ʱ��
		//response.setDateHeader("expries", System.currentTimeMillis()+1000*3600);//���ƻ���1��Сʱ
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
