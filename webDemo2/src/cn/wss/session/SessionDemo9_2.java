package cn.wss.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionDemo9_2
 */
@WebServlet("/SessionDemo9_2")
public class SessionDemo9_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDemo9_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//У����֤���Ƿ���Ч������demo9.html�ύ�����ı���Ϣ
		request.setCharacterEncoding("UTF-8");
		String c_checkcode = request.getParameter("checkcode");
		String s_checkcode = (String) request.getSession().getAttribute("checkcode");
		if(c_checkcode!=null && s_checkcode!=null && c_checkcode.equals(s_checkcode)){
			System.out.println("����ע������!!");
		}else{
			System.out.println("�������"+c_checkcode+",��������"+s_checkcode);
			System.out.println("��֤����󣡣�");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
