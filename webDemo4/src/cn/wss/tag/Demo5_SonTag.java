package cn.wss.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo5_SonTag extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		//1. 得到父标签的引用
		JspTag parent = getParent();
		
		//2. 获取父标签的 name 属性
		Demo5_ParentTag parentTag = (Demo5_ParentTag) parent;
		String name = parentTag.getName();
		
		//3. 把 name 值打印到 JSP 页面上.
		getJspContext().getOut().print("子标签输出name: " + name);
	}
	
}
