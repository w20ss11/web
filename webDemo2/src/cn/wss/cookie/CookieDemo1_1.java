package cn.wss.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.chart.PieChart.Data;

/**
 * Servlet implementation class CookieDemo1
 */
@WebServlet("/CookieDemo1_1")
public class CookieDemo1_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo1_1() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//���ʴ�Servlet��ʾ�ϴη���ʱ��
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<a href='/webDemo2/CookieDemo1_2'>����ϴη���ʱ��</a><br/>");
		out.print("���ϴη��ʵ�ʱ���ǣ�");
		
		//��ȡ�û���ʱ��cookie
		Cookie cookies[] = request.getCookies();
		for(int i=0;cookies!=null && i<cookies.length;i++){
			if(cookies[i].getName().equals("lastAccessTime")){
				long cookieValue = Long.parseLong(cookies[i].getValue());//�õ����û����ϴη���ʱ��
				Date date = new Date(cookieValue);
				out.print(date.toLocaleString());
			}
		}
		//���û��������µķ���ʱ��
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
		cookie.setMaxAge(1*30*24*3600);//һ����
		cookie.setPath("/webDemo2");
		
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
