package cn.wss.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class Demo4_HelloSimpleTag implements SimpleTag {

	
	private String value;
	private String count;
	private PageContext pageContext;
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setCount(String count) {
		this.count = count;
	}
	
	//��ǩ���߼�ʵ��Ӧ�ñ�д���÷�����. 
	@Override
	public void doTag() throws JspException, IOException {
		pageContext.getOut().write("hello");
//		System.out.println("value: " + value  + ", count: " + count);
//		
//		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
//		pageContext.getOut().print("Hello: " + request.getParameter("name"));
		
		JspWriter out = pageContext.getOut();
		int c = 0;
		
		c = Integer.parseInt(count);
		for(int i = 0; i < c; i++){
			out.print((i + 1) + ": " + value);
			out.print("<br>");
		}

	}

	@Override
	public JspTag getParent() {
		System.out.println("getParent");
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("setJspBody");

	}
	
	//JSP �������, �Ѵ��� JSP ҳ��� PageContext ������
	//PageContext ���Ի�ȡ JSP ҳ������� 8 ����������. 
	//���Է��� JSP ҳ��������ı�ǩ���������������. 
	@Override
	public void setJspContext(JspContext arg0) {
		System.out.println(arg0 instanceof PageContext);  
		this.pageContext = (PageContext) arg0;
		System.out.println("setJspContext");

	}

	@Override
	public void setParent(JspTag arg0) {
		System.out.println("setParent");

	}

}
