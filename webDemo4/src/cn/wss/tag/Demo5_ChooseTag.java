package cn.wss.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo5_ChooseTag extends SimpleTagSupport {
	
	private boolean flag = true;
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public boolean isFlag() {
		return flag;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(null);
	}
}
