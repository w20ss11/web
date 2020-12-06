package cn.wss.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo5_ParentTag extends SimpleTagSupport {
	
	private String name = "www.wss.com";
	
	public String getName() {
		return name;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("父标签的标签处理器类 name: " + name);
		getJspBody().invoke(null);
	}
	
}
