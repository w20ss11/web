package cn.wss.filter.content;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequest extends HttpServletRequestWrapper{

	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		String val = super.getParameter(name);
		if(val != null && val.contains(" fuck ")){
			val = val.replace("fuck", "****");
			System.out.println("getParameter");
		}
		return val;
	}
}
