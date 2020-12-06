package cn.wss.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo2
 */
@WebServlet("/CookieDemo2_1")
public class CookieDemo2_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo2_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//��ʾ��Ʒ�����ʷ��¼
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//1.�����վ������Ʒ
		out.write("CookieDemo2_1<br/>");
		out.write("����վ��������Ʒ��<br/>");
		Map<String, Book> map = Db.getAll();
		for(Map.Entry<String, Book> entry : map.entrySet()){
			Book book = entry.getValue();
			out.print("<a href='/webDemo2/SessionDemo5_2?id="+book.getId()+"' target='_blank'>"+book.getName()+"</a><br/>");
		}
		
		//2.��ʾ�û�������������Ʒ
		out.print("����������������Ʒ��<br/>");
		Cookie cookie[] = request.getCookies();
		for(int i=0;cookie!=null && i<cookie.length;i++){
			if(cookie[i].getName().equals("bookHistory")){
				String ids[] = cookie[i].getValue().split("\\_"); //3,2,1
				for(String id:ids){
					Book book = Db.getAll().get(id);
					out.print(book.getName()+"<br/>");
				}
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
class Db{
	private static Map<String,Book> map = new LinkedHashMap<>();
	static{
		map.put("1", new Book("1", "javaweb����", "����", "web������������"));
		map.put("2", new Book("2", "jdbc����", "����", "jdbc������������"));
		map.put("3", new Book("3", "spring����", "����", "spring������������"));
		map.put("4", new Book("4", "structs����", "����", "structs������������"));
		map.put("5", new Book("5", "android����", "����", "android������������"));
	}
	public static Map<String, Book> getAll(){
		return map;
	}
}
class Book{
	private String id;
	private String name;
	private String author;
	private String description;
	public Book() {}
	public Book(String id,String name,String author,String description) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
