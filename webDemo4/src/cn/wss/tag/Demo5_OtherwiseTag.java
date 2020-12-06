package cn.wss.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo5_OtherwiseTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		Demo5_ChooseTag chooseTag = (Demo5_ChooseTag) getParent();
		
		if(chooseTag.isFlag()){
			getJspBody().invoke(null);
		}
	}
	
}
