package cn.wss.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionDemo5_1
 */
@WebServlet("/SessionDemo5_1")
public class SessionDemo5_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDemo5_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//��վ��ҳ���г�������
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//�����վ������Ʒ
		out.write("SessionDemo5_1��<br/>");
		out.write("����վ��������Ʒ��<br/>");
		Map<String, Book> map = Db.getAll();
		for(Map.Entry<String, Book> entry : map.entrySet()){
			Book book = entry.getValue();
			String url = response.encodeURL("/webDemo2/SessionDemo5_2?id="+book.getId());
			out.print(book.getName()+"<a href='"+url+"' target='_blank'>����</a><br/>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
