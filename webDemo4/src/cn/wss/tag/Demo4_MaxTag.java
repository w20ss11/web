package cn.wss.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo4_MaxTag extends SimpleTagSupport {
	private String num1;
	private String num2;
	
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	
	public void setNum2(String num2) {
		this.num2 = num2;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		int a = 0;
		int b = 0;
		
		PageContext pageContext = (PageContext) getJspContext();
		
		JspWriter out = pageContext.getOut();
		
		try {
			a = Integer.parseInt(num1);
			b = Integer.parseInt(num2);
			out.print(a > b ? a : b);
		} catch (Exception e) {
			out.print("��������Եĸ�ʽ����ȷ!");
		}
		
	}
}
