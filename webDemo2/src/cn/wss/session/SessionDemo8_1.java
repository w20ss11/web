package cn.wss.session;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class SessionDemo8_1
 */
@WebServlet("/SessionDemo8_1")
public class SessionDemo8_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDemo8_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//������
		//��������������ţ�
		TokenProcessor tp = TokenProcessor.getInstance();
		String token = tp.generateToken();
		request.getSession().setAttribute("token", token);
		request.getRequestDispatcher("/demo8.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
class TokenProcessor{	//����
	/**�������ģʽ
	 * 1.�ѹ��췽��˽�� 2.�Լ�����һ�� 3.���Ⱪ¶һ�������������ȡ���洴���Ķ���
	 */
	private TokenProcessor(){}
	private static final TokenProcessor instance = new TokenProcessor();
	public static TokenProcessor getInstance(){
		return instance;
	}
	public String generateToken(){
		String token = System.currentTimeMillis() + new Random().nextInt() +"";
		try{
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] md5 = md.digest(token.getBytes());
			//base64����
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}