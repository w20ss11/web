package cn.wss.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo2_2
 */
@WebServlet("/CookieDemo2_2")
public class CookieDemo2_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo2_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//显示商品浏览历史记录
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//根据用户带过来的id，显示相应商品的详细信息
		String id = request.getParameter("id");
		//System.out.println("从主页带过来的id:"+id);
		Book book = Db.getAll().get(id);
		out.write(book.getId() + "<br/>");
		out.write(book.getAuthor() + "<br/>");
		out.write(book.getName() + "<br/>");
		out.write(book.getDescription() + "<br/>");
		
		//构建cookie，回写给浏览器
		String cookieValue = buildCookie(id, request);
		//System.out.println("cookieValue:"+cookieValue);
		Cookie cookie = new Cookie("bookHistory", cookieValue);
		cookie.setMaxAge(1*30*24*3600);//一个月
		cookie.setPath("/webDemo2");
		response.addCookie(cookie);
		
	}

	private String buildCookie(String id, HttpServletRequest request) {
		//bookHistory=null		1	1
		//bookHistory=2,5,1		1	1,2,5
		//bookHistory=2,5,4		1	1,2,5
		//bookHistory=2,5		1	1,2,5
		String bookHistory = null;
		Cookie cookies[] = request.getCookies();
		for(int i=0;cookies!=null && i<cookies.length;i++){
			if(cookies[i].getName().equals("bookHistory")){
				bookHistory = cookies[i].getValue();
			}
		}
		//bookHistory=null		1	1
		if(bookHistory==null){
			return id;
		}
		LinkedList<String> list = new LinkedList<>(Arrays.asList(bookHistory.split("\\_")));
		/*
		if(list.contains(id)){
			//bookHistory=2,5,1		1	1,2,5
			list.remove(id);
			list.addFirst(id);
		}else{
			//bookHistory=2,5,4		1	1,2,5
			if(list.size()>=3){
				list.removeLast();
				list.addFirst(id);
			}else{
				//bookHistory=2,5		1	1,2,5
				list.addFirst(id);
			}
		}*/
		if(list.contains(id)){
			list.remove(id);
		}else{
			if(list.size()>=3){
				list.removeLast();
			}
		}
		list.addFirst(id);
		StringBuffer sb = new StringBuffer();
		for(String bid : list){
			sb.append(bid+"_");
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
