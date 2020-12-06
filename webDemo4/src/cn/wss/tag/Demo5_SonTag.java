package cn.wss.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo5_SonTag extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		//1. �õ�����ǩ������
		JspTag parent = getParent();
		
		//2. ��ȡ����ǩ�� name ����
		Demo5_ParentTag parentTag = (Demo5_ParentTag) parent;
		String name = parentTag.getName();
		
		//3. �� name ֵ��ӡ�� JSP ҳ����.
		getJspContext().getOut().print("�ӱ�ǩ���name: " + name);
	}
	
}
