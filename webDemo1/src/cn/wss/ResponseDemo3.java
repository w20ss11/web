package cn.wss;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tool.ToolDemo2;

/**
 * Servlet implementation class ServletDemo3
 */
@WebServlet("/ServletDemo3")
public class ResponseDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ServletContext context = this.getServletContext();
			
		
			//response outputstream输出中文 
		//String data = "中国<br />";
		//OutputStream out = response.getOutputStream();
		 //2. 设置浏览器用utf-8打开
		//out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());
		//out.write(data.getBytes("UTF-8"));//1. 服务器使用utf-8传输
		
			//response writer输出中文
//		response.setCharacterEncoding("UTF-8");//response 向浏览器写出数据码表
//		response.setHeader("content-type", "text/html;charset=UTF-8");//浏览器用什么码表打开服务发送的数据
//		response.setContentType("text/html;charset=UTF-8");
//		String data = "中国<br />";
//		PrintWriter pr = response.getWriter();
//		pr.write(data);
		
			//response实现下载文件
		String path = this.getServletContext().getRealPath("/download/中文名.jpg");
		String filename = path.substring(path.lastIndexOf("\\")+1);//timg.jpg
		//response.setHeader("content-disposition", "attachment;filname="+filename);
		response.setHeader("content-disposition", "attachment;filname="+URLEncoder.encode(filename,"UTF-8"));
		System.out.println(filename);
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try{
			inputStream = new FileInputStream(path);
			int len = 0;
			byte buffer[] = new byte[1024];
			outputStream = response.getOutputStream();
			while((len = inputStream.read(buffer)) >0){
				outputStream.write(buffer,0,len);
			}
		}finally {
			if(inputStream != null){
				try{
					inputStream.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null)
				outputStream.close();
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
