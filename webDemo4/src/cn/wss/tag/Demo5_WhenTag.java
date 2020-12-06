package cn.wss.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo5_WhenTag extends SimpleTagSupport{

	private boolean test;
	
	public void setTest(boolean test) {
		this.test = test;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		if(test){
			
			Demo5_ChooseTag chooseTag = (Demo5_ChooseTag) getParent();
			boolean flag = chooseTag.isFlag();
			
			if(flag){
				getJspBody().invoke(null);
				chooseTag.setFlag(false);
			}
			
		}
	}
	
}
