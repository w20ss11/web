package cn.wss.mvc.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wss.mvc.dao.CriteriaUser;
import cn.wss.mvc.dao.UserDao;
import cn.wss.mvc.dao.factory.UserDAOFactory;
import cn.wss.mvc.domain.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(
		displayName = "/UserServlet", //����  
		name = "ServletDemo1", //servlet����  
		urlPatterns = { "/ServletDemo1","*.do" },//url  
		initParams = { @WebInitParam(name = "data", value = "xxxx") })//��ʼ������ )
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private UserDao userDao = new UserDAOJdbcImpl();
	private UserDao userDao = 
			UserDAOFactory.getInstance().getUserDAO();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	String method = request.getParameter("method");
	//	switch(method){
	//		case "add":    add(request, response); break;
	//		case "query":  query(request, response); break;
	//		case "delete": delete(request, response); break;
	//		case "update": update(request, response); break;
	//	}
	//}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. ��ȡ ServletPath: /edit.do �� /addCustomer.do
		String servletPath = request.getServletPath();

		//2. ȥ�� / �� .do, �õ������� edit �� addCustomer �������ַ���
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 3);

		System.out.println(methodName);
		try {
			//3. ���÷����ȡ methodName ��Ӧ�ķ���
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, 
					HttpServletResponse.class);
			//4. ���÷�����ö�Ӧ�ķ���
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			//������һЩ��Ӧ.
			response.sendRedirect("error.jsp");
		}
	}
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//��ȡģ����ѯ���������
		String name = request.getParameter("name");
		String psd = request.getParameter("psd");
		String balStr = request.getParameter("balance");
		Integer balance;
		if(balStr=="" || balStr==null)
			balance = -1;
		else
			balance = Integer.parseInt(balStr);
			
		//�����������װΪһ�� CriteriaCustomer ����
		CriteriaUser cu = new CriteriaUser(name, psd, balance);
		//1. ���� CustomerDAO �� getForListWithCriteriaCustomer() �õ� Customer �ļ���
		List<User> users = userDao.getForListWithCriteriaUser(cu);

		//2. �� Customer �ļ��Ϸ��� request ��
		request.setAttribute("users", users);

		//3. ת��ҳ�浽 index.jsp(����ʹ���ض���)
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	private void edit(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{

		String forwardPath = "/error.jsp";

		//1. ��ȡ������� id
		String idStr = request.getParameter("id");

		//2. ���� CustomerDAO �� customerDAO.get(id) ��ȡ�� id ��Ӧ�� Customer ���� customer
		try {
			User user = userDao.get(Integer.parseInt(idStr));
			if(user != null){
				forwardPath = "/updateuser.jsp";
				//3. �� customer ���� request ��
				request.setAttribute("user", user);
			}
		} catch (NumberFormatException e) {} 


		//4. ��Ӧ updatecustomer.jsp ҳ��: ת��.
		request.getRequestDispatcher(forwardPath).forward(request, response);

	}

	private void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		//1. ��ȡ������: id, name, address, phone, oldName
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String psd = request.getParameter("psd");
		Integer balance = Integer.parseInt(request.getParameter("balance"));
		String oldName = request.getParameter("oldName");

		//2. ���� name �Ƿ��Ѿ���ռ��:

		//2.1 �Ƚ� name �� oldName �Ƿ���ͬ, ����ͬ˵�� name ����. 
		//2.1 ������ͬ, ����� CustomerDAO �� getCountWithName(String name) ��ȡ name �����ݿ����Ƿ����
		if(!oldName.equalsIgnoreCase(name)){
			long count = userDao.getCountWithName(name);
			//2.2 ������ֵ���� 0, ����Ӧ updatecustomer.jsp ҳ��: ͨ��ת���ķ�ʽ����Ӧ newcustomer.jsp
			if(count > 0){
				//2.2.1 �� updatecustomer.jsp ҳ����ʾһ��������Ϣ: �û��� name �Ѿ���ռ��, ������ѡ��!
				//�� request �з���һ������ message: �û��� name �Ѿ���ռ��, ������ѡ��!, 
				//��ҳ����ͨ�� request.getAttribute("message") �ķ�ʽ����ʾ
				request.setAttribute("message", "�û���" + name + "�Ѿ���ռ��, ������ѡ��!");

				//2.2.2 newcustomer.jsp �ı�ֵ���Ի���. 
				//address, phone ��ʾ�ύ�����µ�ֵ, �� name ��ʾ oldName, ���������ύ�� name

				//2.2.3 ��������: return 
				request.getRequestDispatcher("/updateuser.jsp").forward(request, response);
				return;
			}
		}

		//3. ����֤ͨ��, ��ѱ�������װΪһ�� Customer ���� customer
		User user = new User(name, psd, balance);
		user.setId(Integer.parseInt(id)); 

		//4. ���� CustomerDAO ��  update(Customer customer) ִ�и��²���
		userDao.update(user);

		//5. �ض��� query.do
		response.sendRedirect("query.do");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idStr = request.getParameter("id");
		int id = 0;

		//try ... catch ������: ��ֹ idStr ����תΪ int ����
		//������ת�� id = 0, �޷������κε�ɾ������. 
		try {
			id = Integer.parseInt(idStr);
			System.out.println(id); 
			userDao.delete(id);
		} catch (Exception e) {}

		response.sendRedirect("query.do");
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1. ��ȡ������: name, address, phone
		String name = request.getParameter("name");
		String psd = request.getParameter("psd");
		Integer balance = Integer.parseInt(request.getParameter("balance"));

		//2. ���� name �Ƿ��Ѿ���ռ��:

		//2.1 ���� CustomerDAO �� getCountWithName(String name) ��ȡ name �����ݿ����Ƿ����
		long count = userDao.getCountWithName(name);

		//2.2 ������ֵ���� 0, ����Ӧ newcustomer.jsp ҳ��: 
		//ͨ��ת���ķ�ʽ����Ӧ newcustomer.jsp
		if(count > 0){
			//2.2.1 Ҫ���� newcustomer.jsp ҳ����ʾһ��������Ϣ: �û��� name �Ѿ���ռ��, ������ѡ��!
			//�� request �з���һ������ message: �û��� name �Ѿ���ռ��, ������ѡ��!, 
			//��ҳ����ͨ�� request.getAttribute("message") �ķ�ʽ����ʾ
			request.setAttribute("message", "�û���" + name + "�Ѿ���ռ��, ������ѡ��!");

			//2.2.2 newcustomer.jsp �ı�ֵ���Ի���. 
			//ͨ�� value="<%= request.getParameter("name") == null ? "" : request.getParameter("name") %>"
			//�����л���
			//2.2.3 ��������: return 
			request.getRequestDispatcher("/newUser2.jsp").forward(request, response);
			return;
		}

		//3. ����֤ͨ��, ��ѱ�������װΪһ�� Customer ���� customer
		User user = new User(name, psd, balance);

		//4. ���� CustomerDAO ��  save(Customer customer) ִ�б������
		userDao.save(user);

		//5. �ض��� success.jsp ҳ��: ʹ���ض�����Ա�����ֱ����ظ��ύ����.  
		response.sendRedirect("success.jsp");
		//request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

}
